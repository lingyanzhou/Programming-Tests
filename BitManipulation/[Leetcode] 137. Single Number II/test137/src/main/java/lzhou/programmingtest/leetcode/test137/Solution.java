package lzhou.programmingtest.leetcode.test137;

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length==0) {
            return -1;
        }
        int[] bits = new int[32];
        
        for (int i: nums) {
            for (int j=0; j<32; ++j) {
                if ((i&(1<<j))!=0) {
                    bits[j]+=1;
                }
            }
        }
        int ret=0;
        for (int i=0; i<32; ++i) {
            //System.out.println(bits[i]);
            if (bits[i]%3==1) {
                //System.out.println(i);
                ret|=(1<<i);
            }
        }
        return ret;
    }
}
