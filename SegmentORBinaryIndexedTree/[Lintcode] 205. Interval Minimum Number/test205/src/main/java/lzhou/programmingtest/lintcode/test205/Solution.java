package lzhou.programmingtest.lintcode.test205;

import java.util.*;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public List<Integer> intervalMinNumber(int[] A, 
                                                List<Interval> queries) {
        // write your code here
        
        SegmentTreeNode root = new SegmentTreeNode(A, 0, A.length-1);
        List<Integer> ret =new ArrayList<Integer>(queries.size());
        
        for (Interval i:queries) {
            ret.add(root.query(i.start, i.end));
        }
        
        return ret;
    }
}

class SegmentTreeNode {
    public int start;
    public int end;
    public int min;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public SegmentTreeNode(int[] A, int _start, int _end) {
        start = _start;
        end = _end;
        left= null;
        right = null;
        if (start==end) {
            min=A[start];
            return;
        }
        int mid = (start+end)/2;
        left= new SegmentTreeNode(A, start, mid);
        right= new SegmentTreeNode(A, mid+1, end);
        min = Math.min(left.min, right.min);
    }
    
    public int query(int _start, int _end) {
        if (_start==start && end==_end) {
            return min;
        }
        int mid = (start+end)/2;
        if (_start>mid) {
            return right.query(_start, _end);
        }
        if (_end<=mid) {
            return left.query(_start, _end);
        }
        return Math.min(left.query(_start, mid), right.query(mid+1, _end));
    }
}
