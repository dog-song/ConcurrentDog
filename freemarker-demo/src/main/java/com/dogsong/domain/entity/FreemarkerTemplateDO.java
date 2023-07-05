package com.dogsong.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * FreemarkerTemplateDO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/30
 */
@Data
public class FreemarkerTemplateDO implements Serializable {

    private Integer id;

    private String name;

    private String templateInfo;

}
