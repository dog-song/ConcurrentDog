package com.dogsong.dubbospi.basicusage;

import com.dogsong.dubbospi.common.IProtocol;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

/**
 * Dubbo-SPI
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class DubboSPI {

    public static void main(String[] args) {

        // IProtocol adaptiveExtension = ExtensionLoader.getExtensionLoader(IProtocol.class).getAdaptiveExtension();


        // 获取ExtensionLoader对象
        ExtensionLoader<IProtocol> extensionLoader = ExtensionLoader.getExtensionLoader(IProtocol.class);

        // 通过key获取对象的TcpProtocol
        IProtocol tcpProtocol = extensionLoader.getExtension("tcp");
        tcpProtocol.sendRequest("Hello!");

        // 通过key获取对象的HttpProtocol
        IProtocol httpProtocol = extensionLoader.getExtension("http");
        httpProtocol.sendRequest("Hello!");

        IProtocol test = extensionLoader.getExtension("test");
        test.sendRequest("1111");

        Set<String> extensions = extensionLoader.getSupportedExtensions();
        for (String e : extensions) {
            System.out.println(e);
        }

    }

}
