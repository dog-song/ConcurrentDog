package com.dogsong.liteflow.controller;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * DemoController
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/12/14
 */
@Slf4j
@RestController
public class DemoController {

    @Resource
    private FlowExecutor flowExecutor;


    @PostMapping("/testConfig")
    public void testConfig(@RequestBody Map paramMap) {
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");

        log.info("----> {}", response);
    }

    @PostMapping("/testConfig22")
    public String testConfig2(@RequestBody String str) {
        System.out.println("11111");
        return "1111";
    }

}
