package lzhou.programmingtest.leetcode.test127;
import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> queue= new HashSet<String>();
        
        queue.add(beginWord);
        wordList.remove(beginWord);
        wordList.add(endWord);
        Set<String> tmpQueue= new HashSet<String>();
        int length = 1;
        
        boolean found = false;
        while (!queue.isEmpty()) {
            //System.out.println(length);
            
            for (String sCur : queue) {
                char[] chars = sCur.toCharArray();
                for (int i=0; i<sCur.length(); ++i) {
                    
                    for (char c='a'; c<='z'; ++c) {
                        char orig = chars[i];
                        chars[i]=c;
                        String search = new String(chars);
                        if (search.equals(endWord)) {
                            return length+1;
                        }
                        if (wordList.contains(search)) {
                            tmpQueue.add(search);
                            wordList.remove(search);
                        }
                        chars[i] = orig;
                    }
                }
            }
            
            
            queue.clear();
            length+=1;
            Set<String> swap = tmpQueue;
            tmpQueue = queue;
            queue = swap;
        }
        if (found) {
            return length;
        } 
        return 0;
    }
    
}
