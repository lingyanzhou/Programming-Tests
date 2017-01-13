package lzhou.programmingtest.leetcode.test12;

import java.util.*;

public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        int powTen = 1;
        while (n>=powTen*10) {
            powTen*=10;
        }
        StringBuilder sb = new StringBuilder();
        while (n!=0) {
            int d = n/powTen;
            if (d!=0) {
                digitToRoman(d, powTen, sb);
            }
            n%=powTen;
            powTen/=10;
        }
        
        return sb.toString();
    }
    
    private void digitToRoman(int n, int powTen, StringBuilder sb) {
        if (n==0) {
            return;
        } else if (n==1) {
            if (powTen==1) {
                sb.append('I');
            } else if (powTen==10) {
                sb.append('X');
            } else if (powTen==100) {
                sb.append('C');
            } else if (powTen==1000) {
                sb.append('M');
            }
        } else if (n<=3) {
            digitToRoman(1, powTen, sb);
            char last = sb.charAt(sb.length()-1);
            for (int i=n-1; i>0; --i) {
                sb.append(last);
            }
        } else if (n==4) {
            digitToRoman(1, powTen, sb);
            digitToRoman(5, powTen, sb);
        } else if (n==5) {
            if (powTen==1) {
                sb.append('V');
            } else if (powTen==10) {
                sb.append('L');
            } else if (powTen==100) {
                sb.append('D');
            }
        } else if (n<=8) {
            digitToRoman(5, powTen, sb);
            digitToRoman(n-5, powTen, sb);
        } else {
            digitToRoman(1, powTen, sb);
            digitToRoman(1, powTen*10, sb);
        }
    }
}
