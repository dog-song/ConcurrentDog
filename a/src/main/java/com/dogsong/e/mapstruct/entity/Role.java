package com.dogsong.e.mapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Role
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/21
 */
@Data
@AllArgsConstructor
public class Role {

    private Long id;
    private String roleName;
    private String description;
}
