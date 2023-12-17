package com.dogsong.liteflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * LiteFlowApplication
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/12/14
 */
@SpringBootApplication
@ComponentScan({"com.dogsong.liteflow"})
public class LiteFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiteFlowApplication.class, args);
    }

}
