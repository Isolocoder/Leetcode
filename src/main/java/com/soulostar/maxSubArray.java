package com.soulostar;

public class maxSubArray {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-1,1,-3,4,-1,2,1,-5,4}));
    }

    static class Solution{
        public int maxSubArray(int[] nums) {
            int num = nums[0],max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                num = Math.max(num+nums[i],nums[i]);
                max = Math.max(max,num);
            }
            return max;
        }
    }
}
