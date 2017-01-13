package lzhou.programmingtest.leetcode.test91;

import java.util.*;

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s.length()==0 || s.charAt(0)=='0') {
            return 0;
        }
        int prev2=1;
        int prev=1;
        int i=1;
        int cur=0;
        char prevChar = s.charAt(0);
        
        for (; i<s.length(); ++i) {
            char c = s.charAt(i);
            if (c=='0') {
                cur = 0;
            } else {
                cur = prev;
            }
            if (prevChar!='0' && ((prevChar-'0')*10+(c-'0')<=26)) {
                cur+=prev2;
            }
            prev2=prev;
            prev=cur;
            prevChar = c;
        }
        
        return prev;
    }
}
