package lzhou.programmingtest.lintcode.test183;

import java.util.*;

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = 0;
        for (int l:L) {
            max=Math.max(max, l);
        }
        
        int lower=1;
        int upper=max;
        while (lower<=upper) {
            int mid = (int)(((long)lower+upper)/2);
            int kTry = countCuts(L, mid);
            if (kTry==k) {
                lower = mid+1;
            } else if (kTry<k) {
                upper = mid-1;
            } else {
                lower = mid+1;
            }
        }
        
        return (int)(lower-1);
    }
    
    private int countCuts(int[] L, int length) {
        int ret =0;
        for (int l:L) {
            ret+=l/length;
        }
        return ret;
    }
}
