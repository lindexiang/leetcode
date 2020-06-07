package com.study.ldx.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: NumIslands <br>
 * date: 2020/6/7 15:54 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class NumIslands {

    static int[][] dirs = {{1,0}, {-1,0},{0,1}, {0,-1}};

    static public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0)
            return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] dir: dirs) {
                            int xPos = cur[0] + dir[0];
                            int yPos = cur[1] + dir[1];
                            if (xPos >= 0 && xPos < grid.length &&
                            yPos >= 0 && yPos < grid[0].length &&
                            grid[xPos][yPos] == '1' && !visited[xPos][yPos]) {
                              visited[xPos][yPos] = true;
                              queue.add(new int[]{xPos, yPos});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }


}

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
