package com.dogsong.util;

import com.dogsong.d.util.BeanConvertUtils;
import com.dogsong.e.mapstruct.entity.Role;
import com.dogsong.e.mapstruct.entity.User;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * {@link com.dogsong.d.util.BeanConvertUtils} 测试
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/22
 */
@Slf4j
public class BeanConvertUtilsTest {

    User user = null;

    List<User> userList = Lists.newArrayList();

    /**
     * 模拟从数据库中查出user对象
     */
    @Before
    public void before() {
        Role role  = new Role(2L, "administrator", "超级管理员");
        user  = new User(1L, "zhangsan", "12345", "17677778888", "123@qq.com", role);

        userList.add(user);
    }

    /**
     * 用前
     */
    @Test
    public void test1() {
        User target = new User();
        BeanUtils.copyProperties(user, target);

        System.out.println(target);
    }

    /**
     * 用后
     */
    @Test
    public void test2() {
        User target = BeanConvertUtils.convertTo(user, User::new);
        System.out.println(target);
    }

    /**
     * 用后-通过lambda表达式特殊处理个别字段
     */
    @Test
    public void test3() {
        User target = BeanConvertUtils.convertTo(user, User::new,
                (s, t) -> {
                    if (StringUtils.equals("zhangsan", s.getUsername())) {
                        t.setUsername("dogsong");
                    }
                }
        );
        System.out.println(target);
    }

    /**
     * 用前
     */
    @Test
    public void testList1() {
        List<User> list = Lists.newArrayListWithCapacity(userList.size());

        for (User user1 : userList) {
            User target = new User();
            BeanUtils.copyProperties(user1, target);
            list.add(target);
        }

        System.out.println(list);
    }

    /**
     * 用后
     */
    @Test
    public void testList2() {
        List<User> list = BeanConvertUtils.convertListTo(userList, User::new);

        System.out.println(list);
    }

    /**
     * 用后-通过lambda表达式特殊处理个别字段
     */
    @Test
    public void testList3() {
        List<User> list = BeanConvertUtils.convertListTo(userList, User::new,
                (s, t) -> {
                    if (StringUtils.equals("zhangsan1", s.getUsername())) {
                        t.setUsername("dogsong");
                    }
                }
        );

        System.out.println(list);
    }

}
