package lzhou.programmingtest.leetcode.test442;

import java.util.*;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        //Reorder the array. 0 means no element, positive means one element, negative means duplicated
        for (int i=0; i<nums.length; ) {
            if (i+1==nums[i]) {
                i+=1;
            } else if (nums[i]<=0) {
                i+=1;
            } else if (nums[nums[i]-1]==nums[i]) {
                nums[nums[i]-1]=-nums[nums[i]-1];
                nums[i] = 0;
                i+=1;
            } else {
                swap(nums, i, nums[i]-1);
            }
        }
        
        List<Integer> ret = new ArrayList<Integer>();

        for (int i=0; i<nums.length; ++i) {
            if (nums[i]<0) {
                ret.add(i+1);
            }
        }

        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
