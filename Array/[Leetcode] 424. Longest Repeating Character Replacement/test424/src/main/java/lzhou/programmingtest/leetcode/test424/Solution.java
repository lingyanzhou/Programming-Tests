package lzhou.programmingtest.leetcode.test424;

import java.util.*;

/*
 * Two Pointer solution
 * Idea:
 *   1. For each substring, we need to keep its majority characters. Anything else need ot be replaced.
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
            
        int i=0;
        int j=0;
        int ret = 0;
        int maxChar =0;
        for (; j<s.length(); ++j) {
            int c = s.charAt(j)-'A';
            counts[c]+=1;
            if (counts[c]>counts[maxChar]) {
                maxChar = c;
            }
            int toReplace = j+1-i-counts[maxChar];
            if (toReplace>k) {
                counts[s.charAt(i)-'A']-=1;
                i+=1;
            } 
            ret = Math.max(ret, j+1-i);
        }
        
        return ret;
    }
}
