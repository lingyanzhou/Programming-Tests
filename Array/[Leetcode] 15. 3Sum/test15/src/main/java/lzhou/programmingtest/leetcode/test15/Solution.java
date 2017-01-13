package lzhou.programmingtest.leetcode.test15;

import java.util.*;

/*
 * Two pointers method
 * To avoid duplicated entries in the result, skip adjacent identical elements when moving i,j,k
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2;) {
            if (nums[i]>0) {
                break;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k) {
                if (nums[i]+nums[j]+nums[k]==0) {
                    ret.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    int prevNumsJ = nums[j];
                    while (j<k && nums[j]==prevNumsJ) {
                        j+=1;
                    }
                    int prevNumsK = nums[k];
                    while (j<k && nums[k]==prevNumsK) {
                        k-=1;
                    }
                } else if (nums[i]+nums[j]+nums[k]<0) {
                    int prevNumsJ = nums[j];
                    while (j<k && nums[j]==prevNumsJ) {
                        j+=1;
                    }
                } else {
                    int prevNumsK = nums[k];
                    while (j<k && nums[k]==prevNumsK) {
                        k-=1;
                    }
                }
            }
            
            int prevNumsI = nums[i];
            while (i<nums.length-2 && nums[i]==prevNumsI) {
                i+=1;
            }
        }
        return ret;
    }
}
