package com.dogsong.adapter.controller;

import com.dogsong.adapter.common.context.ParamContext;
import com.dogsong.adapter.process.ParamProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * AdapterController
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/29
 */
@RestController
@Slf4j
public class AdapterController {

    @Autowired
    private ParamProcessor paramProcessor;

    @PostMapping("/test/adapter")
    public ParamContext test(@RequestBody Map paramMap) {
        ParamContext paramContext = new ParamContext();

        paramProcessor.invoke(paramContext);

        return paramContext;
    }

}
