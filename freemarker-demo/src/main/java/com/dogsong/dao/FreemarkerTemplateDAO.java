package com.dogsong.dao;

import com.dogsong.domain.entity.FreemarkerTemplateDO;
import com.dogsong.mapper.FreemarkerTemplateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FreemarkerTemplateDAO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/30
 */
@Slf4j
@Repository
public class FreemarkerTemplateDAO {

    @Autowired
    private FreemarkerTemplateMapper freemarkerTemplateMapper;


    public List<FreemarkerTemplateDO> getTemplateList() {
        return freemarkerTemplateMapper.list();
    }

}
