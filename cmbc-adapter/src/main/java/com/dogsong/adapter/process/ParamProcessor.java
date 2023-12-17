package com.dogsong.adapter.process;

import com.dogsong.adapter.common.context.ParamContext;
import com.dogsong.adapter.service.TestAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


/**
 * ParamProcessor
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/26
 */
public interface ParamProcessor {

    void invoke(ParamContext context);

    default void invoke2(ParamContext context) {

    }

}
