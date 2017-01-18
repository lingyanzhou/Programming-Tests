package lzhou.programmingtest.leetcode.test315;

import java.util.*;

/**
 * Segment Tree solution
 *
 *   1. Segment tree contains  counts in its start-end range
 *   2. Find max and min of the array; build the segment tree with 0 counts.
 *   3. Read the array from right to left, adding values to the segment tree and query the counts as we go.
 */
public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    public List<Integer> countSmaller(int[] A) {
        // write your code here
        List<Integer> ret = new ArrayList<Integer>();
        if (A.length==0) {
            return ret;
        }
        int min = A[0];
        int max = A[0];
        for (int i: A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        SegTreeNode root = new SegTreeNode(min, max);
        
        for (int i=A.length-1; i>=0; --i) {
            root.add(A[i]);
            ret.add(0, root.query(A[i]));
        }
        
        return ret;
    }
    
}

class SegTreeNode {
    int start;
    int end;
    int mid;
    SegTreeNode left;
    SegTreeNode right;
    int count;
    
    public SegTreeNode(int s, int e) {
        start = s;
        end = e;
        mid = (int)Math.floor(((double)s+e)/2);
        left = null;
        right = null;
        count = 0;
        
        if (s==e) {
            return;
        }
        left = new SegTreeNode(s, mid);
        right = new SegTreeNode(mid+1, e);
    }
    
    public void add(int val) {
        if (val>end || val<start) {
            return;
        }
        count += 1;
        if (start==end) {
            return;
        }
        if (val<=mid) {
            left.add(val);
        } else {
            right.add(val);
        }
    }
    
    public int query(int val) {
        if (val>end) {
            return count;
        }
        if (val<=start) {
            return 0;
        }
        if (val>mid) {
            return left.count + right.query(val);
        }
        return left.query(val);
    }
}
