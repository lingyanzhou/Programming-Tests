package lzhou.programmingtest.leetcode.test354;

import java.util.*;

import java.util.stream.*;

/**
 * Naive O(n^2) solution
 */
public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                int ret = -Integer.compare(e1[0], e2[0]);
                if (ret==0) {
                    ret = -Integer.compare(e1[1], e2[1]);
                }
                return ret;
            }
        });
        int n = envelopes.length;
        int[] lengths = new int[n];
        int[] prev = new int[n];
        
        for (int i=0; i<n; ++i) {
            prev[i] = -1;
            lengths[i] = 1;
            for (int j=0; j<i; ++j) {
                if (envelopes[j][0]>envelopes[i][0] && envelopes[j][1]>envelopes[i][1]) {
                    if (lengths[i]<lengths[j]+1) {
                        lengths[i]=lengths[j]+1;
                        prev[i] = j;
                    }
                }
            }
        }
        
        
        int ret = 0;
        for (int i=0; i<n; ++i) {
            ret = Math.max(lengths[i], ret);
        }
        
        return ret;
    }
}
