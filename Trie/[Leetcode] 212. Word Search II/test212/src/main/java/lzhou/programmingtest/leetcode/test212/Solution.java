package lzhou.programmingtest.leetcode.test212;

import java.util.*;

/**
 * Trie solution.
 *   1. Trie can narrow down the search space.
 *   2. Remove the word from the trie once we add it into the result list.
 * Improvements:
 *   1. Remove the whole subtrie if all its decendants are not words.
 */
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> findWords(char[][] board, String[] words) {
        // write your code here
        List<String> results = new ArrayList<String>();
        int n = board.length;
        if (n==0) {
            return results;
        }
        int m= board[0].length;
        if (m==0) {
            return results;
        }
        
        Trie root = new Trie();
        root.addAll(Arrays.asList(words));
        
        boolean[][] seen = new boolean[n][m];
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                dfsWordSearch(board, seen, i, j, root, results);
            }
        }
        return results;
    }
    
    private void dfsWordSearch(char[][] board, boolean[][] seen, int i, int j, Trie root, List<String> results) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || root==null || seen[i][j]) {
            return;
        }
        
        root = root.next(board[i][j]);
        if (root==null) {
            return;
        }
        if (root.isWord()) {
            results.add(root.word);
            root.word=null; //Remove the word so we don't have duplcates. We can further remove the subtree if all its decendants are not words (not implemented).
        }
        seen[i][j]=true;
        dfsWordSearch(board, seen, i+1, j, root, results);
        dfsWordSearch(board, seen, i-1, j, root, results);
        dfsWordSearch(board, seen, i, j+1, root, results);
        dfsWordSearch(board, seen, i, j-1, root, results);
        seen[i][j]=false;
    }
}



class Trie {
    String word;
    Trie[] children;
    
    public Trie() {
        word = null;
        children = new Trie[26];
    }
    
    public boolean isWord() {
        return word!=null;
    }
    public void addAll(List<String> strs) {
        for (String s: strs) {
            add(s);
        }
    }
    
    public void add(String s) {
        Trie cur = this;
        for (int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            int ind = c-'a';
            if (cur.children[ind]==null) {
                cur.children[ind] = new Trie();
            }
            cur  = cur.children[ind];
        }
        cur.word = s;
    }
    
    public Trie next(char c) {
        return children[c-'a'];
    }
}
