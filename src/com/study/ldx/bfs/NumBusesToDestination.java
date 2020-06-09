package com.study.ldx.bfs;

import java.util.*;

/**
 *
 * 815. 公交路线
 * description: NumBusesToDestination <br>
 * date: 2020/6/10 1:10 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class NumBusesToDestination {

    public static void main(String[] args) {
        int[][] routes = {{7,12},{4,5,15},{6},{15,19},{9,12,13}};
        int ret = numBusesToDestination(routes, 15, 12);
        System.out.println(ret);
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        //转化成Set
        if (routes == null || routes.length <= 0)
            return -1;
        String initVisited = "";
        for (int i = 0; i < routes.length; i++) {
            initVisited += "0";
        }
        //按照车的维度
        List<Set<Integer>> routeList = new ArrayList<>(routes.length);
        //按照车站的维度
        Map<Integer, List<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> curRoute = new HashSet<>();
            for (int j = 0; j < routes[i].length; j++) {
                curRoute.add(routes[i][j]);
                routeMap.putIfAbsent(routes[i][j], new ArrayList<>());
                routeMap.get(routes[i][j]).add(i);
            }
            routeList.add(curRoute);
        }

        //思路是把有这个车的所有站点都加到队列里面 然后这辆车就不再做了
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[routes.length];
        //
        if (!routeMap.containsKey(S) || !routeMap.containsKey(T))
            return -1;

        if (S == T)
            return 0;

        //初始化 把起始站点的车站都加到队列里
        for (Integer carNumber: routeMap.get(S)) {
            visited[carNumber] = true;
            for (Integer busStage: routeList.get(carNumber)) {
                queue.offer(new int[] {carNumber, busStage});
            }

        }

        int step = 1;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curPoint = queue.poll();
                if (routeList.get(curPoint[0]).contains(T)) {
                    return step;
                }

                //遍历其他有这个站点的车
                for (Integer nextCarNumber: routeMap.get(curPoint[1])) {
                    //如果这个车已经做过 就不在做了
                    if (visited[nextCarNumber])
                        continue;

                    visited[nextCarNumber] = true;
                    //把这个车得站点都加到队列里
                    for (Integer nextCarStage: routeList.get(nextCarNumber)) {
                        queue.offer(new int[] {nextCarNumber, nextCarStage});
                    }
                }
            }
            step++;
        }
        return -1;
    }


}


/**
 * 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。
 *
 * 假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
 *
 * 示例:
 * 输入:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * 输出: 2
 * 解释:
 * 最优策略是先乘坐第一辆公交车到达车站 7, 然后换乘第二辆公交车到车站 6。
 * 说明:
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
