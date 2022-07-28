package com.dogsong.dubbospi.common;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * 通讯协议接口
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
@SPI
public interface IProtocol {

    @Adaptive
    void sendRequest(String message);

}
