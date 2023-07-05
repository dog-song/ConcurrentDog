package com.dogsong.config;


import com.dogsong.domain.entity.FreemarkerTemplateDO;
import com.dogsong.service.FreemarkerTemplateService;
import freemarker.cache.StringTemplateLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.List;


/**
 * FreemarkerConfiguration
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/24
 */
@Configuration
public class FreemarkerConfig {

    @Autowired
    private FreemarkerTemplateService freemarkerTemplateService;

    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
        // Create new configuration bean
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        // Create template loader
        StringTemplateLoader sTempLoader = new StringTemplateLoader();
        // Find all templates
        List<FreemarkerTemplateDO> templateList = freemarkerTemplateService.getTemplateList();

        templateList.forEach(template -> {
            // Put them in loader
            sTempLoader.putTemplate(template.getName(), template.getTemplateInfo());
        });

        // Set loader
        bean.setPreTemplateLoaders(sTempLoader);


        return bean;
    }


}
