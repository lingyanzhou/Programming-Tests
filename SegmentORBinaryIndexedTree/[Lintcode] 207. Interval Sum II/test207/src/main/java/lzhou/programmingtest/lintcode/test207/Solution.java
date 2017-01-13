package lzhou.programmingtest.lintcode.test207;

import java.util.*;

public class Solution {
    /* you may need to use some attributes here */
    SegmentTreeNode root;

    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // write your code here
        root = new SegmentTreeNode(A, 0, A.length-1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return root.query(start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        root.modify(index, value);
    }
}

class SegmentTreeNode {
    int first;
    int last;
    int mid;
    long sum;
    SegmentTreeNode left;
    SegmentTreeNode right;
    
    public SegmentTreeNode(int[] A, int first, int last) {
        this.first = first;
        this.last = last;
        left = null;
        right = null;
        mid = (int)(((long)first+last)/2);
        sum = 0;
        if (first>last) {
            return;
        }
        for (int i=first; i<=last; ++i) {
            sum+= A[i];
        }
        if (first==last) {
            return;
        }
        left = new SegmentTreeNode(A, first, mid);
        right = new SegmentTreeNode(A, mid+1, last);
    }
    
    public long query(int start, int end) {
        if (start==first && end==last) {
            return sum;
        }
        if (start>last || end<first) {
            return 0;
        }
        if (end<=mid) {
            return left.query(start, end);
        }
        if (start>mid) {
            return right.query(start, end);
        }
        return left.query(start, mid)+right.query(mid+1, end);
    }
    
    public void modify(int index, int value) {
        if (index==first && index==last) {
            sum = value;
            return;
        }
        if (index>last || index<first) {
            return;
        }
        if (index<=mid) {
            left.modify(index, value);
        }
        if (index>mid) {
            right.modify(index, value);
        }
        sum =left.sum+right.sum;
    }
}
