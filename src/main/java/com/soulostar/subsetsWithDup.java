package com.soulostar;

import java.util.*;

public class subsetsWithDup {

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{0}));
    }

    static class Solution {

        public List<List<Integer>> res = new ArrayList<>();
        public List<Integer> tmp = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length==0){
                res.add(new ArrayList<>(tmp));
                return res;
            }
            Arrays.sort(nums);
            HashMap<Integer,Integer> map = new HashMap<>();
            int last = nums[0];
            map.put(last,1);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]==last){
                    map.computeIfPresent(last,(k,v)-> v + 1);
                }else {
                    last = nums[i];
                    map.put(last,1);
                }
            }
            int [][]mapper = new int[map.size()][2];
            int i = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                mapper[i][0] = entry.getKey();
                mapper[i++][1] = entry.getValue();
            }
            trace(mapper, 0);
            return res;
        }

        public void trace(int [][]mapper,int pos){
            if (pos == mapper.length){
                res.add(new ArrayList<>(tmp));
                return;
            }
            Integer key = mapper[pos][0];
            int count = mapper[pos][1];
            trace(mapper,pos+1);
            for (int i = 0; i < count; i++) {
                tmp.add(key);
                trace(mapper,pos+1);
            }
            for (int i = 0; i < count; i++) {
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
