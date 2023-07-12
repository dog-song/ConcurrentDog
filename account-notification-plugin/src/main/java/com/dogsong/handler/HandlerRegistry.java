package com.dogsong.handler;

import com.dogsong.common.NoticeHandlerException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/**
 * HandlerRegistry
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/12
 */
@Slf4j
@Component
public class HandlerRegistry implements BeanPostProcessor {


    private final ConcurrentMap<String, HandlerService> handlers = Maps.newConcurrentMap();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (!(bean instanceof HandlerService)) {
            return bean;
        }
        HandlerService handlerService = (HandlerService) bean;
        String transCode = handlerService.getTransCode();
        if (Objects.isNull(transCode)) {
            throw new NoticeHandlerException(String.format("TransCode cannot be null. class: %s", handlerService.getClass().getName()));
        }
        HandlerService oldHandler = handlers.putIfAbsent(transCode, handlerService);
        if (Objects.nonNull(oldHandler)) {
            throw new NoticeHandlerException(String.format("found duplicate TransCode: %s in class [%s] and [%s]",
                    transCode, handlerService.getClass().getName(), oldHandler.getClass().getName()));
        }
        return null;
    }

    public boolean containsKey(String transCode) {
        return handlers.containsKey(transCode);
    }

    public HandlerService getHandler(String transCode) {
        return handlers.get(transCode);
    }

}
