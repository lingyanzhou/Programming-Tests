package lzhou.programmingtest.leetcode.test167;

import java.util.*;

public class Solution 
{
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while (i<j) {
            if (numbers[i]+numbers[j]==target) {
                int[] ret = new int[2];
                ret[0] = i;
                ret[1] = j;
                return ret;
            } else if (numbers[i]+numbers[j]>target) {
                j-=1;
            } else {
                i+=1;
            }
        }
        return null;
    }
}
