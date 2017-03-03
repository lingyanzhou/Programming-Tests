package lzhou.programmingtest.leetcode.test524;

import java.util.*;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        int lenS = s.length();
        String result = "";
        for (String w : d) {
            int i=0;
            int j=0;
            int lenW=w.length();
            
            while (i<lenS && j<lenW) {
                if (s.charAt(i)==w.charAt(j)) {
                    i+=1;
                    j+=1;
                } else {
                    i+=1;
                }
            }
            if (j==lenW && (result.length()<w.length() || (result.length()==w.length() && result.compareTo(w)>0))) {
                result = w;
            }
        }
        return result;
    }
}
