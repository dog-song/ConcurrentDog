package com.dogsong.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.dogsong.domain.pojo.DeviceMessage;
import com.dogsong.domain.pojo.Request;
import com.dogsong.domain.pojo.User;
import com.dogsong.service.GeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Test2Controller
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/23
 */
@Slf4j
@RestController
public class Test2Controller {

    @Autowired
    private GeneratorService generatorService;

    @PostMapping("/test2")
    @ResponseBody
    public Map test(@RequestBody Request request) {

        JSONUtil.parseObj(request);

        return generatorService.getResultByParams(BeanUtil.beanToMap(request));
    }

    @PostMapping(value = "/xml", consumes = "application/xml", produces = "application/json")
    @ResponseBody
    public Map test2(@RequestBody DeviceMessage deviceMessage) {
        log.info(deviceMessage.toString());
        return generatorService.getResultByParams(BeanUtil.beanToMap(deviceMessage));
    }

    @PostMapping(value = "/json", consumes = "application/xml", produces = "application/xml")
    @ResponseBody
    public User test3(@RequestBody DeviceMessage deviceMessage) {
        log.info(deviceMessage.toString());
        User user = new User();
        user.setAge(String.valueOf(deviceMessage.getId()));
        user.setName(deviceMessage.getMsg());
        return user;
    }

}
