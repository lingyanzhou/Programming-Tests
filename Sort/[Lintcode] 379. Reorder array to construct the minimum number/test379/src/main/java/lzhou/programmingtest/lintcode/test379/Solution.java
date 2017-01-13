package lzhou.programmingtest.lintcode.test379;

import java.util.*;

/*
 * Greedy, sort
 * Note: 1. when comparing strings, we need to wrap around each string several time, till we reach lcm(s1.len, s2.len)
 *       2. Mind leading zeros.
 *       3. Mind "0" result.
 */
public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        String[] numsStrs= new String[nums.length];
        for (int i=0; i<nums.length; ++i) {
            numsStrs[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(numsStrs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int end = gcd(s1.length(), s2.length());
                end=(s1.length()/end)*s2.length();
                for (int i=0; i<end; ++i) {
                    char c1 = s1.charAt(i%s1.length());
                    char c2 = s2.charAt(i%s2.length());
                    if (c1<c2) {
                        return -1;
                    } else if (c1>c2) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (String s: numsStrs) {
            if (sb.length()==0 && s.equals("0")) {
                continue;
            }
            sb.append(s);
        }
        if (sb.length()==0) {
            return "0";
        }
        return sb.toString();
    }
    
    private int gcd(int a, int b) {
        if (a==b) {
            return a;
        }
        while (a!=0  && b!=0) {
            int aa = a;
            a=a%b;
            b=b%aa;
        }
        if (a==0) {
            return b;
        }
        return a;
    }
}
