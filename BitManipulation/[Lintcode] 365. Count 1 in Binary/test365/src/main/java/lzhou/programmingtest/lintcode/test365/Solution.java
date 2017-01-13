package lzhou.programmingtest.lintcode.test365;

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int count = 0;
        while (num!=0) {
            int twosComp = (0xFFFFFFFF-num+1);
            int last1 = (twosComp & num);
            count+=1;
            num-=last1;
        }
        
        return count;
    }
};
