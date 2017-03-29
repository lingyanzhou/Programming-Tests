package lzhou.programmingtest.lintcode.test570;

import java.util.*;

public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
    public int findMissing2(int n, String str) {
        // Write your code here
        boolean[] seen = new boolean[n];
        Integer result = findMissing2Helper(seen, str, 0);
        if (result==null) {
            return 0;
        }
        return result;
    }
    
    private Integer findMissing2Helper(boolean[] seen, String str, int index) {
        // Write your code here
        if (index>=str.length()) {
            int i=0;
            for (; i<=seen.length; ++i) {
                if (!seen[i]) {
                    return i+1;
                }
            }
        }
        if (str.charAt(index)=='0') {
            return null;
        } else {
            //One digit:
            int tmp = str.charAt(index)-'0';
            //System.out.println(tmp);
            Integer result= null;
            if (tmp>seen.length || seen[tmp-1]) {
            } else {
                seen[tmp-1]=true;
                result = findMissing2Helper(seen, str, index+1);
                seen[tmp-1]=false;
                if (result!=null) {
                    return result;
                }
            }
            
            //Two digit:
            if (index+1>=str.length()) {
                return null;
            }
            tmp = tmp*10+(str.charAt(index+1)-'0');
            //System.out.println(tmp);
            if (tmp>seen.length || seen[tmp-1]) {
                return null;
            }
            seen[tmp-1]=true;
            result = findMissing2Helper(seen, str, index+2);
            seen[tmp-1]=false;
          
            return result;
        }
    }
}
