package lzhou.programmingtest.leetcode.test93;

import java.util.*;

public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        // Write your code here
        List<String> ret = new ArrayList<String>();
        if (s.length()>12) {
            return ret;
        }
        char[] sChars = s.toCharArray();
    
        return restoreIpAddressesHelper(sChars, 0, 0, new StringBuilder(), ret);
    }
    
    private List<String> restoreIpAddressesHelper(char[] sChars, int index, int segment, StringBuilder sb, List<String> result) {
        if (index==sChars.length) {
            return result;
        }
        int curSegmentNum = 0;
        if (segment==3) {
            boolean firstZero = false;
            for (int i=index; i<sChars.length; ++i) {
                if (firstZero) {
                    return result;
                }
                curSegmentNum = 10*curSegmentNum+(sChars[i]-'0');
                if (curSegmentNum==0) {
                    firstZero=true;
                }
                if (curSegmentNum>255) {
                    return result;
                }
            }
            sb.append(sChars, index, sChars.length-index);
            result.add(sb.toString());
            return result;
        } else {
            for (int i=index; i<index+3 && i<sChars.length; ++i) {
                curSegmentNum = 10*curSegmentNum+(sChars[i]-'0');
                
                if (curSegmentNum>255) {
                    return result;
                }
                int curSbLen = sb.length();
                sb.append(sChars, index, i-index+1);
                sb.append('.');
                restoreIpAddressesHelper(sChars, i+1, segment+1, sb, result);
                sb.delete(curSbLen, sb.length());
                if (curSegmentNum==0) {
                    return result;
                }
            }
            return result;
        }
        
    }
}
