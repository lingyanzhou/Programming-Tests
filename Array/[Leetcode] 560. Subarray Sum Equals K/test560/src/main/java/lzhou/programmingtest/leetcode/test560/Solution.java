package lzhou.programmingtest.leetcode.test560;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        IntStream.range(0, nums.length).forEach(i-> sum[i+1]=sum[i]+nums[i]);
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        
        return IntStream.range(0, nums.length).map(i-> {
            Integer ret = map.getOrDefault(sum[i+1]-k,0);
            map.put(sum[i+1], map.getOrDefault(sum[i+1],0)+1);
            return ret;
        }).reduce((a,b)-> a+b).orElse(0);
    }
}
