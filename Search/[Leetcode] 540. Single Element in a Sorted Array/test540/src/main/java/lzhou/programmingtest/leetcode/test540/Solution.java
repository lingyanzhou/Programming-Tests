package lzhou.programmingtest.leetcode.test540;

import java.util.*;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        int pairCount = nums.length/2;
        int rightPair = pairCount-1;
        int leftPair = 0;
        while (rightPair>=leftPair) {
            int mid = (rightPair+leftPair)/2;
            if (nums[mid*2]==nums[mid*2+1]) {
                leftPair=mid+1;
            } else {
                rightPair=mid-1;
            }
        }
        return nums[2*leftPair];
    }
}
