package com.dogsong.dubbospi.common;

/**
 * Http通讯协议
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class HttpProtocol implements IProtocol{

    @Override
    public void sendRequest(String message) {
        //示意代码，省略实现细节
        System.out.println("使用Http发送消息：" + message);
    }

}
