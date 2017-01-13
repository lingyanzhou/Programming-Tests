package lzhou.programmingtest.leetcode.test5;

import java.util.*;

/*
 *Manacher’s Algorithm
 * O(n)
 */
public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s.length()==0) {
            return "";
        }
        char[] padded = makePadded(s);
        int[] lens = new int[padded.length];
        for (int i=0; i<padded.length;) {
            while (i-lens[i]>=0 && i+lens[i]<padded.length && padded[i-lens[i]]==padded[i+lens[i]]) {
                lens[i]+=1;
            }
            int j=i+1;
            for (; j<i+lens[i]; ++j) {
                lens[j] = lens[2*i-j];
                if (lens[j]+j==i+lens[i]) {
                    break;
                } else if (lens[j]+j>i+lens[i]) {
                    lens[j] =i+lens[i]-j;
                }
            }
            i=j;
        }
        
        //System.out.println(Arrays.toString(lens));
        
        for (int i=0; i<lens.length; ++i) {
            lens[i]-=1;
        }
        
        int max = 0;
        int maxIndex= 0;
        for (int i=0; i<lens.length; ++i) {
            if (max<lens[i]) {
                max=lens[i];
                maxIndex = i;
            }
        }
        
        int start = maxIndex/2-lens[maxIndex]/2;
        int end = start+lens[maxIndex];
        
        return s.substring(start, end);
    }
    
    private char[] makePadded(String s) {
        char[] padded = new char[1+2*s.length()];
        int[] palindrones = new int[padded.length];
        
        for (int i=0; i<s.length(); ++i) {
            padded[2*i]='\0';
            padded[2*i+1]=s.charAt(i);
        }
        padded[2*s.length()]='\0';
        return padded;
    }
}
