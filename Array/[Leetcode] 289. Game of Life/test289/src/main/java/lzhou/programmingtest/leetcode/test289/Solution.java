package lzhou.programmingtest.leetcode.test289;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public void gameOfLife(int[][] board) {
        int n = board.length;
        if (n==0) {
            return;
        }
        int m = board[0].length;
        if (m==0) {
            return;
        }
        int[][] sum = new int[n+1][m+1];
        for (int i=0; i<n; ++i) {
            int local3x3Sum = 0;
            for (int l=Math.max(0, i-1); l<=Math.min(n-1, i+1); ++l) {
                local3x3Sum+=(board[l][0]&0x1);
            }
            for (int j=0; j<m; ++j) {
                if (j-2>=0) {
                    for (int l=Math.max(0, i-1); l<=Math.min(n-1, i+1); ++l) {
                        local3x3Sum-=(board[l][j-2]&0x1);
                    }
                }
                if (j+1<m) {
                    for (int l=Math.max(0, i-1); l<=Math.min(n-1, i+1); ++l) {
                        local3x3Sum+=(board[l][j+1]&0x1);
                    }
                }
                int surrounded = local3x3Sum-(board[i][j]&0x1);
                if ((board[i][j]&0x1)==1) {
                    if (surrounded==2 || surrounded==3) {
                        board[i][j] |= 0x2;
                    }
                } else {
                    if (surrounded==3) {
                        board[i][j] |= 0x2;
                    }
                }
            }
        }

        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }
}
