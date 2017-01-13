package lzhou.programmingtest.lintcode.test139;

import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        SumAndIndex[] prevSums = new SumAndIndex[nums.length+1];
        SumAndIndex prevSum = new SumAndIndex(0, 0);
        prevSums[0] = (prevSum.clone());
        for (int i=0; i<nums.length; ++i) {
            prevSum.sum += nums[i];
            prevSum.index = i+1;
            prevSums[i+1] = prevSum.clone();
        }
        
        Arrays.sort(prevSums);
        
        long minDiff = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i=1; i<=nums.length; ++i) {
            long diff = prevSums[i].sum-prevSums[i-1].sum;
            if (diff<minDiff) {
                minDiff=diff;
                start = Math.min(prevSums[i].index,prevSums[i-1].index);
                end = Math.max(prevSums[i].index,prevSums[i-1].index)-1;
            }
        }
        
        return new int[]{start, end};
    }
}

class SumAndIndex implements Comparable<SumAndIndex> {
    long sum;
    int index;
    
    public SumAndIndex(long _sum, int _index) {
        sum = _sum;
        index = _index;
    }
    
    public SumAndIndex clone() {
        return new SumAndIndex(sum, index);
    }
    
    public int compareTo(SumAndIndex o) {
        return Long.compare(sum, o.sum);
    }
}
