package lzhou.programmingtest.lintcode.test48;

import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(int[] nums, int k) {
        // write your code
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        for (int i: nums) {
            if (counts.containsKey(i)) {
                counts.put(i, 1+counts.get(i));
            } else {
                if (counts.size()==k) {
                    Iterator<Map.Entry<Integer,Integer>> iter = counts.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry<Integer,Integer> entry = iter.next();
                        if (entry.getValue()==1) {
                            iter.remove();
                        } else {
                            entry.setValue(entry.getValue()-1);
                        }
                    }
                } else {
                    counts.put(i, 1);
                }
            }
        }
        int ret = 0;
        for (int i: counts.keySet()) {
            int c =0;
            for (int j:nums) {
                if (i==j) {
                    c+=1;
                }
            }
            if (c>nums.length/k) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}
