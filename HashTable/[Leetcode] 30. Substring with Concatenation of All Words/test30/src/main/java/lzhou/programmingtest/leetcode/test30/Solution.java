package lzhou.programmingtest.leetcode.test30;

import java.util.*;

/**
 * HashTable + two pointer solution
 * Ref: http://www.cnblogs.com/grandyang/p/4521224.html
Note: 
  *  The words all have the same length, $wl
Idea:
  *  Treat every $wl substring as a unit, when traversing
  *  Keep two pointer,$ and $k, and a map, containing the words found between the two pointers
  *  Move $k $wl steps forward. Try to add the substring($k, $k+$wl)to the map.
      * If the substring is not  in the word list, it indicates a gap. Reset map, and let $j=$k
      * If the substring is in the map, but its count has exceeded its max, we move $j forward, $k at a time, decreasing the count of substring($j, $j+$wl) in the map, until the map is valid.
      * Otherwise, increase its count.
  * If $j, $k contains all  words, add $j to the resultant list.
 */
public class Solution {
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        if (words.length==0) {
            return ret;
        }
        int wl = words[0].length();
        int totalWl = words.length*wl;

        Map<String, Integer> wordSet = new HashMap<String, Integer>();
        Map<String, Integer> curSet = new HashMap<String, Integer>();
        for (String w:words) {
            Integer tmp = wordSet.get(w);
            if (tmp==null) {
                tmp=1;
            } else {
                tmp = tmp+1;
            }
            wordSet.put(w, tmp);
        }
        
        for (int i=0; i<wl; ++i) {
            int j=i; 
            int k=i;
            curSet.putAll(wordSet);
            while (k+wl<=s.length()) {
                String subs = s.substring(k, k+wl);
                k=k+wl;
                if (wordSet.containsKey(subs)) {
                    while (curSet.get(subs)<1) {
                        String tmp = s.substring(j, j+wl);
                        curSet.put(tmp, curSet.get(tmp)+1);
                        j=j+wl;
                    }
                    curSet.put(subs,curSet.get(subs)-1);
                    if((k-j)/wl==words.length) {
                        ret.add(j);
                    }
                } else {
                    j=k;
                    curSet.putAll(wordSet);
                }
            }
        }
        return ret;
    }
}
