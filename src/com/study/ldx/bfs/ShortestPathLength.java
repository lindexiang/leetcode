package com.study.ldx.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: ShortestPathLength <br>
 * date: 2020/6/8 0:18 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class ShortestPathLength {
    /**
     * 思路 因为求最短路径 肯定是使用bfs做层搜索
     * 这里需要保存每个节点之前走过的路径 所以需要保存走过的节点 可以使用位存储
     同时为了保证提高效率，要防止走已经走过的路 所以需要使用visited来保存走过的路
     每走一步，visited都是不一样的，所以使用visited[N][1 << N]
     * @param graph
     * @return
     */
    public static int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length <= 0)
            return 0;

        int N = graph.length;
        boolean[][] visited = new boolean[N][1 << N];
        int end = (1 << N) - 1;

        Queue<int[]> queue = new LinkedList<>();

        //开始初始化
        for (int i = 0; i < N; i++) {
            visited[i][1 << i] = true;
            queue.add(new int[] {i, 1 << i});
        }

        //开始bfs
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[1] == end)
                    return step;
                for (int next: graph[cur[0]]) {
                    int nextStage = cur[1] | (1 << next);
                    if (!visited[next][nextStage]) {
                        visited[next][nextStage] = true;
                        queue.offer(new int[] {next, nextStage});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}

/**
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。 
 *
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 *  
 *
 * 示例 1：
 * 节点0可以到1，2，3 节点1到0 节点2 到节点0 节点3到节点0
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 示例 2：
 *
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 *  
 *
 * 提示：
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 * 通过次数2,031提交次数3,818
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
