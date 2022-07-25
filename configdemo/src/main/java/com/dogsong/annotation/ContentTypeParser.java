package com.dogsong.annotation;

import java.lang.annotation.*;

/**
 * 注解:
 * 同时兼容 POST json 和 form 表单，更骚的是连 form-data 也兼容
 *
 * <br/>
 * USE:
 * 只需将 @RequestParam 注解改为 @ContentTypeParser，接口即可同时兼容三种 content-type。
 * 其流程为，spring 启动的时候，ContentTypeConfiguration 调用 addArgumentResolvers 方法将 ContentTypeMethodProcessor 注入，
 * 接到请求时，supportsParameter 方法判断是否使用此 resolver，如果为 true，则进入 resolveArgument 方法执行。
 *
 * <br/>
 * 引用: https://mp.weixin.qq.com/s/WOxSY66WhgZSUEjSaQlF9A
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ContentTypeParser {



}
