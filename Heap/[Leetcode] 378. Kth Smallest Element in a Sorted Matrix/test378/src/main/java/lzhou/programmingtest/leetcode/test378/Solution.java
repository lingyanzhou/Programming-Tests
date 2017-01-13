package lzhou.programmingtest.leetcode.test378;

import java.util.*;

/*
 * Solution 1: Heap
 * First put the first row or column in a heap.
 * Pop the cell with the smallest value.
 * Move the cell rightward or downward and add the cell into the heap
 * Repeat k times.
 *
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<IndexValue> heap = new PriorityQueue<IndexValue> ();
        
        for (int i=0; i<matrix.length; ++i) {
            heap.offer(new IndexValue(i, 0, matrix[i][0]));
        }
        
        while (k!=1) {
            IndexValue i = heap.poll();
            if (i.y+1<matrix[i.x].length) {
                heap.offer(new IndexValue(i.x, i.y+1, matrix[i.x][i.y+1]));
            }
            k-=1;
        }
        return heap.poll().val;
    }
    
    static class IndexValue implements Comparable<IndexValue>{
        int x, y, val;
        public IndexValue(int _x, int _y, int _val) {
            x=_x;
            y=_y;
            val=_val;
        }
        public int compareTo(IndexValue o) {
            return Integer.compare(val, o.val);
        }
    } 
}
