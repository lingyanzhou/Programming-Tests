package lzhou.programmingtest.lintcode.test564;
import java.util.*;
public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        if (nums.length==0) {
            return 1;
        }
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        int[] dpNext = new int[target+1];
        dp[0] = 1;

        int min = nums[0];
        int ret = 0;

        for (int k=0; k<target/min; ++k) {
            for (int j=nums.length-1; j>=0; --j) {
                int num = nums[j];
                for (int i=target; i>=k*min+num; --i) {
                    dpNext[i] = dpNext[i]+ dp[i-num];
                }
            }
            int[] tmp = dp;
            dp = dpNext;
            dpNext = tmp;
            Arrays.fill(dpNext, 0);

            ret+= dp[target];
        }
        return ret;
    }
}
