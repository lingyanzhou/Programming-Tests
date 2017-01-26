package lzhou.programmingtest.lintcode.test617;

import java.util.*;

/**
 * Ref: http://www.jiuzhang.com/solutions/maximum-average-subarray/
 * 
 * Binary search
 * 
 *  1. Max average of any sized subarray is its max element. So is for min.
 *  2. The result must be between max and min
 *  3. To find whether our guess is the result, we transform the average problem to sum. Minus every element by the guess. Then if a subarray sum is larger than 0, it has a larger mean.
 *  4. If any such subarray has a larger mean, we can raise our guess. Otherwise, we lower it.
 */
public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for (int n:nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        int loop=100;
        
        while (min<max-0.0001 && --loop>0) {
            double mid = (max+min)/2.0;
            //System.out.println(mid);
            if (tryAverage(nums, k, mid)) {
                min = mid;
            } else {
                max=mid;
            }
        }
        
        return min;
    }
    
    private boolean tryAverage(int[] nums, int k, double guess) {
        double[] sum = new double[nums.length+1];
        for (int i=0; i<k-1; ++i) {
            sum[i+1] = sum[i]+nums[i]-guess;
            //System.out.println(sum[i+1]);
        }
        double minPrev = sum[0];
        for (int i=k-1; i<nums.length; ++i) {
            sum[i+1] = sum[i]+nums[i]-guess;
            minPrev = Math.min(minPrev, sum[i+1-k]);
            
            if (sum[i+1]-minPrev>=0) {
                return true;
            }
            
        }
        return false;
    }
}
