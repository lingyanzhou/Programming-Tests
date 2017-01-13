package lzhou.programmingtest.leetcode.test36;

public class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        boolean[] table = new boolean[9];
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                table[j] = false;
            }
            for (int j=0; j<9; ++j) {
                char c = board[i][j];
                if (c != '.') {
                    if (table[c-'1']) {
                        return false;
                    } else {
                        table[c-'1'] = true;
                    }
                }
            }
        }
        
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                table[j] = false;
            }
            for (int j=0; j<9; ++j) {
                char c = board[j][i];
                if (c != '.') {
                    if (table[c-'1']) {
                        return false;
                    } else {
                        table[c-'1'] = true;
                    }
                }
            }
        }
        
        for (int i=0; i<3; ++i) {
            for (int j=0; j<3; ++j) {
                for (int l=0; l<9; ++l) {
                    table[l] = false;
                }
                for (int l=3*i; l<3*i+3; ++l) {
                    for (int m=3*j; m<3*j+3; ++m) {
                        char c = board[l][m];
                        if (c != '.') {
                            if (table[c-'1']) {
                                return false;
                            } else {
                                table[c-'1'] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
