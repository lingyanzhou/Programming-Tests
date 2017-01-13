package lzhou.programmingtest.leetcode.test164;

import java.util.*;

/*
 * Bucket sort solution
 *
 * 1. Find the range of the array, min-max.
 * 2. Put the other n-2 elements into n-1 buckets
 * 3. Then at least one bucket is empty. So the gap is at least bucket size.
 * 4. The gap within a bucket will never exceed the bucket size.
 * 5. Simply scan through the buckets, and calculate between-bucket-gap.
 * 6. In implementation, we still allocate n buckets because the max value may need a bucket, and the overall max and min will be in the first or last backets, and won't affect our calculation.
 *
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length<2) {
            return 0;
        }
        int min=nums[0];
        int max=nums[0];
        for (int n:nums) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        
        int bucketSize = (int)Math.ceil(((double)max-min)/(nums.length-1));
        if (bucketSize==0){
            return 0;
        }
        //The real bucket size is still nums.length because min,max will not affect our calculation (they are at either end), and because of rounding, the max may be put in a bucket.
        int[] bucketsMin = new int[nums.length];
        int[] bucketsMax = new int[nums.length];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        for (int n:nums) {
            int i = (n-min)/bucketSize;
            bucketsMin[i] = Math.min(n, bucketsMin[i]);
            bucketsMax[i] = Math.max(n, bucketsMax[i]);
        }
        int j=-1;
        int maxGap = bucketSize;
        for (int i=0; i<nums.length; ++i) {
            if (bucketsMin[i]<=bucketsMax[i]) {
                if (j>=0) {
                    maxGap = Math.max(maxGap, bucketsMin[i]-bucketsMax[j]);
                }
                j=i;
            }
        }
        return maxGap;
    } 
}
