package lzhou.programmingtest.leetcode.test300;
import java.util.*;

/* DP solution
 * O(nlogn)
 *
 *   * sequences[i][] contains the largest element in all sequences when element i in num is processed.
 *     If two sequence has the same length, we only need to keep the one with the smaller largest element.
 *     The lengths of the sequences are the indices .
 *     It is sorted in ascending order.
 *   * Transfer: sequence[i+1][]: replace the smallest larger element in sequence[i][] with num[i+1], or append num[i+1] to the end.
 * 
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
