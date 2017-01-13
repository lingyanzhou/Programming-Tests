package lzhou.programmingtest.leetcode.test472;

import java.util.*;

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Trie[] wordTries = new Trie[words.length];
        Trie root = new Trie();
        for (int i=0; i<words.length; ++i) {
            wordTries[i] = root.add(words[i], i);
        }
        
        List<String> ret = new ArrayList<String>();
        
        for (int i=0; i<words.length; ++i) {
            //Skip "", strings that are prefix of other strings, and that are already determined as concatenated
            if (wordTries[i]==null || wordTries[i].canCombine || wordTries[i].hasChildren) {
                continue;
            }
            String s= words[i];

            Trie cur = root;
            for (int j=0; j<s.length(); ++j) {
                char c = s.charAt(j);
                cur = cur.children[c-'a'];

                if (!cur.canCombine && cur.index==-1) {
                    continue;
                }
                
                Trie tmpCur = cur;
                Trie shorterCur = root;
                for (int k=j+1; k<s.length() && shorterCur!=null; ++k) {
                    c = s.charAt(k);
                    tmpCur = tmpCur.children[c-'a'];
                    shorterCur = shorterCur.children[c-'a'];
                    if (shorterCur!=null && (shorterCur.canCombine || shorterCur.index!=-1)) {
                        tmpCur.canCombine=true;
                    }
                }
            }
        }
        
        for (int i=0; i<wordTries.length; ++i) {
            if (wordTries[i]!=null && wordTries[i].canCombine) {
                ret.add(words[i]);
            }
        }
        
        return ret;
    }
    
    static public class Trie {
        Trie[] children;
        int index;
        boolean canCombine;
        boolean hasChildren;
        
        public Trie() {
            index = -1;
            canCombine = false;
            hasChildren=false;
            children = new Trie[26];
        }
        
        public boolean isWord() {
            return index!=-1;
        }
        
        public Trie add(String s, int index) {
            if (s.length()==0) {
                return null;
            }
            Trie cur = this;

            for (char c: s.toCharArray()) {
                int cIndex = c-'a';
                if (cur.children[cIndex]==null) {
                    cur.children[cIndex]= new Trie();
                }
                cur.hasChildren=true;
                cur = cur.children[cIndex];
            }
            cur.index=index;
            return cur;
        }
    }
}
