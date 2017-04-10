package lzhou.programmingtest.leetcode.test556;

import java.util.*;

public class Solution {
    public int nextGreaterElement(int n) {
        char[] buff = Integer.toString(n).toCharArray();
        int len = buff.length;
        int decStart = len-2;
        
        //Find the index from which the sequence is monotonically decreasing.
        for (decStart=len-2; decStart>=0; --decStart) {
            if (buff[decStart]<buff[decStart+1]) {
                break;
            }
        }
        if (decStart==-1) {
            return -1;
        }
        
        //Make the part monotonically increasing.
        Arrays.sort(buff, decStart+1, len);
        
        //Find the next bigger element in the part.
        int index = Arrays.binarySearch(buff, decStart+1, len, buff[decStart]);
        if (index<0) {
            index = -index-1;
        } else {
            while (buff[decStart]==buff[index]) {
                index+=1;
            }
        }
        
        // Swap
        swap(buff, index, decStart);
        
        long ret = 0;
        
        for (int i=0; i<len; ++i) {
            ret = ret*10+Character.digit(buff[i], 10);
            if (ret>Integer.MAX_VALUE) {
                return -1;
            }
        }
        return (int)ret;
    }
    
    private void swap(char[] buff, int i, int j) {
        char t = buff[i];
        buff[i] = buff[j];
        buff[j] = t;
    }
}
