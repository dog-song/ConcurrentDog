package com.dogsong.domain.pojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * User
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/23
 */

@XmlRootElement(name = "user")
@Data
public class User {

    private String name;

    private String age;

}
