package lzhoulzhou.programmingtest.leetcode.test41;

public class Solution 
{
    public int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length;) {
            if (nums[i]-1==i) {
                i+=1;
            } else if (nums[i]-1<0 || nums[i]-1>=nums.length) {
                nums[i]= -1;
                i+=1;
            } else if (nums[nums[i]-1]==nums[i]) {
                nums[i]= -1;
                i+=1;
            } else {
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
