package lzhou.programmingtest.leetcode.test189;

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotate(int[] nums, int offset) {
        int n = nums.length;
        if (n<2) {
            return;
        }
        offset = (offset%n+n)%n;
        if (offset==0) {
            return;
        }
        int l = gcd(n, offset);
        
        for (int i=0; i<l; ++i) {
            int last = nums[(i-offset+n)%n];
            int nextIndex = i;
            do {
                int tmp = nums[nextIndex];
                nums[nextIndex] = last;
                last = tmp;
                nextIndex = (nextIndex+offset)%n;
            } while (nextIndex!=i);
        }
    }
    
    private int gcd(int a, int b) {
        while (a!=0 && b!=0) {
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
