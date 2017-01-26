package lzhou.programmingtest.leetcode.test214;

import java.util.*;

/**
 * 1. Find the longest palindrome that contains the left most character.
 * 2. Make a copy of the part that is not contains in the palindrome, and reverse it.
 * 3. Prepend the reversed copy to the original string. 
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int[] manacher = calcManacher(s);
        int max=0;
        int index = 0;
        for (int i=0; i<manacher.length; ++i) {
            if (manacher[i]==i && manacher[i]>max) {
                max = manacher[i];
                index = i;
            }
        }
        if (index==s.length()) {
            return s;
        }
        String part1 = s.substring(0, max);
        String part2 = s.substring(max, s.length());
        String part0 = reverse(part2);
        
        return part0+part1+part2;
    }
    
    private String reverse(String s) {
        char[] sc = s.toCharArray();
        for (int i=s.length()/2-1; i>=0; --i) {
            char t = sc[s.length()-1-i];
            sc[s.length()-1-i] = sc[i];
            sc[i] = t;
        }
        return new String(sc);
    }
    
    private int[] calcManacher(String s) {
        char[] padded = new char[s.length()*2+1];
        for (int i=0; i<s.length(); ++i) {
            padded[2*i] = '\0';
            padded[2*i+1] = s.charAt(i);
        }
        padded[padded.length-1] = '\0';
        
        int[] ret = new int[padded.length];
        int index = 0;
        int len=1;
        while (index<padded.length) {
            while (index-len>=0 && index+len<padded.length && padded[index-len]==padded[index+len]) {
                len+=1;
            }
            ret[index] = len;
            int len2=1;
            while (len2<len) {
                if (ret[index-len2]==len-len2) {
                    break;
                } else {
                    ret[index+len2] = Math.min(len-len2, ret[index-len2]);
                }
                len2+=1;
            }
            
            len = Math.max(1, len-len2);
            index = index +len2;
        }
        
        for (int i=0; i<ret.length; ++i) {
            ret[i] -=1;
        }
        
        return ret;
    }
}
