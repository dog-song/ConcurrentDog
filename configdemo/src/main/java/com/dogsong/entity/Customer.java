package com.dogsong.entity;

import com.dogsong.annotation.DataMasking;
import com.dogsong.datamasking.DataMaskingFunc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Customer
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    private String address;


}
