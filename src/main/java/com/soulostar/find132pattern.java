package com.soulostar;

import java.util.Stack;

public class find132pattern {

    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{3,1,4,2}));
    }

    static class Solution {
        public boolean find132pattern(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            stack.push(nums[nums.length-1]);
            int max = Integer.MIN_VALUE;
            for (int i = nums.length - 2; i >= 0 ; i--) {
                if (max > nums[i])return true;
                while (!stack.isEmpty()&&nums[i]>stack.peek()){
                    max = Math.max(max,stack.pop());
                }
                if (stack.isEmpty()||nums[i]<stack.peek())stack.push(nums[i]);
            }
            return false;
        }
    }
}
