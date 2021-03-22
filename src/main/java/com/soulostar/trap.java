package com.soulostar;

import javafx.util.Pair;

import java.util.Stack;

public class trap {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
    }

    static class Solution{
        public int trap(int[] height) {
            Stack<Pair<Integer,Integer>> stack = new Stack<>();
            int water = 0;
            for (int h : height) {
                if (stack.isEmpty() || h < stack.peek().getKey()) stack.push(new Pair<>(h, 1));
                else {
                    int lower = Math.min(stack.get(0).getKey(),h);
                    int width = 1;
                    while (!stack.isEmpty()&&h > stack.peek().getKey()){
                        Pair<Integer, Integer> block = stack.pop();
                        water += (lower-block.getKey())*block.getValue();
                        width+=block.getValue();
                    }
                    stack.push(new Pair<>(h,width));
                }
            }
            return water;
        }
    }
}
