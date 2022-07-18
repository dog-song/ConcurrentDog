package com.dogsong.entity;

import com.dogsong.annotation.DataMasking;
import com.dogsong.datamasking.DataMaskingFunc;
import lombok.Data;

/**
 * CustomerDto
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/22
 */
@Data
public class CustomerDto {

    private Long id;

    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String customerName;

    private Integer age;

    private String address;

    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String email;
}
