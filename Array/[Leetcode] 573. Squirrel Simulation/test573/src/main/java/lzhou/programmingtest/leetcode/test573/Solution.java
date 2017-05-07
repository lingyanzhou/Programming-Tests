package lzhou.programmingtest.leetcode.test573;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int[] nuts2Tree = Arrays.stream(nuts).mapToInt(n->distance(n, tree)).toArray();
        int[] squirrel2Nuts = Arrays.stream(nuts).mapToInt(n->distance(n, squirrel)).toArray();
        
        int nuts2TreeSum = Arrays.stream(nuts2Tree).sum();
        return IntStream.range(0, nuts.length).map(i->2*nuts2TreeSum+squirrel2Nuts[i]-nuts2Tree[i]).min().orElse(0);
    }
    
    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }
}
