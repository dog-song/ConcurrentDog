package com.dogsong.domain.pojo;

import lombok.Data;

import java.util.List;

/**
 * Request
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/24
 */
@Data
public class Request {

    private String version;

    private String msg;

    private int id;

    private List<User> userList;

}
