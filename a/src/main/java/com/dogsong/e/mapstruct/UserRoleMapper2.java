package com.dogsong.e.mapstruct;

import com.dogsong.e.mapstruct.entity.User;
import com.dogsong.e.mapstruct.pojo.UserRoleDto;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * UserRoleMapper2
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/6/22
 */
public abstract class UserRoleMapper2 {

    public final static UserRoleMapper2 INSTANCE = Mappers.getMapper(UserRoleMapper2.class);

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    public abstract UserRoleDto toUserRoleDto(User user);

    UserRoleDto defaultConvert() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(0L);
        userRoleDto.setName("dogsong");
        userRoleDto.setRoleName("admin");
        return userRoleDto;
    }
}
