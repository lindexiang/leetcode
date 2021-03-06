package com.study.ldx.dfs;

import java.util.*;

/**
 * description: EventualSafeNodes <br>
 * date: 2020/6/20 2:06 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class EventualSafeNodes {

    public static void main(String[] args) {
        int[][] graph = {{0},{2,3,4},{3,4},{0,4},{}};

        List<Integer> ret = eventualSafeNodes(graph);
        System.out.println(ret);
    }

    //查看图是不是有环
    //用多个状态位表示
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ret = new ArrayList<>();
        int[] type = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, type) == 2) ret.add(i);
        }
        return ret;
    }


    /**
     * 节点的状态 0 未访问 1 以访问 2安全 3 成环
     */
    private static int dfs(int[][] graph, int index, int[] type) {
        if (type[index] == 1) return 3;
        if (type[index] != 0) return type[index];

        //开始遍历当前节点
        type[index] = 1;
        for (int next: graph[index]) {
            if (dfs(graph, next, type) == 3) {
                return type[index] = 3;
            }
        }
        return type[index] = 2;
    }

}

/**
 802. 找到最终的安全状态
 在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。

 现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K,  无论选择从哪里开始行走, 我们走了不到 K 步后必能停止在一个终点。

 哪些节点最终是安全的？ 结果返回一个有序的数组。

 该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数.  图以以下的形式给出: graph[i] 是节点 j 的一个列表，满足 (i, j) 是图的一条有向边。

 示例：
 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 输出：[2,4,5,6]
 这里是上图的示意图。

 Illustration of graph

 提示：

 graph 节点数不超过 10000.
 图的边数不会超过 32000.
 每个 graph[i] 被排序为不同的整数列表， 在区间 [0, graph.length - 1] 中选取。
 通过次数3,823提交次数8,252
 */