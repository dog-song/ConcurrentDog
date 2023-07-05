package com.dogsong.mapper;

import com.dogsong.domain.entity.FreemarkerTemplateDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * FreemarkerTemplateMapper
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/30
 */
@Mapper
public interface FreemarkerTemplateMapper {

    List<FreemarkerTemplateDO> list();

}
