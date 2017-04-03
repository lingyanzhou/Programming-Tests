package lzhou.programmingtest.leetcode.test320;

import java.util.*;

public class Solution 
{
    public List<String> generateAbbreviations(String word) {
        return generateAbbreviationsHelper("", word, 0);
    }

    private List<String> generateAbbreviationsHelper(String p1, String p2, int abbrev) {
        if (p2.length()==0 && abbrev==0) {
            List<String> ret = new ArrayList<String>();
            ret.add(p1);
            return ret;
        }
        if (p2.length()==0 && abbrev!=0) {
            List<String> ret = new ArrayList<String>();
            ret.add(p1+abbrev);
            return ret;
        }
        List<String> ret = new ArrayList<String>();
        if (abbrev==0) {
            ret.addAll(generateAbbreviationsHelper(p1+p2.charAt(0), p2.substring(1), 0));
        } else {
            ret.addAll(generateAbbreviationsHelper(p1+abbrev+p2.charAt(0), p2.substring(1), 0));
        }
        ret.addAll(generateAbbreviationsHelper(p1, p2.substring(1), abbrev+1));

        return ret;
    }
}
