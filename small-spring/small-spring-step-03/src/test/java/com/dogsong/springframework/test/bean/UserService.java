package com.dogsong.springframework.test.bean;

/**
 * UserService
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/11
 */
public class UserService {

    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }

}
