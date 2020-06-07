package com.ldx.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: NQueens <br>
 *     N皇后问题
 * date: 2020/6/4 0:40 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class NQueens {


    public static void main(String[] args) {
        List<List<String>> ret = solveNQueens(4);
        System.out.println(123);
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        dfs(new ArrayList<>(), n, new ArrayList<>(), ret);
        return ret;
    }

    public static void dfs(List<String> solution, int n, List<Integer> checkList, List<List<String>> ret) {
        if (solution.size() == n) {
            List<String> s1 = new ArrayList<>(solution);
            ret.add(s1);
            return;
        }

        for (int i = 0; i < n; i++) {
            checkList.add(i);
            //不符合要求
            if (!check(checkList)) {
                checkList.remove(checkList.size() - 1);
                continue;
            }
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i)
                    temp.append("Q");
                else
                    temp.append(".");
            }
            solution.add(temp.toString());
            dfs(solution, n, checkList, ret);
            //这个之后要移除
            //递归最重要的是在一次dfs结束后将栈信息还原到上一次的调用
            //这里是for循环，所以在每次的循环调用时栈的深度都是一样的，可以简单的理解为i = 0 和i = 1时solution的size是相同的，
            //在一次dfs调用后solution的size会+1，所以必须要使用remove
            solution.remove(solution.size() - 1);
            checkList.remove(checkList.size() - 1);
        }

    }

    /**
     * 检查是否正确 检查当前行和之前的所有行是否
     * @param checkList
     * @return
     */
    private static boolean check(List<Integer> checkList) {
        int curIndex = checkList.get(checkList.size() - 1);
        for (int i = 0; i < checkList.size() - 1; i++) {
            //横坐标%纵坐标==0
            if (Math.abs(curIndex - checkList.get(i)) == Math.abs(checkList.size() - 1 - i) || curIndex == checkList.get(i))
                return false;
        }
        return true;
    }

}
