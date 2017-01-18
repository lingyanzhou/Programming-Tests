package lzhou.programmingtest.leetcode.test128;

import java.util.*;

/**
 * Union find solution
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, UnionFindNode> sets = new  HashMap<Integer, UnionFindNode>(nums.length);
        for (int i:nums) {
            if (!sets.containsKey(i)) {
                sets.put(i, new UnionFindNode(i));
            }
        }
        int maxSize = 0;
        for (int i:nums) {
            if (sets.containsKey(i+1)) {
                UnionFindNode r = sets.get(i).union(sets.get(i+1));
                sets.put(i, r);
            }
        }
        
        for (int i:nums) {
            maxSize = Math.max(maxSize, sets.get(i).getSize());
        }
        return maxSize;
    }
}

class UnionFindNode {
    UnionFindNode parent;
    int size;
    int label;
    public UnionFindNode(int l) {
        size =1;
        label = l;
        parent = this;
    }
    
    public int getSize() {
        return getRoot().size;
    }
    
    public UnionFindNode union(UnionFindNode n) {
        UnionFindNode r1 = getRoot();
        UnionFindNode r2 = n.getRoot();
        if (r1==r2) {
            return r1;
        }
        r1.parent = r2;
        r2.size+=r1.size;
        compress();
        return parent;
    }
    
    public UnionFindNode getRoot() {
        compress();
        return parent;
    }
    
    public void compress() {
        if (parent==this) {
            return;
        }
        this.parent.compress();
        this.parent = this.parent.parent;
    }
}
