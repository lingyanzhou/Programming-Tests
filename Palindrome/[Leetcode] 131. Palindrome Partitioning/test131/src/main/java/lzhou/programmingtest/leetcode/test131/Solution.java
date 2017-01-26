package lzhou.programmingtest.leetcode.test131;

import java.util.*;

/**
 * DP + Manacher
 *   1. Scan the sting once, build up the an array indicating the length of palindromic substring centered at each index using manacher's algorithm.
 *   2. Recursively tet each cutting point.
 * Note: translating indices between manacher array is harder than using length.
 */
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        int[] manacher = manacherAlgorithm(s);
        
        return partitionHelper(s, manacher, 0, new ArrayList<String>(), new ArrayList<List<String>>());
    }
    
    private List<List<String>> partitionHelper(String s, int[] manacher, int start, List<String> partial, List<List<String>> result) {
        if (start==s.length()) {
            result.add(new ArrayList<String>(partial));
            return result;
        }
        int len = 1;
        int i=start*2+len;
        for (i=start*2+len; i<manacher.length; ++len, i=start*2+len) {
            if (manacher[i]>=len) {
                partial.add(s.substring(start, start+len));
                partitionHelper(s, manacher, start+len, partial, result);
                partial.remove(partial.size()-1);
            }
        }
        return result;
    }
    
    private int[] manacherAlgorithm(String s) {
        int[] manacher = new int[s.length()*2+1];
        char[] padded = new char[s.length()*2+1];
        for (int i=0; i<s.length(); ++i) {
            padded[i*2] = '\0';
            padded[i*2+1] = s.charAt(i);
        }
        padded[padded.length-1]='\0'; 
        
        int index = 0;
        int len = 1;
        for (; index<padded.length;) {
            while (index-len>=0 && index+len<padded.length && padded[index-len]==padded[index+len]) {
                len+=1;
            }
            manacher[index]=len;
           
            int len2 = 1;
            for (; len2<len; ++len2) {
                if (manacher[index-len2]==len-len2) {
                    break;
                } else {
                    manacher[index+len2]=Math.min(manacher[index-len2], len-len2);
                } 
            }
            len = len-len2;
            index = index+len2;
        }
        
        for (int i=0; i<manacher.length; ++i) {
            manacher[i]-=1;
        }
        
        return manacher;
    }
}
