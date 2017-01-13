package lzhou.programmingtest.leetcode.test268;


//Use the array itself to remember numbers.
public class Solution3 {
    public int missingNumber(int[] nums) {
        boolean foundN = false;
        int n = nums.length;

        for (int i=0; i<n;) {
            if (nums[i]==i) {
                ++i;
            } else if (nums[i]==n) {
                foundN=true;
                ++i;
            } else {
                swap(nums, i, nums[i]);
            }
        }
        if (foundN) {
            for (int i=0; i<n; ++i) {
                if (nums[i]!=i) {
                    return i;
                }
            }
            return n;
        } else {
            return n;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
