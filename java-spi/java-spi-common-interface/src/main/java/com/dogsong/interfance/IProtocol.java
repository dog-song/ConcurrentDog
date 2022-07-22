package com.dogsong.interfance;

/**
 * 通讯协议接口
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/19
 */
public interface IProtocol {

    /** 发送请求 */
    void sendRequest(String message);

}
