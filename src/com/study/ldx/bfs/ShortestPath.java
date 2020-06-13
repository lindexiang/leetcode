package com.study.ldx.bfs;

import jdk.nashorn.internal.ir.IfNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  网格中的从左上角走到右下角的最短路径
 *
 * @author guanye
 * @date 2020/6/9 下午9:27
 */
public class ShortestPath {

    static int[][] dirs = {{1,0}, {-1,0},{0,1}, {0,-1}};

    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length <= 0)
            return -1;

        int m = grid.length;
        int n = grid[0].length;

        //如果k大于m+n-2 直接返回最短路径
        if (k >= m+n-2) {
            return m+n-1;
        }

        Queue<int[]> queue = new LinkedList<>();
        //初始化
        queue.offer(new int[]{0,0,k});
        int step = 0;
        //用户的状态 (x,y,k) 到一个点都有状态的概念 k值不同
        // 因为每一层的步数都是相同的，所以走到当前点，只要K值相同，那么可以不用走下去 认为是已经走过的路

        boolean[][][] visited = new boolean[k+1][m][n];

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (int[] dir: dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (!(x >= 0 && x < m && y >= 0 && y < n))
                        continue;

                    int nextK = grid[x][y] == 1 ? cur[2] - 1 : cur[2];
                    if (nextK < 0)
                        continue;

                    if (!visited[nextK][x][y]) {
                        visited[nextK][x][y] = true;
                        queue.offer(new int[] {x, y, nextK});
                    }
                }
            }
            step++;
        }
        return -1;
    }



}


