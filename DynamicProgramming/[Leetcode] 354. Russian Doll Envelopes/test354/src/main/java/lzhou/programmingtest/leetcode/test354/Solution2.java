package lzhou.programmingtest.leetcode.test354;

import java.util.*;

import java.util.stream.*;

/**
 * Binary search solution
 * 
 * Time O(n log n) 
 */
public class Solution2 {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                int ret = -Integer.compare(e1[0], e2[0]);
                if (ret==0) {
                    ret = Integer.compare(e1[1], e2[1]);
                }
                return ret;
            }
        });
        Integer[] widthsAt = new Integer[n];
        int mostNested = 0;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) {
                return Integer.compare(v2, v1);
            }
        };

        for (int[] env: envelopes) {
            int atNested = Arrays.binarySearch(widthsAt, 0, mostNested, env[1], comparator);
            if (atNested<0) {
                atNested = -atNested-1;
                if (atNested==mostNested) {
                    widthsAt[mostNested] = env[1];
                    mostNested+=1;
                } else {
                    if (widthsAt[atNested]<env[1]) {
                        widthsAt[atNested]=env[1];
                    }
                }
            }
            //System.out.println(Arrays.toString(Arrays.copyOf(widthsAt, mostNested)));
        }
        
        return mostNested;
    }
}
