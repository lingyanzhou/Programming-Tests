package lzhou.programmingtest.lintcode.test249;

import java.util.*;

public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        //1
        List<Integer> ret = new ArrayList<Integer>();
        List<Integer> Alist = new ArrayList<Integer>();
        for (int a:A) {
            Alist.add(a);
        }
        int min = arrayMin(Alist);
        int max = Math.max(min, arrayMax(Alist));
        SegmentTreeNode root = new SegmentTreeNode(Alist, min, max);
        for (int q:queries) {
            ret.add(root.querySmallerCount(q));
        }
        
        return ret;
    }
    
    
    private static int arrayMin(List<Integer> A) {
        int min = Integer.MAX_VALUE;
        for (int a: A) {
            min = Math.min(min, a);
        }
        return min;
    }
    
    private static int arrayMax(List<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (int a: A) {
            max = Math.max(max, a);
        }
        return max;
    }
    
}

class SegmentTreeNode {
    int start;
    int end;
    int count;
    SegmentTreeNode left;
    SegmentTreeNode right;
    
    public SegmentTreeNode(List<Integer> A, int min, int max) {
        start = min;
        end = max;
        count = A.size();
        left = null;
        right = null;
        
        if (start==end) {
            return;
        }
        
        int mid = (int)Math.floor(((double)start+end)/2.0);
        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();
        for (int i: A) {
            if (i<=mid) {
                leftList.add(i);
            } else {
                rightList.add(i);
            }
        }
        left = new SegmentTreeNode(leftList, start, mid);
        right = new SegmentTreeNode(rightList, mid+1, end);
    }
    
    public int querySmallerCount(int i) {
        int mid = (int)(((long)start+end)/2);
        if (i>end) {
            return count;
        } else if (i<=start) {
            return 0;
        } else if (i<=mid) {
            if (left!=null) {
                return left.querySmallerCount(i);
            } else {
                return 0;
            }
        } else {
            int ret = 0;
            if (left!=null) {
                ret+= left.querySmallerCount(i);
            }
            if (right!=null) {
                ret+= right.querySmallerCount(i);
            }
            return ret;
        }
    }
}
