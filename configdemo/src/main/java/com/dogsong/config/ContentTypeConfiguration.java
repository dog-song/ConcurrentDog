package com.dogsong.config;

import com.dogsong.annotation.ContentTypeMethodProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import java.util.List;

/**
 * ContentTypeConfiguration
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
@Configuration
public class ContentTypeConfiguration {

    @Bean
    public MyMvcConfigurer mvcConfigurer() {
        return new MyMvcConfigurer();
    }

    public static class MyMvcConfigurer implements WebMvcConfigurer {

        @Override
        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
            resolvers.add(new ContentTypeMethodProcessor());
        }

    }

}
