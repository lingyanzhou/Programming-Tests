package lzhou.programmingtest.leetcode.test582;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, ProcTree> joined = new HashMap<Integer, ProcTree>();
        for (int i=0; i<pid.size(); ++i) {
            joined.put(pid.get(i), new ProcTree(pid.get(i)));
        }
        
        for (int i=0; i<pid.size(); ++i) {
            if (ppid.get(i)!=0) {
                joined.get(pid.get(i)).setParent(joined.get(ppid.get(i)));
            }
        }
        
        return joined.get(kill).getAllChildrenValues();
    }
}

class ProcTree {
    Integer value = 0;
    List<ProcTree> children = new ArrayList<ProcTree>();
    
    ProcTree(Integer val) {
        value = val;
    }
    
    void addChild(ProcTree child) {
        children.add(child);
    }
    
    void setParent(ProcTree parent) {
        parent.addChild(this);
    }
    
    List<Integer> getAllChildrenValues() {
         List<Integer> result = new ArrayList<Integer>();
         result.add(value);
         for (ProcTree c: children) {
             result.addAll(c.getAllChildrenValues());
         }
         return result;
    }
}
