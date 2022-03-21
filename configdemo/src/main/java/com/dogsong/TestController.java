package com.dogsong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/19
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${testStr}")
    private String testStr;

    @GetMapping("/test")
    public String test() {
        return testStr;
    }
}

