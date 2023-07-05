package com.dogsong.domain.pojo;

import lombok.Data;

import java.util.List;

/**
 * ClassInfo
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/24
 */
@Data
public class ClassInfo {

    private String className;

    private List<FieldInfo> fieldList;

}
