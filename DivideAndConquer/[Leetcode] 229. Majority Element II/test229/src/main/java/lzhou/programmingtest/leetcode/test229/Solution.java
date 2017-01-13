package lzhou.programmingtest.leetcode.test229;

import java.util.*;

public class Solution {
    /**
     * @param nums: An array of integers
     * @return: The list of majority numbers that occurs more than 1/3
     */
    public List<Integer> majorityElement(int[] nums) {
        // write your code
        int n1 = 0;
        int n2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int n: nums) {
            if (n==n1) {
                c1+=1;
            } else if (n==n2) {
                c2+=1;
            } else if (c1==0) {
                n1=n;
                c1=1;
            } else if (c2==0) {
                n2=n;
                c2=1;
            } else {
                c1-=1;
                c2-=1;
            }
        }
        List<Integer> ret = new ArrayList<Integer>(2);
        if (c1!=0 && verifyMajority(nums, n1)) {
            ret.add(n1);
        }
        if (c2!=0 && verifyMajority(nums, n2)) {
            ret.add(n2);
        }
        return ret;
    }
    
    private boolean verifyMajority(int[] nums, int n) {
        int count = 0;
        for (int i: nums) {
            if (i==n) {
                count+=1;
            }
        }
        return count*3>nums.length;
    }
}

