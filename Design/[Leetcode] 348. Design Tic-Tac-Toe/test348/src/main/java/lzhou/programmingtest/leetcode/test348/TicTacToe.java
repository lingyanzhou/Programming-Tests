package lzhou.programmingtest.leetcode.test348;

import java.util.*;

public class TicTacToe 
{
    int n;
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    public TicTacToe(int n) {
        this.n=n;
        rows= new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        int inc = 1;
        if (player==1) {
            inc=1;
        } else {
            inc=-1;
        }

        rows[row]+=inc;
        cols[col]+=inc;
        if (row==col) {
            diag+=inc;
        }
        if (row+col==n-1) {
            antiDiag += inc;
        }

        if (rows[row]==n*inc || cols[col]==n*inc || diag==n*inc || antiDiag==n*inc) {
            return player;
        } else {
            return 0;
        }
    }
}
