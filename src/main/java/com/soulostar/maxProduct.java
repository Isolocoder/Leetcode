package com.soulostar;

public class maxProduct {

    public static void main(String[] args) {
        int []nums = new int[]{2,3,-2,4};
        System.out.println(new Solution().maxProduct(nums));
    }
    static class Solution {
        public int maxProduct(int[] nums) {
            int [][]dp = new int[nums.length][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];
            int max = dp[0][0];
            for (int i = 1; i < nums.length; i++) {
                dp[i][0] = Math.max(nums[i],Math.max(nums[i]*dp[i-1][0],nums[i]*dp[i-1][1]));
                dp[i][1] = Math.min(nums[i],Math.min(nums[i]*dp[i-1][0],nums[i]*dp[i-1][1]));
                max = Math.max(max,dp[i][0]);
            }
            return max;
        }
    }
}
