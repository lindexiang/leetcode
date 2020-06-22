package com.study.ldx.dfs_dp;

import java.util.Arrays;

/**
 * <p> 猫捉老鼠的故事
 *
 * @author guanye
 * @date 2020/6/19 下午10:45
 */
public class CatMouseGame {

    public static int catMouseGame(int[][] graph) {
        int[][][] dp = new int[400][200][200];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++)
                Arrays.fill(dp[i][j], -1);
        }
        return dfs(graph, 0, 1, 2, dp);
    }

    public static void main(String[] args) {
        int[][] graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
        System.out.println(catMouseGame(graph));
    }

    //计算猫的位置和老鼠的位置返回的是谁赢
    /**
     * 如果是走了2n步 都没有分出胜负 就是平局
     * */
    private static int dfs(int[][] graph, int step, int mouPos, int catPos, int[][][] dp) {
        //如果走了2n步 没有分出胜负 就是平局
        if (step == graph.length * 2) return 0;

        //猫赢
        if (mouPos == catPos) {
            dp[step][mouPos][catPos] = 2;
            return 2;
        }

        //老鼠赢
        if (mouPos == 0) {
            dp[step][mouPos][catPos] = 1;
            return 1;
        }

        //还没遍历过
        if (dp[step][mouPos][catPos] != -1) return dp[step][mouPos][catPos];

        //老鼠先走
        if (step % 2 == 0) {
            //老鼠接下来会走的所有的位置
            //如果老鼠无论走哪一步 都会死 那么就是猫赢 如果有一步进洞 那就是老鼠赢 否则平局
            boolean catWin = true;
            for (int next: graph[mouPos]) {
                int nextWin = dfs(graph, step + 1, next, catPos, dp);
                if (nextWin == 1) {
                    dp[step][mouPos][catPos] = 1;
                    return 1;
                } else if (nextWin != 2) {
                    catWin = false;
                }
            }
            //猫必赢的情况
            if (catWin) {
                dp[step][mouPos][catPos] = 2;
                return 2;
            } else {
                dp[step][mouPos][catPos] = 0;
                return 0;
            }
        } else {
            //猫接下来会走的地方
            //只有猫有一步能赢 那就是猫赢 如果猫无论走哪一步  老鼠都赢 那么就是老鼠赢 否则平局
            boolean mouWin = true;
            for (int next: graph[catPos]) {
                if (next == 0) continue;
                    int nextWin = dfs(graph, step + 1, mouPos, next, dp);
                    if (nextWin == 2) {
                        dp[step][mouPos][catPos] = 2;
                        return 2;
                    } else if (nextWin != 1) {
                        //猫不能让老鼠赢 要争取平局
                        mouWin = false;
                }
            }
            //老鼠必赢的情况
            if (mouWin) {
                dp[step][mouPos][catPos] = 1;
                return 1;
            } else {
                dp[step][mouPos][catPos] = 0;
                return 0;
            }
        }
    }
}
