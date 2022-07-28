package com.dogsong.dubbospi.common;

/**
 * TestProtocol
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class TestProtocol implements IProtocol {

    @Override
    public void sendRequest(String message) {
        //示意代码，省略实现细节
        System.out.println("使用TEST发送消息：" + message);
    }
}
