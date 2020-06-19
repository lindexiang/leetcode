package com.study.ldx.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: HasValidPath <br>
 * date: 2020/6/19 23:55 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class HasValidPath {

    private static int[][][] dirs = {{{0}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {0 , 1}},
            {{-1, 0}, {0, 1}},
            {{1, 0}, {0, 1}},
            {{-1, 0}, {0, -1}},
            {{1, 0}, {0, -1}}};

    public static void main(String[] args) {

    }

    public static boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        dp[m - 1][n - 1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{m - 1, n - 1});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == 0 && cur[1] == 0)
                return true;
            for(int[] neighbor: dirs[grid[cur[0]][cur[1]]]) { //遍历连接的两个邻居
                int x = cur[0] + neighbor[0];
                int y = cur[1] + neighbor[1];
                if(x >= 0 && x < m && y >= 0 && y < n && !dp[x][y]) {
                    dp[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }



}
