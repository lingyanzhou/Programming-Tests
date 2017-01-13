package lzhou.programmingtest.lintcode.test138;

import java.util.*;

/*
 * Kadane's algorithm
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySum(int[] nums) {
        // write your code here
        int[] ret = new int[2];
        HashMap<Long,Integer> prevSums = new HashMap<Long,Integer>();
        long prevSum = 0;
        for (int i=0; i<=nums.length; ++i) {
            if (prevSums.containsKey(prevSum)) {
                ret[0] = prevSums.get(prevSum);
                ret[1] = i-1;
                return ret;
            } else {
                prevSums.put(prevSum, i);
            }
            if (i!=nums.length) {
                prevSum += nums[i];
            }
        }
        return ret;
    }
}
