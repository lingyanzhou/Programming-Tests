package lzhou.programmingtest.leetcode.test179;

import java.util.*;

/*
 * Greedy, sort
 * Note: 1. when comparing strings, we need to wrap around each string several time, till we reach lcm(s1.len, s2.len)
 *       2. Mind leading zeros.
 *       3. Mind "0" result.
 */
public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        String[] numStr = new String[num.length];
        for (int i=0; i<num.length; ++i) {
            numStr[i] = Integer.toString(num[i]);
        }
        Arrays.sort(numStr, new Comparator<String>() {
            public int compare(String n1, String n2) {
                int maxCompare = (int)((long)n1.length()*n2.length()/gcd(n1.length(), n2.length()));
                for (int i=0; i<maxCompare; ++i) {
                    char c1 = n1.charAt(i%n1.length());
                    char c2 = n2.charAt(i%n2.length());
                    if (c1>c2) {
                        return -1;
                    } else if (c1<c2) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        
        //System.out.println(Arrays.toString(numStr));
        
        StringBuilder sb= new StringBuilder();
        for (String i: numStr) {
            sb.append(i);
        }
        while (sb.length()>1) {
            if (sb.charAt(0)=='0') {
                sb.delete(0, 1);
            } else {
                break;
            }
        }
        return sb.toString();
    }
    
    private int gcd(int a, int b) {
        if (a==b) {
            return a;
        }
        while (a!=0 && b!=0) {
            int aa = a;
            a%=b;
            b%=aa;
        }
        if (a==0) {
            return b;
        }
        return a;
    }
}
