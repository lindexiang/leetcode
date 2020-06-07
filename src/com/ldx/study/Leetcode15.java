package com.ldx.study;

import java.util.*;

/**
 * description: Leetcode15 <br>
 *     给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。

 * date: 2020/6/4 0:16 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class Leetcode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return ret;
        }
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int p1 = 0, p2 = nums.length - 1;
            int sum = -nums[i];
            while (p1 < i && p2 > i) {
                if (nums[p1] + nums[p2] == sum) {
                    List<Integer> solution = Arrays.asList(nums[p1], nums[i], nums[p2]);
                    set.add(solution);
                    p1++;
                } else if (nums[p1] + nums[p2] > sum) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        ret.addAll(set);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = threeSum(nums);
        System.out.println(123);
    }
}
