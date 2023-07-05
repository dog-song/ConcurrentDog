package com.dogsong.controller;

import com.dogsong.domain.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TestController
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/23
 */
@Controller
public class TestController {

    @PostMapping("/test")
    public String paramsTest(Model model, @RequestBody User user) {
        model.addAttribute("user", user);
        return "test";
    }

}
