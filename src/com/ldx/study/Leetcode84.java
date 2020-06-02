package com.ldx.study;

import java.util.Stack;

class Leetcode84 {
    public static int largestRectangleArea(int[] heights) {
        //
        if (heights == null || heights.length <= 0)
            return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? 0 : heights[i];
            //stack维护高度递增的矩形下标
            if (stack.isEmpty() || curHeight > heights[stack.peek()])
                stack.push(i);
            else {
                //如果出现了局部最高值
                while(!stack.isEmpty() && heights[stack.peek()] >= curHeight) {
                    int popIndex = stack.pop();
                    int startIndex = stack.isEmpty() ? -1 : stack.peek();
                    max = Math.max(max, (i - startIndex - 1) * heights[popIndex]);
                }
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }
}