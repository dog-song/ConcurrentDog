package com.dogsong.service;

import com.dogsong.domain.entity.FreemarkerTemplateDO;

import java.util.List;

/**
 * FreemarkerTemplate
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/30
 */
public interface FreemarkerTemplateService {

    List<FreemarkerTemplateDO> getTemplateList();

}
