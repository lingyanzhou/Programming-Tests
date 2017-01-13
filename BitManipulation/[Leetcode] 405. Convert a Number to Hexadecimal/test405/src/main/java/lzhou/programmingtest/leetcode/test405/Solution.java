package lzhou.programmingtest.leetcode.test405;
import java.lang.StringBuilder;
/**
 * Hello world!
 *
 */
public class Solution 
{
    private static char[] table = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        boolean headingZeros = true;
        for (int i=0; i<=28; i+=4) {
            int val4bits = (num<<i)>>>28;
            if (headingZeros && val4bits==0) {
                continue;
            }
            headingZeros = false;
            sb.append(table[val4bits]);
        }
        if (headingZeros) {
            sb.append('0');
        }
        return sb.toString();
    }
}
