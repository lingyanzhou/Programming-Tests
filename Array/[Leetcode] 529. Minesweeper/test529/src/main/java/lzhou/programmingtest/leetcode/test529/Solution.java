package lzhou.programmingtest.leetcode.test529;

import java.util.*;

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click[0]<0 || click[0]>=board.length
           || click[1]<0 || click[1]>=board[click[0]].length) {
            return board;       
        }
        if (board[click[0]][click[1]]=='M') {
            board[click[0]][click[1]]='X';
            return board;
        } else if (board[click[0]][click[1]]=='E'){
            int adjMines = countAdjMines(board, click);
            if (adjMines>0) {
                board[click[0]][click[1]]=(char)('0'+adjMines);
            } else {
                board[click[0]][click[1]]='B';
                board = updateBoard(board, new int[]{click[0]-1, click[1]});
                board = updateBoard(board, new int[]{click[0]+1, click[1]});
                board = updateBoard(board, new int[]{click[0], click[1]-1});
                board = updateBoard(board, new int[]{click[0], click[1]+1});
                board = updateBoard(board, new int[]{click[0]-1, click[1]-1});
                board = updateBoard(board, new int[]{click[0]-1, click[1]+1});
                board = updateBoard(board, new int[]{click[0]+1, click[1]-1});
                board = updateBoard(board, new int[]{click[0]+1, click[1]+1});
            }
            return board;
        } else {
            // board[click[0]][click[1]]=='B' 
            return board;
        }
    }
    
    private int countAdjMines(char[][] board, int[] click) {
        int ret = 0;
        if (click[0]>0) {
            if (board[click[0]-1][click[1]]=='M') {
                ret+=1;
            }
            if (click[1]>0) {
                if (board[click[0]-1][click[1]-1]=='M') {
                    ret+=1;
                }
            }
            if (click[1]<board[click[0]-1].length-1) {
                if (board[click[0]-1][click[1]+1]=='M') {
                    ret+=1;
                }
            }
        }
        if (click[1]>0) {
            if (board[click[0]][click[1]-1]=='M') {
                ret+=1;
            }
        }
        if (click[1]<board[click[0]].length-1) {
            if (board[click[0]][click[1]+1]=='M') {
                ret+=1;
            }
        }
        if (click[0]<board.length-1) {
            if (board[click[0]+1][click[1]]=='M') {
                ret+=1;
            }
            if (click[1]>0) {
                if (board[click[0]+1][click[1]-1]=='M') {
                    ret+=1;
                }
            }
            if (click[1]<board[click[0]+1].length-1) {
                if (board[click[0]+1][click[1]+1]=='M') {
                    ret+=1;
                }
            }
        }
        return ret;
    }
}
