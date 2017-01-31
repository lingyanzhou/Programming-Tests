package lzhou.programmingtest.leetcode.test351;

import java.util.*;

/**
 * #DFS solution
 *
 * 1. Define `dfs(start, m, n)` as the number of patterns with min/max length of `m`/`n` starting from `start`
 * 2. Because of symmetry, `numberOfPatterns(m, n)=4*dfs(0, m, n)+4*dfs(1, m, n)+dfs(4, m, n)`
 * 3. When in DFS, try each key if the key is not the current key, if the key is not used, and if there is a key in between that is not used.
 */
public class Solution 
{
    public int numberOfPatterns(int m, int n) {
        int[] stack = new int[9];
        boolean[] table = new boolean[9];

        int ret = 4 * dfsNumberOfPatternsHelper(m, n, 0, stack, 0, table);
        ret += 4 * dfsNumberOfPatternsHelper(m, n, 1, stack, 0, table);
        ret += dfsNumberOfPatternsHelper(m, n, 4, stack, 0, table);
        
        return ret;
    }

    public int dfsNumberOfPatternsHelper(int m, int n, int start, int[] stack, int stackLen, boolean[] table) {
        if (stackLen>=n) {
            return 0;
        }
        if (table[start]) {
            return 0;
        }
        table[start] = true;
        stack[stackLen]=start;

        int ret = 0;
        if (stackLen+1>=m) {
            ret+=1;
        }
        for (int i=0; i<9; ++i) {
            if (table[i]) {
                continue;
            }
            if ((start+i)%2==0 && Math.abs(start%3-i%3)!=1 && !table[(start+i)/2]) {
                continue;
            }
            ret += dfsNumberOfPatternsHelper(m, n, i, stack, stackLen+1, table);
        }
        table[start] = false;
        
        return ret;
    }
}
