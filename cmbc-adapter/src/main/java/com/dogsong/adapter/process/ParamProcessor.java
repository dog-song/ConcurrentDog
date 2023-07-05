package com.dogsong.adapter.process;

import com.dogsong.adapter.common.context.ParamContext;


/**
 * ParamProcessor
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/26
 */
public interface ParamProcessor {

    void invoke(ParamContext context);

}
