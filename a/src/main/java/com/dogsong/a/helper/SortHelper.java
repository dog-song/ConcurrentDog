package com.dogsong.a.helper;

import java.util.Random;

/**
 * 数组测试 Helper
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/22
 */
public class SortHelper {

    /**
     * 生成随机数组
     *
     * @param size 大小
     * @return int[] 随机数组
     */
    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] ans = new int[size];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = random.nextInt(size);
        }
        return ans;
    }

    /**
     * 检查是否从小到大 排序
     *
     * @param array 需要检查的数组
     * @return boolean res
     */
    public static boolean validate(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

}
