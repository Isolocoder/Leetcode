package com.soulostar;

public class hammingWeight {

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-8));
    }
    static public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            for (int i = 0; i < 32; i++) {
                cnt += n&1;
                n >>= 1;
            }
            return cnt;
        }
    }
}
