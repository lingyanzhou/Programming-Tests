package lzhou.programmingtest.leetcode.test448;

import java.util.*;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length;) {
            if (nums[i]==i+1) {
                i+=1;
            } else if (nums[i]-1<0 || nums[i]-1>=nums.length) {
                i+=1;
            } else if (nums[i] == nums[nums[i]-1]) {
                nums[i]=-1;
                i+=1;
            } else {
                swap(nums, i, nums[i]-1);
            }
        }

        List<Integer> ret = new ArrayList<Integer>();

        for (int i=0; i<nums.length; ++i) {
            if (nums[i]!=i+1) {
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
