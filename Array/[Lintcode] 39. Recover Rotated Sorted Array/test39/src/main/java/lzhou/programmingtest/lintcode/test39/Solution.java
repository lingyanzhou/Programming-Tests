package lzhou.programmingtest.lintcode.test39;

import java.util.*;

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(int[] nums) {
        // write your code
        if (nums.length==0 || nums.length==1) {
            return;
        }
        int first = 1;
        while (first<nums.length && nums[first]>=nums[first-1]) {
            first+=1;
        }
        first = first%nums.length;
        if (first==0) {
            return;
        }
        
        int gcd = gcd(first, nums.length);
        
        for (int i=0; i<gcd; ++i) {
            int old = nums[(i+first)%nums.length];
            int j=i;
            do {
                int next = nums[j];
                nums[j] = old;
                old=next;
                j=(j-first+nums.length)%nums.length;
            } while (j!=i);
        }
    }
    
    private int gcd(int a, int b) {
        while (a!=0 && b!=0) {
            int aa = a;
            a = a%b;
            b = b%aa;
        }
        if (a==0) {
            return b;
        }
        return a;
    }
}
