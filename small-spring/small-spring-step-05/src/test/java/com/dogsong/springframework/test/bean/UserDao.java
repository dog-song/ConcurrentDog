package com.dogsong.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * UserDao
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/10
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "dogsong1");
        hashMap.put("10002", "dogsong2");
        hashMap.put("10003", "dogsong3");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
