package lzhou.programmingtest.leetcode.test13;

import java.util.*;

public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        int prevDigit = 0;
        int result = 0;
        for (char c: s.toCharArray()) {
            int curDigit = simpleToInt(c);
            if (curDigit>prevDigit) {
                result-=prevDigit;
            } else {
                result+=prevDigit;
            }
            prevDigit=curDigit;
        }
        return result+prevDigit;
    }
    
    public int simpleToInt(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
