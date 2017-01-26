package lzhou.programmingtest.leetcode.test5;

import java.util.*;

/**
 * Manacher's algorithm
 * O(n)
 *   1. Test palindrome by moving its center from left to right. Expand the current palindrome as long as possible.
 *   2. At each center, longest palindromes centered at left indices are calculated. Its right half can then be derived from its left half.
 *   3. For two sub palindromes symmetrical wrt the current center,
 *      3.1 if the left one does not exceed the current palindrome boundary, simply use its length for the right one. (Their boundaries are inside the current palindrome, which is fully explored.)
 *      3.2 if the left one exceeds the boundary, then make the right one's length be such that it just touches the boundary. (It has to be the case because otherwise, the current palindrome will have a larger length.)
 *      3.3 if they are equal, it means the right one may be further extended. Move the probe here.
 */
public class Solution {
    public String longestPalindrome(String s) {
        int[] manachers = calcManacher(s);
        int max = 0;
        int index = 0;
        for (int i=0; i<manachers.length; ++i) {
            if (manachers[i]>max) {
                index = i;
                max= manachers[i];
            }
        }
        
        return s.substring(index/2-manachers[index]/2, index/2-manachers[index]/2+manachers[index]);
    }
    
    private int[] calcManacher(String s) {
        char[] padded = new char[s.length()*2+1];
        for (int i=0; i<s.length(); ++i) {
            padded[i*2] = '\0';
            padded[i*2+1] = s.charAt(i);
        }
        padded[padded.length-1]='\0';
        
        int[] ret = new int[padded.length];
        
        int index = 0;
        int len = 1;
        while (index<padded.length) {
            while (index-len>=0 && index+len<padded.length && padded[index-len]==padded[index+len]) {
                len+=1;
            }
            ret[index]=len;
            
            int len2=1;
            while (len2<len) {
                if (ret[index-len2]==len-len2) {
                    break;
                } else {
                    ret[index+len2] = Math.min(ret[index-len2], len-len2);
                }
                len2+=1;
            }
            
            len = Math.max(len-len2, 1);
            index = index+len2;
        }
        
        for (int i=0; i<ret.length; ++i) {
            ret[i]-=1;
        }
        
        return ret;
    }
}
