package lzhou.programmingtest.leetcode.test53;


//divide and conquer approach
public class Solution2 {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, nums.length, 0, Integer.MIN_VALUE);
    }

    public int maxSubArrayHelper(int[] nums, int end, int prevSubArray, int max) {
        if (end==0) {
            return max;
        }
        int curMax = max;
        if (nums[end-1]<0) {
            while (end>0 && nums[end-1]<0) {
                prevSubArray+=nums[end-1];
                if (prevSubArray<0) {
                    curMax = Math.max(curMax, prevSubArray);
                    prevSubArray=0;
                }
                end -= 1;
            }
        } else {
            while (end>0 && nums[end-1]>=0) {
                prevSubArray+=nums[end-1];
                end -= 1;
            }
            curMax = Math.max(curMax, prevSubArray);
        }
        return maxSubArrayHelper(nums, end, prevSubArray, curMax);
    }
}
