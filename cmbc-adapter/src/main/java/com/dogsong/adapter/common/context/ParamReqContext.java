package com.dogsong.adapter.common.context;

import lombok.Data;

import java.util.Map;

/**
 * 适配器-请求参数上下文
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/29
 */
@Data
public class ParamReqContext {

    /** 原始请求参数 */
    private Map<String, Object> originMap;

    /** 个性化请求参数 */
    private Map<String, Object> extendMap;

    /** 完整请求参数 */
    private Map<String, Object> reqMap;

}
