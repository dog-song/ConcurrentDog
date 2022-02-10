package com.dogsong.a.sort;

import java.util.Arrays;

/**
 * 快排
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/2/10
 */
public class QuicklySort {

    // 交换数组中两个元素的值
    private static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    // 将数组[b, e)范围的元素进行排序
    private static void qsort(int[] A, int b, int e) {
        // 像二叉树一样，如果空树/只有一个结点，那么不需要再递归了
        // 如果给定的区间段为空，或者只有一个结点。
        if (b >= e || b + 1 >= e) {
            return;
        }

        // 取数组中间的元素作为x
        final int m = b + ((e - b) >> 1);
        final int x = A[m];

        // 三路切分,这部分代码在例 3详细介绍!
        int l = b, i = b, r = e - 1;
        while (i <= r) {
            if (A[i] < x) {
                swap(A, l++, i++);
            } else if (A[i] == x) {
                i++;
            } else {
                swap(A, r--, i);
            }
        }
        // 像二叉树的前序遍历一样，分别遍历左子树与右子树。
        qsort(A, b, l);

        qsort(A, i, e);
    }

    // 主函数，将数组nums排序
    private static void quickSort(int[] nums) {
        if (nums == null) {
            return;
        }
        qsort(nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};

        quickSort(nums);

        Arrays.stream(nums).forEach(System.out::println);

    }



}
