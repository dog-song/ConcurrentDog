package com.dogsong.e.mapstruct;

import com.dogsong.e.mapstruct.entity.Role;
import com.dogsong.e.mapstruct.entity.User;
import com.dogsong.e.mapstruct.pojo.UserRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * {@link Mapper} 定义这是一个MapStruct对象属性转换接口，在这个类里面规定转换规则
 * 在项目构建时，会自动生成改接口的实现类，这个实现类将实现对象属性值复制
 *
 * <a href="https://mp.weixin.qq.com/s/2pNsET1HHE8UH5GO4Tyd2A">参考</a>
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/22
 */
@Mapper
public interface UserRoleMapper {

    // 接口中的属性都是 public static final 的
    // 方法都是public abstract的

    /** 获取该类自动生成的实现类的实例 */
    UserRoleMapper INSTANCES = Mappers.getMapper(UserRoleMapper.class);

    /**
     * 这个方法就是用于实现对象属性复制的方法
     *
     * @param user {@link User}
     */
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    UserRoleDto toUserRoleDto(User user);

    /**
     * 多个参数中的值绑定
     * @param user 源1
     * @param role 源2
     * @return 从源1、2中提取出的结果
     */
    @Mappings({
            @Mapping(source = "user.id", target = "userId"), // 把user中的id绑定到目标对象的userId属性中
            @Mapping(source = "user.username", target = "name"), // 把user中的username绑定到目标对象的name属性中
            @Mapping(source = "role.roleName", target = "roleName") // 把role对象的roleName属性值绑定到目标对象的roleName中
    })
    UserRoleDto toUserRoleDto(User user, Role role);

    /**
     * 直接使用参数作为值
     */
    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "user.username", target = "name"),
            @Mapping(source = "myRoleName", target = "roleName")
    })
    UserRoleDto useParameter(User user, String myRoleName);

    /**
     * 提供默认方法
     */
    default UserRoleDto defaultConvert() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(0L);
        userRoleDto.setName("dogsong");
        userRoleDto.setRoleName("admin");
        return userRoleDto;
    }

}
