package com.dogsong.b.thread;

/**
 * 锁消除, 例子: StringBuffer
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/4
 */
public class StringBufferWithoutSync {

    private void add(String str1, String str2) {
        // StringBuffer 是线程安全, 由于 sb 只会在 append 方法中使用, 不可能被其他线程引用
        // 因此 sb 属于不可能共享的资源, JVM 会自动消除内部的锁
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(str2);
    }


    public static void main(String[] args) {
        StringBufferWithoutSync stringBufferWithoutSync = new StringBufferWithoutSync();
        for (int i = 0; i < 1000; i ++) {
            stringBufferWithoutSync.add("aaa", "bbb");
        }
    }
}
