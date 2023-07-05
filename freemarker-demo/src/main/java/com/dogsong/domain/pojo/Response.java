package com.dogsong.domain.pojo;

import lombok.Data;

/**
 * Response
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/24
 */
@Data
public class Response {

    private String code;

    private String message;

    private int num;

}
