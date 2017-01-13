package lzhou.programmingtest.leetcode.test300;
import java.util.*;

//Slow, because some useless values are in the tree map
public class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for (int i: nums) {
            int longestPrevSeq = 0;
            for (int v: map.headMap(i).values()) {
                longestPrevSeq = Math.max(longestPrevSeq, v);
            }
            int newSeqLen = longestPrevSeq+1;
            if (map.containsKey(i)) {
                newSeqLen = Math.max(newSeqLen, map.get(i));
            }
            map.put(i, newSeqLen);
        }

        int longest = 0;
        for (int v: map.values()) {
            longest = Math.max(longest, v);
        }
        return longest;
    }
}
