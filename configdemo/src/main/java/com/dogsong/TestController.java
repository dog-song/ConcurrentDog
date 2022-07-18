package com.dogsong;

import com.dogsong.convert.CustomerMapper;
import com.dogsong.entity.Customer;
import com.dogsong.entity.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/19
 */
@RestController
// @RefreshScope
public class TestController {

    @Value("${testStr:dogsong}")
    private String testStr;

    @Autowired
    private CustomerMapper mapper;

    @GetMapping("/test")
    public String test() {
        return testStr;
    }

    @GetMapping("/getName")
    public String test2() {
        Customer customer = new Customer(1L, "dogsong", 18, "dogsong99@gmail.com", "zz");
        CustomerDto customerDto = mapper.toCustomerDto(customer);
        return customerDto.toString();
    }

    @GetMapping("/getMaskName")
    public CustomerDto test3() {
        Customer customer = new Customer(1L, "dogsong", 18, "dogsong99@gmail.com", "zhengzhou");

        return mapper.toCustomerDto(customer);
    }
}

