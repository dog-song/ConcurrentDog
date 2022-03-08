package com.dogsong.c;

import org.springframework.beans.BeanUtils;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/8
 */
public class BeanTest {

    public static void main(String[] args) {
        Bean1 bean1 = new Bean1(18, "dogsong");
        Bean2 bean2 = new Bean2();
        BeanUtils.copyProperties(bean1, bean2);
        System.out.println(bean2);
    }

}
