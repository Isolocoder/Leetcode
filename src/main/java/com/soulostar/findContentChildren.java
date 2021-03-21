package com.soulostar;

import java.util.Arrays;
import java.util.Collections;

public class findContentChildren {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []g = new int[]{2,1};
        int []s = new int[]{1,1};
        System.out.println(solution.findContentChildren(g,s));
    }
}


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int gp = g.length-1,sp = s.length-1;
        while (gp>=0&&sp>=0){
            if (g[gp] <= s[sp]){
                gp--;
                sp--;
                cnt++;
            }else {
                gp--;
            }
        }
        return cnt;
    }
}