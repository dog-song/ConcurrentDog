package com.dogsong.service.impl;

import com.dogsong.dao.FreemarkerTemplateDAO;
import com.dogsong.domain.entity.FreemarkerTemplateDO;
import com.dogsong.service.FreemarkerTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FreemarkerTemplateServiceImpl
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/30
 */
@Slf4j
@Service
public class FreemarkerTemplateServiceImpl implements FreemarkerTemplateService {

    @Autowired
    private FreemarkerTemplateDAO freemarkerTemplateDAO;


    @Override
    public List<FreemarkerTemplateDO> getTemplateList() {

        return freemarkerTemplateDAO.getTemplateList();
    }
}
