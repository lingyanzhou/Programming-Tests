package lzhou.programmingtest.leetcode.test211;
import java.util.*;

public class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word);
    }
}

class TrieNode {
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for (char c: word.toCharArray()) {
            if (cur.children[c-'a']==null) {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord=true;
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0);
    }

    private boolean search(char[] word, int start) {
        TrieNode cur = this;
        int i = start;
        for (i=start; i<word.length && word[i]!='.'; ++i) {
            char c = word[i];
            
            if (cur.children[c-'a']==null) {
                return false;
            }
            cur = cur.children[c-'a'];
        }
        if (i==word.length) {
            return cur.isWord;
        }
        //Word[i]=='.'
        for (TrieNode t: cur.children) {
            if (t!=null) {
                if (t.search(word, i+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
