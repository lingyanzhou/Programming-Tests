
package lzhou.programmingtest.leetcode.test169;

/*
 *Idea:
 * When we find two different elements, droping both of them will not affect the final result. 
 *
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int curVal = 0;
        int curValCount = 0;
        for (int i: nums) {
            if (curVal==i) {
                curValCount+=1;
            } else {
                curValCount-=1;
                if (curValCount<0) {
                    curVal=i;
                    curValCount=1;
                }
            }
        }
        return curVal;
    }
}
