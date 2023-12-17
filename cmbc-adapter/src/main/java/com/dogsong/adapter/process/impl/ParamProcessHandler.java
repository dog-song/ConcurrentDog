package com.dogsong.adapter.process.impl;

import com.dogsong.adapter.common.context.ParamContext;
import com.dogsong.adapter.handler.BuildDataModel;
import com.dogsong.adapter.handler.ConversionParam;
import com.dogsong.adapter.handler.MappingParam;
import com.dogsong.adapter.handler.ValidateParam;
import com.dogsong.adapter.process.AbstractParamProcessor;
import com.dogsong.adapter.service.TestAdapterService;
import com.dogsong.adapter.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * ParamProcessHandler
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/30
 */
@Slf4j
@Component
public abstract class ParamProcessHandler extends AbstractParamProcessor {

    @Autowired
    private ConversionParam conversionParam;

    @Autowired
    private ValidateParam validateParam;

    @Autowired
    private BuildDataModel buildDataModel;

    @Autowired
    private MappingParam mappingParam;

    @Override
    public void invoke(ParamContext context) {
        // 交易码转换
        // conversionParam.transCodeConversion();

        // 元数据校验
        // validateParam.validatedOriginParam();

        // 封装数据模型
        // buildDataModel.buildDataModel();

        // 参数映射转换
        // mappingParam.doMapping();

        // 实际调用内部服务
        // SpringContextUtil.getBean("testAdapterService", TestAdapterService.class);

        if (Objects.nonNull(context)) {
            customExecute();
        } else {

            System.out.println(11111);
            log.info("1111111111");
        }

    }

    public abstract void customExecute();

}
