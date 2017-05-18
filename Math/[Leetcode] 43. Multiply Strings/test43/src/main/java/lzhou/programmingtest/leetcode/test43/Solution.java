package lzhou.programmingtest.leetcode.test43;

import java.util.*;

import java.util.stream.*;

public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        int n=num1.length();
        int m=num2.length();
        int[] intBuf = new int[m+n]; 
            
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                int tmp = Character.digit(num1.charAt(n-1-i),10)*Character.digit(num2.charAt(m-1-j),10);
                addAt(intBuf, tmp, i+j);
            }
        }
        int startIndex = n+m-1;
        for (int i=0; i<n+m; ++i) {
            if (intBuf[i]!=0) {
                startIndex=i;
                break;
            }
        }
        char[] charBuf = new char[n+m-startIndex];
        for (int i=0; i<n+m-startIndex; ++i) {
            charBuf[i]=(char)('0'+intBuf[startIndex+i]);
        }
        
        return new String(charBuf);
    }
    
    private void addAt(int[] intBuf, int num, int pos) {
        if (num==0 || pos==intBuf.length) {
            return;
        }
        num+=intBuf[intBuf.length-pos-1];
        intBuf[intBuf.length-pos-1] = num%10;
        addAt(intBuf, num/10, pos+1);
    }
}
