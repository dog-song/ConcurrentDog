package com.dogsong.datamasking;


import org.springframework.util.StringUtils;

/**
 * 数据脱敏枚举
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/18
 */
public enum DataMaskingFunc {

    /** 脱敏转换器 */
    NO_MASK((String content, String maskChar) -> {
        return content;
    }),

    ALL_MASK((content, maskChar) -> {
        if (StringUtils.hasLength(content)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < content.length(); i++) {
                sb.append(StringUtils.hasLength(maskChar) ? maskChar : DataMaskingOperation.MASK_CHAR);
            }
            return sb.toString();
        } else {
            return content;
        }
    }),;

    private final DataMaskingOperation operation;

    private DataMaskingFunc(DataMaskingOperation operation) {
        this.operation = operation;
    }

    public DataMaskingOperation operation() {
        return this.operation;
    }


}
