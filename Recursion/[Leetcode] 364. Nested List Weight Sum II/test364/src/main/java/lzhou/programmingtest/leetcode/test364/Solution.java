package lzhou.programmingtest.leetcode.test364;

import java.util.*;

public class Solution 
{
    public int depthSumInverse(NestedInteger nestedInteger) {
        int depth = getDepth(nestedInteger);
        return depthSumInverseHelper(nestedInteger, 0, depth);
    }

    private int depthSumInverseHelper(NestedInteger nestedInteger, int level, int depth) {
        assert nestedInteger!=null;
        
        if (nestedInteger.isInteger()) {
            return (depth-level)*nestedInteger.getInteger();
        } else {
            int result = 0;
            for (NestedInteger ni: nestedInteger.getList()) {
                result += depthSumInverseHelper(ni, level+1, depth);
            }
            return result;
        }
    }

    private int getDepth(NestedInteger nestedInteger) {
        assert nestedInteger!=null;
        
        if (nestedInteger.isInteger()) {
            return 1;
        } else {
            int result = 2;
            for (NestedInteger ni: nestedInteger.getList()) {
                result = Math.max(result, 1+getDepth(ni));
            }
            return result;
        }
    }
}
