package lzhou.programmingtest.lintcode.test78;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        
        int length = strs[0].length();
        char[] prefix = strs[0].toCharArray();
        for (int i=1; i<strs.length; ++i) {
            length = Math.min(length, strs[i].length());
            for (int j=0; j<length; ++j) {
                if (strs[i].charAt(j)!=prefix[j]) {
                    length = j;
                    break;
                }
            }
        }
        return new String(prefix, 0, length);
    }
}
