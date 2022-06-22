package com.dogsong.e.mapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;
    private String phoneNum;
    private String email;
    private Role role;

}
