package lzhou.programmingtest.lintcode.test179;

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int nWithUnsetBits = n&(~setAllBitsBetween(i,j));
        int mShifted = m<<i;
        int mShiftedBounded = mShifted&setAllLowerBits(j+1);
        return nWithUnsetBits | mShiftedBounded;
        
    }
    
    private int setAllLowerBits(int i) {
        if (i>=32) {
            return -1;
        }
        return (1<<i)-1;
    }
    
    private int setAllBitsBetween(int i, int j) {
        return setAllLowerBits(j+1)-setAllLowerBits(i);
    }
}
