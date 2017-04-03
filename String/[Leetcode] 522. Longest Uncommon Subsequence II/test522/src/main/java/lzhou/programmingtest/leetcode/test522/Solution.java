package lzhou.programmingtest.leetcode.test522;

import java.util.*;

public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length()>s2.length()) {
                    return -1;
                } else if (s1.length()<s2.length()) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        if (strs.length==1) {
            return strs[0].length();
        }
        if (strs.length>=2 && !strs[0].equals(strs[1])) {
            return strs[0].length();
        }
        for (int i=0; i<strs.length; ++i) {
            if (i+1<strs.length && strs[i].equals(strs[i+1])) {
                continue;
            }
            if (i-1>=0 && strs[i].equals(strs[i-1])) {
                continue;
            }
            boolean isSubSeq = false;
            for (int j=i-1; j>=0; --j) {
                if (isSubSequence(strs[j], strs[i])) {
                    isSubSeq = true;
                    break;
                }
            }
            if (!isSubSeq) {
                return strs[i].length();
            }
        }
        return -1;
    }
    
    private boolean isSubSequence(String s1, String s2) {
        int i=0, j=0;
        while (i<s1.length() && j<s2.length()) {
            if (s1.charAt(i)==s2.charAt(j)) {
                i+=1;
                j+=1;
            } else {
                i+=1;
            }
        }
        if (j==s2.length()) {
            return true;
        }
        return false;
    }
}
