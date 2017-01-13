package lzhou.programmingtest.leetcode.test8;

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int myAtoi(String str) {
        char[] sChars = str.toCharArray();
        long result = 0;
        byte sign = 0;

        int i=0;
        boolean nextIsNumber = false;
        for (i=0; i<sChars.length; ++i) {
            char c = sChars[i];
            if (Character.isDigit(c)) {
                if (sign==0) {
                    sign=1;
                }
                break;
            } else if (!nextIsNumber && c==' ') {
            } else if (!nextIsNumber && c=='+') {
                nextIsNumber = true;
                sign=1;
            } else if (!nextIsNumber && c=='-') {
                nextIsNumber = true;
                sign=-1;
            } else {
                return 0;
            }
        }
        for (; i<sChars.length; ++i) {
            char c = sChars[i];
            if (Character.isDigit(c)) {
                result = result*10+(c-'0');
                if (sign==1 && result>=Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign==-1 && result>Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        if (result==0) {
            return 0;
        } else if (sign==1) {
            return (int)(result);
        } else {
            return (int)(-result);
        }
    }
}
