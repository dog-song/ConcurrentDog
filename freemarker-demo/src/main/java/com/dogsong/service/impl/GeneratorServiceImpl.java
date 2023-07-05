package com.dogsong.service.impl;

import cn.hutool.json.JSONUtil;
import com.dogsong.domain.pojo.Response;
import com.dogsong.service.GeneratorService;
import com.dogsong.utils.FreemarkerUtil;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * GeneratorServiceImpl
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/24
 */
@Slf4j
@Service
@SuppressWarnings("all")
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private FreemarkerUtil freemarkerUtil;

    @Override
    public Map<String, Object> getResultByParams(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        String processString = null;

        try {
            processString = FreemarkerUtil.processString("response.ftl", params);

            String response = freemarkerUtil.processStringDB("response", params);
            log.info("processStringDB is {}.", response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
        result.put("responseJson", processString);
        Response response = JSONUtil.toBean(processString, Response.class);
        result.put("response", response);
        return result;
    }
}
