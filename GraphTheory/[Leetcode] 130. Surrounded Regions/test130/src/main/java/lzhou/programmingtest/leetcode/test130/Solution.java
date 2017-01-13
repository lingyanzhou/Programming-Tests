package lzhou.programmingtest.leetcode.test130;

import java.util.*;

/*
 * DFS/BFS solution
 *   1. Fill in boundary 'O's and connected 'O's with 'B'
 *   2. Fill in all other 'O's with 'X'
 *   3. Fill in boundary 'B's with 'O'
 */

public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board.length==0 || board[0].length==0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i=0; i<m; ++i) {
            if (board[0][i]=='O') {
                fill(board, 0, i, 'B');
            }
        }
        for (int i=0; i<m; ++i) {
            if (board[n-1][i]=='O') {
                fill(board, n-1, i, 'B');
            }
        }
        for (int i=0; i<n; ++i) {
            if (board[i][0]=='O') {
                fill(board, i, 0, 'B');
            }
        }
        for (int i=0; i<n; ++i) {
            if (board[i][m-1]=='O') {
                fill(board, i, m-1, 'B');
            }
        }
        
        for (int i=1; i<n-1; ++i) {
            for (int j=1; j<m-1; ++j) {
                if (board[i][j]=='O') {
                    fill(board, i, j, 'X');
                }
            }
        }
        
        for (int i=0; i<m; ++i) {
            if (board[0][i]=='B') {
                fill(board, 0, i, 'O');
            }
        }
        for (int i=0; i<m; ++i) {
            if (board[n-1][i]=='B') {
                fill(board, n-1, i, 'O');
            }
        }
        for (int i=0; i<n; ++i) {
            if (board[i][0]=='B') {
                fill(board, i, 0, 'O');
            }
        }
        for (int i=0; i<n; ++i) {
            if (board[i][m-1]=='B') {
                fill(board, i, m-1, 'O');
            }
        }
    }
    
    private void fill(char[][] board, int i, int j, char c) {
        Queue<Point> queue = new LinkedList<Point>();
        char toReplaceChar = board[i][j];
        queue.offer(new Point(i, j));
        board[i][j] = c;
        while (queue.size()>0) {
            Point p = queue.poll();
            if (p.i>0) {
                if (board[p.i-1][p.j]==toReplaceChar) {
                    board[p.i-1][p.j]=c;
                    queue.offer(new Point(p.i-1, p.j));
                }
            }
            
            if (p.i<board.length-1) {
                if (board[p.i+1][p.j]==toReplaceChar) {
                    board[p.i+1][p.j]=c;
                    queue.offer(new Point(p.i+1, p.j));
                }
            }
            
            if (p.j>0) {
                if (board[p.i][p.j-1]==toReplaceChar) {
                    board[p.i][p.j-1]=c;
                    queue.offer(new Point(p.i, p.j-1));
                }
            }
            
            if (p.j<board[0].length-1) {
                if (board[p.i][p.j+1]==toReplaceChar) {
                    board[p.i][p.j+1]=c;
                    queue.offer(new Point(p.i, p.j+1));
                }
            }
        }
    }
}

class Point {
    int i;
    int j;
    
    public Point(int _i, int _j) {
        i = _i;
        j = _j;
    }
}
