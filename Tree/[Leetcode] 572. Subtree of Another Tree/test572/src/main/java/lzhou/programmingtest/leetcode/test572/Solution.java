package lzhou.programmingtest.leetcode.test572;
 
import java.util.*;

import java.util.stream.*;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null || t==null) {
            if (s==null && t==null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (s.val==t.val) {
                return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        }
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s==null || t==null) {
            if (s==null && t==null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (s.val==t.val) {
                return isSame(s.left, t.left) &&
                    isSame(s.right, t.right);
            } else {
                return false;
            }
        }
    }
}
