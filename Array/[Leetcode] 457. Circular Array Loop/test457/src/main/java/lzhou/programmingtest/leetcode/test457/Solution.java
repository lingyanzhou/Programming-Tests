package lzhou.programmingtest.leetcode.test457;

public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i=0; i<nums.length; ++i) {
            if (nums[i]==0) {
                continue;
            }
            int fast = i;
            int slow = i;
            boolean positiveLoop = nums[i]>0;
            boolean valid = true;
            do {
                slow=nextIndex(nums, slow);
                fast=nextIndex(nums, fast);
                fast=nextIndex(nums, fast);
                if ((positiveLoop && nums[slow]<0) || (!positiveLoop && nums[slow]>0)) {
                    valid=false;
                    break;
                }
                if (isLoop1(nums, slow)) {
                    valid=false;
                    break;
                }
            } while (fast!=slow);

            if (valid) {
                return true;
            } else {
                fast = i;
                slow = i;
                do {
                    slow=nextIndex(nums, slow);
                    fast=nextIndex(nums, fast);
                    fast=nextIndex(nums, fast);
                    if ((positiveLoop && nums[slow]<0) || (!positiveLoop && nums[slow]>0)) {
                        valid=false;
                        break;
                    }
                    nums[slow]=0;
                    if (isLoop1(nums, slow)) {
                        valid=false;
                        break;
                    }
                } while (fast!=slow);
            }
        }
        return false;
    }

    private boolean isLoop1(int[] nums, int i) {
        return nums[i]%nums.length==0;
    }

    private int nextIndex(int[] nums, int i) {
        return (int)(((long)i+nums[i])%nums.length+nums.length)%nums.length;
    }
    private int prevIndex(int[] nums, int i) {
        return (int)(((long)i-nums[i])%nums.length+nums.length)%nums.length;
    }
}
