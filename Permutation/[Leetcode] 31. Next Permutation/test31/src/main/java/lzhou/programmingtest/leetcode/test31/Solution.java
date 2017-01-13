package lzhou.programmingtest.leetcode.test31;

import java.util.*;
/**
 * Hello world!
 *
 */
public class Solution 
{
    public void nextPermutation(int[] nums) {
        int lastIncIndex = -1;

        for (int i=nums.length-2; i>=0; --i) {
            if (nums[i]-nums[i+1]<0) {
                lastIncIndex = i;
                break;
            }
        }

        reverse(nums, lastIncIndex+1, nums.length);
        if (lastIncIndex==-1) {
            return;
        }

        int found = Arrays.binarySearch(nums, lastIncIndex+1, nums.length, nums[lastIncIndex]);
        if (found<0) {
            found = -1 - found;
        } else {
            int foundOld = found;
            while (nums[found]==nums[foundOld]) {
                found+=1;
            }
        }
        swap(nums, lastIncIndex, found);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i=(start+end)/2-1; i>=start; --i) {
            swap(nums, start+end-1-i, i);
        }
    }
}
