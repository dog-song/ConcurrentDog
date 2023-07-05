package com.dogsong.utils;

import com.google.common.collect.Maps;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * FreemarkerUtil
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/23
 */
@Slf4j
@Component
public class FreemarkerUtil {

    @Autowired
    @Qualifier("getFreeMarkerConfiguration")
    private Configuration freemarkerConfigDB;

    private static final Configuration freemarkerConfig = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

    static {
        try {
            freemarkerConfig.setClassForTemplateLoading(FreemarkerUtil.class, "/templates");
            freemarkerConfig.setTemplateLoader(new ClassTemplateLoader(FreemarkerUtil.class, "/templates"));
            // freemarkerConfig.setDirectoryForTemplateLoading(new File(templatePath, "/templates"));
            freemarkerConfig.setNumberFormat("#");
            freemarkerConfig.setClassicCompatible(true);
            freemarkerConfig.setDefaultEncoding("UTF-8");
            freemarkerConfig.setLocale(Locale.CHINA);
            freemarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public String processStringDB(String templateName, Map<String, Object> params) {
        StringWriter result = new StringWriter();

        try {
            Template template = freemarkerConfigDB.getTemplate(templateName);
            // 模版转换
            template.process(params, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }


    /**
     * process Template Into String
     *
     * @param template 模版
     * @param model 参数
     */
    public static String processTemplateIntoString(Template template, Object model)
            throws IOException, TemplateException {

        StringWriter result = new StringWriter();
        // 模版转换
        template.process(model, result);
        return result.toString();
    }

    /**
     * process String
     *
     * @param templateName 模版
     * @param params 参数
     */
    public static String processString(String templateName, Map<String, Object> params)
            throws IOException, TemplateException {

        Template template = freemarkerConfig.getTemplate(templateName);

        return processTemplateIntoString(template, params);
    }

    /**
     * process String
     *
     * @param templateName 模版
     * @param paramsObject 参数
     */
    public static String processString(String templateName, Object paramsObject)
            throws IOException, TemplateException {

        Map<String, Object> params = null;
        try {
            params = MapUtil.getObjectToMap(paramsObject);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        return processString(templateName, params);
    }

}
