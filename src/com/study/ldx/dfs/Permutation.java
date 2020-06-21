package com.study.ldx.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 数组的全排列
 * 将每一个数都与其后的数交换即可
 * 如果存在重复的数
 * 那么在交换时要考虑他之前的数组的数是否已经被交换过
 * description: Permutation <br>
 * date: 2020/6/20 19:41 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class Permutation {

    public static List<List<Integer>> permutation(List<Integer> nums) {
        List<List<Integer>> ret = new ArrayList<>();
        permutationWithRepeat( nums, 0, ret);
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,2));
        System.out.println(Arrays.asList(permutation(nums)));
    }

    public static void permutationWithRepeat(List<Integer> nums, int offset, List<List<Integer>> result) {
        if (offset == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = offset; i < nums.size(); i++) {
            //判断当前的元素是否已经被交换到开头的位置过 如果已经交换过 这次就不再交换
            if (hasAppear(nums, offset, i))
                continue;
            swap(nums, offset, i);
            permutationWithRepeat(nums, offset+1, result);
            swap(nums, offset, i);
        }
    }

    public static boolean hasAppear(List<Integer> nums, int from, int to) {
        if (from == to)
            return false;
        for (int i = from; i < to; i++) {
            if (nums.get(i).equals(nums.get(to)))
                return true;
        }
        return false;
    }


    public static void permutation(List<Integer> nums, int offset, List<List<Integer>> result) {

        int len = nums.size();
        if (offset == len) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = offset; i < len; i++) {
            swap(nums, i, offset);
            permutation(nums, offset+1, result);
            swap(nums, i, offset);
        }
    }

    public static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
