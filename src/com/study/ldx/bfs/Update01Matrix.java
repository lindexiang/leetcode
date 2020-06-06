package com.study.ldx.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *
 * @author guanye
 * @date 2020/6/6 下午2:48
 */
public class Update01Matrix {

    private static final int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static int[][] updateMatrix(int[][] matrix) {

        Queue<Integer[]> queue = new LinkedList<>();

        //使用bfs搜索，FIFO队列
        //初始化
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    queue.offer(new Integer[]{i, j});
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] curPos = queue.poll();
            for (int[] dir: dirs) {
                int i = curPos[0] + dir[0];
                int j = curPos[1] + dir[1];
                if (i >= 0 & i < matrix.length && j >= 0 && j < matrix[0].length
                        && (matrix[curPos[0]][curPos[1]] + 1 < matrix[i][j])) {
                    matrix[i][j] = matrix[curPos[0]][curPos[1]] + 1;
                    queue.offer(new Integer[] {i, j});
                }
            }
        }
        return matrix;
    }
}
