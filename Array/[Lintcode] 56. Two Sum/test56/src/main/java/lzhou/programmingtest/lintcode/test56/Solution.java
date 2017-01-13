package lzhou.programmingtest.lintcode.test56;

import java.util.*;

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; ++i) {
            map.put(numbers[i], i);
        }
        
        for (int i=0; i<numbers.length; ++i) {
            if (map.containsKey(target-numbers[i])) {
                int [] ret = new int[2];
                int j= map.get(target-numbers[i]);
                if (i==j) continue;
                ret[0] = 1+Math.min(i,j);
                ret[1] = 1+Math.max(i, j);
                return ret;
            }
        }
        return null;
    }
}
