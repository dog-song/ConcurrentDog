package com.dogsong.javaspi.protocol.tcp;

import com.dogsong.interfance.IProtocol;

/**
 * TcpProtocol
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/19
 */
public class TcpProtocol implements IProtocol {

    /**
     * 发送请求
     *
     * @param message msg
     */
    @Override
    public void sendRequest(String message) {
        System.out.println("使用TCP发送消息: " + message);
    }
}
