package lzhou.programmingtest.leetcode.test364;

import java.util.*;

public class NestedIntegerImpl implements NestedInteger {
    private Integer val = null;
    private List<NestedInteger> list = null;
    
    public NestedIntegerImpl(Integer val) {
        this.val = val;
    }
    
    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
    }
    
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    @Override
    public boolean isInteger() {
        return val!=null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    @Override
    public Integer getInteger() {
        return val;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
