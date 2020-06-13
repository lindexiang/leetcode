package com.study.ldx.array;

/**
 * <p>
 *
 * @author guanye
 * @date 2020/6/13 下午3:14
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0,1,3};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        return dfs(nums, 0, nums.length-1);
    }

    //[0] [0 1]  [1]

    public static int dfs(int[] nums, int left, int right) {
        if (left > right)
            return nums.length;
        else if (left == right && nums[left] != left)
            return left;

        int k = (left + right) / 2;
        if (nums[k] == k)
            return dfs(nums, k+1, right);
        else
            return dfs(nums, left, k);
    }

}
