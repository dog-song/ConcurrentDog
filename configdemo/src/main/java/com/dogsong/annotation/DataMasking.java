package com.dogsong.annotation;

import com.dogsong.datamasking.DataMaskingFunc;

import java.lang.annotation.*;

/**
 * 数据脱敏注解
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/18
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {

    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;

}
