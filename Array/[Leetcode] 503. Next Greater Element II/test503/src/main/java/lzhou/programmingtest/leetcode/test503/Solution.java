package lzhou.programmingtest.leetcode.test503;

import java.util.*;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<int[]> stack = new Stack<int[]>();
        for (int i=0; i<nums.length; ++i) {
            int n = nums[i];
            while (stack.size()>0 && stack.peek()[1]<n) {
                int[] tmp = stack.pop();
                result[tmp[0]] = n;
            }
            stack.push(new int[]{i, n});
        }
        for (int i=0; stack.size()>0 && i<stack.peek()[0]; ++i) {
            int n = nums[i];
            while (stack.size()>0 && stack.peek()[1]<n) {
                int[] tmp = stack.pop();
                result[tmp[0]] = n;
            }
        }
        return result;
    }
}
