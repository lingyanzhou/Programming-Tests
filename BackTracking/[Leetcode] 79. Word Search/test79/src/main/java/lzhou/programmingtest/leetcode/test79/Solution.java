package lzhou.programmingtest.leetcode.test79;

import java.util.*;

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board.length==0 || board[0].length==0) {
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[0].length; ++j) {
                if (existHelper(board, i, j, used, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean existHelper(char[][] board, int i, int j, boolean[][] used, String word, int start) {
        if (start==word.length()) {
            return true;
        }
        if (i<0 || j<0 || i>=board.length || j>=board[0].length) {
            return false;
        }
        if (used[i][j]) {
            return false;
        }
        if (board[i][j]!=word.charAt(start)) {
            return false;
        }
        used[i][j] = true;
        boolean result= existHelper(board, i-1, j, used, word, start+1) ||
                        existHelper(board, i+1, j, used, word, start+1) ||
                        existHelper(board, i, j-1, used, word, start+1) ||
                        existHelper(board, i, j+1, used, word, start+1);
        used[i][j] = false;
        return result;
    }
}
