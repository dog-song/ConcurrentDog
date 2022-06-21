package com.dogsong.convert;

import com.dogsong.entity.Customer;
import com.dogsong.entity.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * CustomerMapper
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/22
 */
@Mapper(componentModel = "spring") // 这里主要是这个componentModel 属性，它的值就是当前要使用的依赖注入的环境
public interface CustomerMapper {

    @Mapping(source = "name", target = "customerName")
    CustomerDto toCustomerDto(Customer customer);

}
