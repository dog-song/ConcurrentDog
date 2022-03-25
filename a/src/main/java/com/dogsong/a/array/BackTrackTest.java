package com.dogsong.a.array;

import com.dogsong.a.helper.SortHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * BackTrackTest
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/24
 */
public class BackTrackTest {

    public static void main(String[] args) {
        int[] nums = SortHelper.randomArray(3);

        // solve(nums);

        solve2(nums, 0);

        // solve4(nums, 0, new Box());
    }


    public static void solve(int[] A) {
        final int N = A == null ? 0 : A.length;
        for (int i = 0; i <= N; i++) {
            // 打印[0, ..., i)
            print(A, i);
        }
    }

    public static void solve2(int[] A, int i) {
        final int N = A == null ? 0 : A.length;
        if (i > N) {
            return;
        }
        print(A, i);
        solve2(A, i + 1);
    }

    public static void solve3(int[] A, int i, Box s) {
        final int N = A == null ? 0 : A.length;
        s.print();
        if (i >= N) {
            return;
        }
        s.push(A[i]);
        solve3(A, i+1, s);
    }

    public static void solve4(int[] A, int i, Box s) {
        final int N = A == null ? 0 : A.length;
        s.print();
        if (i >= N) {
            return;
        }
        s.push(A[i]);
        solve4(A, i+1, s);
        s.pop();
    }

    // 打印数组的[0, i)范围里面的数
    public static void print(int[] A, int i) {
        // 这里给定的A数组必然是有效的
        System.out.print("{");
        for (int j = 0; j < i; j++) {
            System.out.print(A[j] + ", ");
        }
        System.out.println("}");
    }

}

class Box {
    private List<Integer> l = new ArrayList<>();
    public void push(int x) { l.add(x); }
    public void pop() { l.remove(l.size() - 1); }
    public void print() {
        System.out.print("{");
        for (Integer x : l) {
            System.out.print(x + ", ");
        }
        System.out.println("}");
    }
}
