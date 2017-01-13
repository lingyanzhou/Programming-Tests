package lzhou.programmingtest.leetcode.test3;

import java.util.*;

/* 
 * Two pointer method.
 * 
 * Move j ahead, adding counts in the table. If we find a duplicate, then move i forward, removing characters until no duplicate in between i,j 
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) {
            return 0;
        }
        int[] charCounts = new int[256];
        char[] sChars = s.toCharArray();
        int answer = 1;
        int i=0; 
        int j=0; //inclusive
        charCounts[(int)sChars[0]]+=1;
        j++;
        while (j<sChars.length) {
            charCounts[(int)sChars[j]]+=1;
            while (charCounts[(int)sChars[j]]!=1) {
                charCounts[(int)sChars[i]]-=1;
                i++;
            } 
            answer = Math.max(answer, j-i+1);
            j++;
        }
        return answer;
    }
}
