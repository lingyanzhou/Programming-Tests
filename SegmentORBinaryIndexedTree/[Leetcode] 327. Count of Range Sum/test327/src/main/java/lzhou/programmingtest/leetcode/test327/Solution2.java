package lzhou.programmingtest.leetcode.test327;

import java.util.*;

/**
 * Segment Tree solution
 *    1. Calculate the integral array. Sort the integral array.
 *    2. Create a segment tree, with leaves corresponding to entries in the integral array. Their count is set to 0.
 *    3. Calculate the integral array again. At each step, find in the segmentation tree how many previous sums are between `sum-upper` and `sum-lower` . Then add `sum` to the tree.
 */
public class Solution2 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> tree = new TreeMap<Long, Integer>();
        tree.put(0L, 1);
        long[] sumArray = new long[nums.length+1];
        
        for (int i=0; i<nums.length; ++i) {
            sumArray[i+1]=sumArray[i]+nums[i];
        }

        Arrays.sort(sumArray);
        int ret = 0;
        //System.out.println(Arrays.toString(sumArray));
        SegTreeNode root = new SegTreeNode(sumArray, 0, sumArray.length);
        root.add(0);
        long sum=0;
        for (int n:nums) {
            sum += n;
            int tmp = root.query(sum-upper, sum-lower);
            //System.out.println("root.query("+(sum-upper)+", "+(sum-lower)+")->"+tmp);
            ret += tmp;
            root.add(sum);
        }
        
        return ret;
    }
}

class SegTreeNode {
    long left;
    long right;
    long mid;
    int count;
    SegTreeNode leftNode;
    SegTreeNode rightNode;
    
    public SegTreeNode(long[] arr, int start, int end) {
        left = arr[start];
        right = arr[end-1];
        mid = arr[(start+end-1)/2];
        count = 0;
        leftNode=null;
        rightNode=null;
        if (start==end-1) {
            return;
        }
        leftNode = new SegTreeNode(arr, start, (start+end+1)/2);
        rightNode = new SegTreeNode(arr, (start+end+1)/2, end);
    }
    
    public int query(long qleft, long qright) {
        //System.out.println("===\nleft="+left+", right="+right+", mid="+mid);
        if (qleft>qright || qleft>right || qright<left) {
            //System.out.println("1. qleft="+qleft+", qright="+qright);
            return 0;
        }
        if (qleft<=left && qright>=right) {
            //System.out.println("2. qleft="+qleft+", qright="+qright);
            return count;
        }
        if (qleft>mid) {
            //System.out.println("3. qleft="+qleft+", qright="+qright);
            return rightNode.query(qleft, qright);
        }
        if (qright<=mid) {
            //System.out.println("4. qleft="+qleft+", qright="+qright);
            return leftNode.query(qleft, qright);
        }
        //System.out.println("5. qleft="+qleft+", qright="+qright);
        return leftNode.query(qleft, mid)+rightNode.query(mid+1, qright);
    }
    
    public void add(long val) {
        if (val>right || val<left) {
            return;
        }
        count+=1;
        if (left==right && left==val) {
            return;
        }
        if (val<=mid) {
            leftNode.add(val);
        }
        
        if (val>mid) {
            rightNode.add(val);
        }
    }
}
