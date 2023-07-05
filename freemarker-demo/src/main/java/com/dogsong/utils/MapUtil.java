package com.dogsong.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * MapUtil
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/24
 */
public class MapUtil {

    /**
     * Object转Map
     *
     * @param obj obj
     */
    public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> cla = obj.getClass();
        Field[] fields = cla.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String keyName = field.getName();
            Object value = field.get(obj);
            if (value == null)
                value = "";
            map.put(keyName, value);
        }
        return map;
    }

    public static String getString(Map map,String key){
        if(map!=null && map.containsKey(key)){
            try{
                return map.get(key).toString();
            }catch (Exception e){
                e.printStackTrace();
                return "";
            }
        }else{
            return "";
        }
    }


    public static Integer getInteger(Map map,String key){
        if(map!=null && map.containsKey(key)){
            try{
                return (Integer) map.get(key);
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }else{
            return 0;
        }
    }


    public static Boolean getBoolean(Map map,String key){
        if(map!=null && map.containsKey(key)){
            try{
                return (Boolean) map.get(key);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }


}
