package com.dogsong.util;

import com.dogsong.interfance.IProtocol;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * RequestUtil
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/19
 */
public class RequestUtil {

    /* 根据依赖倒置原则，这里依赖的是IProtocol接口，而不是具体的实现类。*/
    private IProtocol protocol;

    public void sendRequest(String message){
        // 根据里氏替换原则，这个protocol可以使用子类HttpProtocol或TcpProtocol替换
        protocol.sendRequest(message);
    }

    // 获取RequestUtil实例
    private static RequestUtil requestUtil;

    public static RequestUtil getInstance() {
        if (requestUtil == null) {
            requestUtil = new RequestUtil();
        }
        return requestUtil;
    }

    public RequestUtil() {
        // 初始化时，使用Java SPI初始化具体的协议实现类
        ServiceLoader<IProtocol> protocols = ServiceLoader.load(IProtocol.class);
        // 通过遍历获取实现类
        Iterator<IProtocol> iterator = protocols.iterator();
        if (iterator.hasNext()) {
            protocol = iterator.next();
        }
    }

    public RequestUtil(IProtocol protocol) {
        this.protocol = protocol;
    }

    public IProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(IProtocol protocol) {
        this.protocol = protocol;
    }
}
