package com.dogsong.datamasking;

/**
 * 数据脱敏操作接口
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/18
 */
public interface DataMaskingOperation {

    String MASK_CHAR = "*";

    String mask(String content, String maskChar);

}
