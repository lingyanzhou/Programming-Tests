package lzhou.programmingtest.leetcode.test268;


//Math Solution: arithmetic sequence
public class Solution1 {
    public int missingNumber(int[] nums) {
        long sum = 0;
        long n = nums.length;
        for (int i: nums) {
            sum+=i;
        }
        return (int)((n*(n+1))/2-sum);
    }
}
