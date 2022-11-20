package com.dogsong.springframework.test.bean;

/**
 * UserService
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/20
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo() { System.out.println("查询用户信息：" + userDao.queryUserName(uId)); }


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
