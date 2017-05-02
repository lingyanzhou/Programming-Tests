package lzhou.programmingtest.leetcode.test533;

import java.util.*;

public class Solution 
{
    static class CharArray {
        char[] data;
        CharArray(char[] data) {
            this.data = data;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof CharArray ) {
                CharArray other = (CharArray) o;
                return Arrays.equals(data, other.data);
            } else {
                return false;
            }
        }
        
        @Override
        public int hashCode() {
            return Arrays.hashCode(data);
        }
    }
    
    public int findBlackPixel(char[][] board, int n) {
        try {
            int r = board.length;
            int c = board[0].length;
            int[] rowBCount = new int[r];
            int[] colBCount = new int[c];
            for (int i=0; i<r; ++i) {
                for (int j=0; j<c; ++j) {
                    if (board[i][j]=='B') {
                        rowBCount[i]+=1;
                        colBCount[j]+=1;
                    }
                }
            }
            
            Map<CharArray,Integer> map = new HashMap<CharArray,Integer>();
            
            for (int i=0; i<r; ++i) {
                CharArray tmp = new CharArray(board[i]);
                map.put(tmp, map.getOrDefault(tmp, 0)+1);
            }
            int result = 0;
            for (int i=0; i<r; ++i) {
                CharArray tmp = new CharArray(board[i]);
                if (map.get(tmp)!=n) {
                    continue;
                }
                for (int j=0; j<c; ++j) {
                    if (board[i][j]=='B' && rowBCount[i]==n && colBCount[j]==n) {
                        result+=n;
                        map.put(tmp, -1);
                    } else {
                    }
                }
            }
            return result;
        } catch (Exception e) {
            return 0;
        }
    }
}
