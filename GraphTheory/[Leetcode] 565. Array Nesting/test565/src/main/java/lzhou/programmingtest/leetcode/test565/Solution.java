package lzhou.programmingtest.leetcode.test565;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public int arrayNesting(int[] nums) {
        UnionJoin[] unions = new UnionJoin[nums.length];
    
        for (int i=0; i<nums.length; ++i) {
            if (unions[i] == null) {
                unions[i] = new UnionJoin(i, 1);
            }
            if (unions[nums[i]] == null) {
                unions[nums[i]] = unions[i];
                unions[i].getRoot().size += 1;
            } else {
                unions[i].union(unions[nums[i]]);
            }
        }
        int max = 0;
        for (int i=0; i<nums.length; ++i) {
            max = Math.max(max, unions[i].getRoot().size);
        }
        
        return max;
    }
}

class UnionJoin {
    int start = 0;
    int size = 0;
    UnionJoin parent = null;
    UnionJoin(int start, int size) {
        this.start = start;
        this.size = size;
        parent = this;
    }
    
    UnionJoin getRoot() {
        if (parent == this) {
            return this;
        } else {
            parent = parent.getRoot();
            return parent;
        }
    }

    int getSize() {
        return getRoot().size;
    }
    
    void union(UnionJoin other) {
        if (getRoot()==other.getRoot()) {
            return;
        }
        if (getRoot().start < other.getRoot().start) {
            getRoot().size += other.getRoot().size;
            other.getRoot().parent = getRoot();
        } else {
            other.getRoot().size += getRoot().size;
            getRoot().parent = other.getRoot();
        }
    }
}
