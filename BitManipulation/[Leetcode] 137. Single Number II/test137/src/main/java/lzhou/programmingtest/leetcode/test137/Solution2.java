package lzhou.programmingtest.leetcode.test137;

public class Solution2 {
    //Trueth table
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int c:nums) {
            int tmp = a;
            a = (a^c)&(~b);
            b = (tmp&(~b)&c)|((~tmp)&b&(~c));
        }
        return a;
    }
}
