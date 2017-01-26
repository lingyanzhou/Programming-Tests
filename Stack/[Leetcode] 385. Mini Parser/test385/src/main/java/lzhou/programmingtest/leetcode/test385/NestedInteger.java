package lzhou.programmingtest.leetcode.test385;

import java.util.*;

public class NestedInteger {
    Integer single;
    List<NestedInteger> list;
    
    // Constructor initializes an empty nested list.
    public NestedInteger() {
        single=null;
        list = new ArrayList<NestedInteger>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        single = value;
        list = null;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return single!=null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return single;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        single = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (list!=null) {
            list.add(ni);
        }
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }
}
