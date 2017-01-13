package lzhou.programmingtest.leetcode.test438;

import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] table = new int[26];
        if (s.length()==0 || p.length()==0 || s.length()<p.length()) {
            return new ArrayList<Integer>();
        }

        List<Integer> ret = new ArrayList<Integer>();
        for (int i=0; i<p.length(); ++i) {
            table[p.charAt(i)-'a']+=1;
        }
        for (int i=0; i<p.length(); ++i) {
            table[s.charAt(i)-'a']-=1;
        }
        if (allZero(table)) {
            ret.add(0);
        }
        for (int i=1; i<=s.length()-p.length(); ++i) {
            table[s.charAt(i-1)-'a'] +=1;
            table[s.charAt(i+p.length()-1)-'a'] -=1;
            if (allZero(table)) {
                ret.add(i);
            }
        }
        return ret;
    }

    private boolean allZero(int[] table) {
        for (int i: table) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
}
