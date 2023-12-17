package com.dogsong.future;

import java.util.concurrent.*;

/**
 * ConnectionPool
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/9/27
 */
public class ConnectionPool {

    private ConcurrentHashMap<String, FutureTask<Connection>> pool = new ConcurrentHashMap<>();

    public Connection getConnection(String key) throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask<Connection> connectionTask = pool.get(key);

        if (connectionTask != null) {
            return connectionTask.get();
        } else {
            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    return createConnection();
                }
            };

            FutureTask<Connection> newTask = new FutureTask<>(callable);
            // 虽然三个线程都创建了FutureTask,但是只有一个放入ConcurrentHashMap
            // putIfAbsent方法：当指定的key没有映射值，则与给定的值进行映射，并返回null，否则返回当前值。
            connectionTask = pool.putIfAbsent(key, newTask);
            if (connectionTask == null) {
                connectionTask = newTask;
                // 异步创建链接
                connectionTask.run();
            }
            // 等待链接创建完成
            connectionTask.get(1000, TimeUnit.MILLISECONDS);
            return connectionTask.get();
        }
    }

    public Connection createConnection() {
        return new Connection();
    }

    class Connection {
    }
}
