package com.dogsong;

import com.dogsong.e.mapstruct.UserRoleMapper;
import com.dogsong.e.mapstruct.entity.Role;
import com.dogsong.e.mapstruct.entity.User;
import com.dogsong.e.mapstruct.pojo.UserRoleDto;
import org.junit.Before;
import org.junit.Test;

/**
 * MainTest
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/21
 */
public class MainTest {

    User user = null;

    /**
     * 模拟从数据库中查出user对象
     */
    @Before
    public void before() {
        Role role  = new Role(2L, "administrator", "超级管理员");
        user  = new User(1L, "zhangsan", "12345", "17677778888", "123@qq.com", role);
    }

    /**
     * 模拟把user对象转换成UserRoleDto对象
     */
    @Test
    public void test1() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(user.getId());
        userRoleDto.setName(user.getUsername());
        userRoleDto.setRoleName(user.getRole().getRoleName());
        System.out.println(userRoleDto);
    }

    @Test
    public void test2() {
        UserRoleDto userRoleDto = UserRoleMapper.INSTANCES.toUserRoleDto(user);
        System.out.println(userRoleDto);
    }

    @Test
    public void test3() {
        UserRoleDto userRoleDto = UserRoleMapper.INSTANCES.defaultConvert();
        System.out.println(userRoleDto);
    }


}
