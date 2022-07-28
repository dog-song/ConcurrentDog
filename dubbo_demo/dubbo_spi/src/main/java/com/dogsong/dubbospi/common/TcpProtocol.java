package com.dogsong.dubbospi.common;

/**
 * tcp
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class TcpProtocol implements IProtocol {

    @Override
    public void sendRequest(String message) {
        //示意代码，省略实现细节
        System.out.println("使用TCP发送消息：" + message);
    }

}
