package lzhou.programmingtest.leetcode.test410;

import java.util.*;

public class Solution2 {
    //https://discuss.leetcode.com/topic/61324/clear-explanation-8ms-binary-search-java
    public int splitArray(int[] nums, int m) {
        long maxElement = 0;
        long sum = 0;
        for (int i:nums) {
            maxElement = Math.max(maxElement, i);
            sum+=i;
        }
        
        long l=maxElement;
        long r = sum;
        while (l<=r) {
            long mid = ((long)l+r)/2;
            
            if (hasMoreSegment(nums, mid, m)) {
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return (int)l;
    }
    
    boolean hasMoreSegment(int[] nums, long maxSum, int m) {
        int ret = 1;
        long curSum = 0;
        for (int i:nums) {
            if (curSum+i<=maxSum) {
                curSum+=i;
            } else {
                curSum = i;
                ret+=1;
                if (ret>m) {
                    return true;
                }
            }
        }
        return false;
    }
}
