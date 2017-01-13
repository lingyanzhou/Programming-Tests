package lzhou.programmingtest.leetcode.test300;
import java.util.*;

/*Fastest implementation.

Key idea:
Keep an array, where the key is sequence length-1, and value is the last elemento of the sequence.
Keep the array's value in ascending order. This is guaranteed if two sequence has the same length, you use the smaller last element as the value.
*/
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] sequences = new int[nums.length+1];
        sequences[0] = Integer.MIN_VALUE;
        int longest = 0;
        for (int i: nums) {
            int ret = Arrays.binarySearch(sequences, 0, longest+1, i);
            if (ret>=0) {
            } else {
                ret = -1-ret;
                if (ret>longest) {
                    sequences[ret] = i;
                    longest+=1;
                } else {
                    sequences[ret] = Math.min(i, sequences[ret]);
                }
            }
        }

        return longest;
    }
}
