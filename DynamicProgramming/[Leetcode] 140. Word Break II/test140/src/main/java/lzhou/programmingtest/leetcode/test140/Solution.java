package lzhou.programmingtest.leetcode.test140;

import java.util.*;

import java.util.stream.*;

public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> dp = new HashMap<String, List<String>>();
        dp.put("", new ArrayList<String>());
        return wordBreakHelper(s, wordDict, dp);
    }
    
    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> dp) {
        if (!dp.containsKey(s)) {
            List<String> list = new ArrayList<String>();
            for (String w: wordDict) {
                if (w.length()==0) {
                } else if (s.equals(w)) {
                    list.add(w);
                } else if (s.startsWith(w)) {
                    for (String partial: wordBreakHelper(s.substring(w.length()), wordDict, dp)) {
                        list.add(w+" "+partial);
                    }
                }
            }
            
            dp.put(s,list);
        }
        return dp.get(s);
    }
}
