package com.dogsong.notice.Dispatch;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/9/13
 */
@Configuration
public class DispatchConfig {


    @Bean
    public DispatchService dispatchServiceProvider(ObjectProvider<DispatchService> objectProvider) {
        DispatchService available = objectProvider.getIfAvailable();
        if (available == null) {
            available = new DispatchServiceImpl();
        }
        return available;
    }

    @Bean
    public DispatchService dispatchServiceProvider2(ObjectProvider<DispatchService> objectProvider) {
        return objectProvider.getIfAvailable(DispatchServiceImpl::new);
    }

    @Bean
    @ConditionalOnMissingBean(DispatchService.class)
    public DispatchService defaultPre(){
        return new DispatchServiceImpl();
    }



}
