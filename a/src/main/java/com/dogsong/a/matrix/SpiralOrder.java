package com.dogsong.a.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * [54] https://leetcode-cn.com/problems/spiral-matrix/
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/4/10
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] visited = new boolean[rows][columns];

        int total = rows * columns;
        int row = 0;
        int column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int directionIndex = 0;

        for (int i = 0; i < total; i ++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows ||
                    nextColumn < 0 || nextColumn >= columns ||
                    visited[nextRow][nextColumn])
            {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return order;
    }

}
