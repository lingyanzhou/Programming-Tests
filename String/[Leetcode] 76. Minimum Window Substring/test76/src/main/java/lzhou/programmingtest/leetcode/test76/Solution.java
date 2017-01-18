package lzhou.programmingtest.leetcode.test76;

import java.util.*;

/**
 * Two Pointer + Hash Table
 */
public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if (target.length()==0 || source.length()==0) {
            return "";
        }
        int[] targetTable = toTable(target);
        int[] table = Arrays.copyOf(targetTable, 256);
        
        int validI=-1;
        int validJ=source.length();
        
        int i=0;
        int j=0;
        while (j<=source.length()) {
            //System.out.println(i);
            //System.out.println(j);
            boolean valid=(j-i<target.length() || !isValid(table));
            if (valid && j==source.length()) {
                break;
            } else if (valid) {
                table[source.charAt(j)]-=1;
                j+=1;
            } else {
                if (j-i<validJ-validI) {
                    validI = i;
                    validJ = j;
                }
                table[source.charAt(i)]+=1;
                i+=1;
            }
        }
        if (validI==-1) {
            return "";
        }
        
        return source.substring(validI, validJ);
    }
    
    private int[] toTable(String s) {
        int[] ret = new int[256];
        for (int i=0; i<s.length(); ++i) {
            ret[s.charAt(i)] += 1;
        }
        return ret;
    }
    
    private boolean isValid(int[] table) {
        for (int i=0; i<256; ++i) {
            if (table[i]>0) {
                return false;
            }
        }
        return true;
    }
}
