package lzhou.programmingtest.leetcode.test134;

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        
        int beforeISum = 0;
        for (int i=0; i<gas.length;) {
            int sum = 0;
            int j=i;
            do {
                sum += gas[j]-cost[j];
                j+=1;
                if (sum<0) {
                    break;
                }
            } while (j!=i && j<gas.length);
            
            if ( j==gas.length) {
                if (beforeISum+sum>=0) {
                    return i;
                } else {
                    return -1;
                }
            }
            beforeISum+=sum;
            i=j;
        }
        return -1;
    }
}
