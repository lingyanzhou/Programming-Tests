package lzhou.programmingtest.leetcode.test459;

import java.util.*;

/*
 * KMP algorithm.
 * If a reapeating substring exists, the postfix of the whole string will be the postfix of a substring of the first half.
 */
public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int[] commonPrefix = new int[str.length()+1];
        commonPrefix[0] = -1;
        int k=-1;
        for (int i=0; i<str.length(); ++i) {
            //System.out.println(i);
            while (k>=0 && str.charAt(k)!=str.charAt(i)) {
                k=commonPrefix[k];
            }
            k+=1;
            commonPrefix[i+1] = k;
        }
        
        //System.out.println(Arrays.toString(commonPrefix));
    
        if (commonPrefix[str.length()]>0 && str.length()%(str.length()-commonPrefix[str.length()])==0) {
            return true;
        }
        return false;
    }
}
