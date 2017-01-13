package lzhou.programmingtest.leetcode.test312;
import java.util.*;

/*
 * Recursive
 */
public class Solution2 {
    public int maxCoins(int[] nums) {
        return maxCoinsHelper(nums, 0, nums.length-1, 1, 1, new int[nums.length][nums.length]);
    }
    
    private int maxCoinsHelper(int[] nums, int first, int last, int left, int right, int[][] dp) {
        if (last<first) {
            return 0;
        }
        if (dp[first][last]!=0) {
            return dp[first][last];
        }
        int ret = 0;
        for (int i=first; i<=last; ++i) {
            int tmp = nums[i]*left*right;
            tmp += maxCoinsHelper(nums, first, i-1, left, nums[i], dp);
            tmp += maxCoinsHelper(nums, i+1, last, nums[i], right, dp);
            ret = Math.max(tmp, ret);
        }
        dp[first][last] = ret;
        return ret;
    }
}
