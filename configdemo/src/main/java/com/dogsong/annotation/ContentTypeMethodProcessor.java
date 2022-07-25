package com.dogsong.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * ContentTypeMethodProcessor
 *
 * 其流程为，spring 启动的时候，ContentTypeConfiguration 调用 addArgumentResolvers 方法将 ContentTypeMethodProcessor 注入，
 * 接到请求时，supportsParameter 方法判断是否使用此 resolver，如果为 true，则进入 resolveArgument 方法执行。
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class ContentTypeMethodProcessor implements HandlerMethodArgumentResolver {

    private ServletModelAttributeMethodProcessor formResolver;

    private RequestResponseBodyMethodProcessor jsonResolver;

    public ContentTypeMethodProcessor() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FormHttpMessageConverter());

        this.formResolver = new ServletModelAttributeMethodProcessor(true);
        this.jsonResolver = new RequestResponseBodyMethodProcessor(messageConverters);
    }


    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        ContentTypeParser annotation = methodParameter.getParameterAnnotation(ContentTypeParser.class);

        return annotation != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        ServletRequest servletRequest = nativeWebRequest.getNativeRequest(ServletRequest.class);
        String contentType = servletRequest.getContentType();
        if (contentType == null) {
            throw new IllegalArgumentException("不支持contentType");
        }

        if (contentType.contains("application/json")) {
            return jsonResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);
        }

        if (contentType.contains("application/x-www-form-urlencoded")) {
            return formResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);
        }

        if (contentType.contains("multipart")) {
            return formResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);
        }

        throw new IllegalArgumentException("不支持contentType");
    }

}
