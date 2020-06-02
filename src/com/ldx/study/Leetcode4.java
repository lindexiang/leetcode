package com.ldx.study;

class Leetcode4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //如果长度是偶数
        int k = (nums1.length + nums2.length) / 2;
        if ((nums1.length + nums2.length) % 2 == 1) {
            return dfs(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k+1);
        } else {
            return (dfs(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k) + dfs(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k+1)) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    /**
     * 2个正序数组取第k大的数，时间复杂度O(log(m+n))
     */
    public static double dfs(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        
        //先取2个数组的长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        
        //退出条件
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        } else if (len1 > len2) {
            return dfs(nums2, start2, end2, nums1, start1, end1, k);
        } else if(k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //对k进行二分查找
        int p = Math.min(k/2, len1);
        int q = k - p;

        //如果p和q的值相同 那么任意返回即可
        if (nums1[start1 + p - 1] == nums2[start2 + q - 1]) {
            return nums1[start1 + p - 1];
        } else if(nums1[start1 + p - 1] > nums2[start2 + q - 1]) {
            //舍弃nums2左边的数组
            return dfs(nums1, start1, end1, nums2, start2 + q, end2, k - q);
        } else {
            //舍弃num1左边的数组
            return dfs(nums1, start1 + p, end1, nums2, start2, end2, k - p);
        }
    }
}