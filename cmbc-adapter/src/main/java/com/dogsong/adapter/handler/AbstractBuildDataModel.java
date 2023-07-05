package com.dogsong.adapter.handler;

import com.dogsong.adapter.handler.extend.ExtendAdapterDataModelRegistry;
import com.dogsong.adapter.handler.extend.ExtendAdapterService;

/**
 * 构造数据模型-抽象类
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/29
 */
public abstract class AbstractBuildDataModel implements BuildDataModel {

    @Override
    public void buildDataModel() {
        ExtendAdapterService extendService = ExtendAdapterDataModelRegistry.getExtendService("503108");

        extendService.beforeSend();
        this.beforeSend();

        extendService.afterSend();
        this.afterSend();
    }

    protected abstract void beforeSend();

    protected abstract void afterSend();
}
