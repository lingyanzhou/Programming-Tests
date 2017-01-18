package lzhou.programmingtest.leetcode.test297;

import java.util.*;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Codec {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root==null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode lineEnd = new TreeNode(0);
        queue.offer(root);
        queue.offer(lineEnd);
        
        StringBuilder sb = new StringBuilder();
        int curLevelNodeCount = 1;
        int nextLevelNodeCount = 0;
        while (queue.size()>0) {
            TreeNode n = queue.poll();
            if (n==lineEnd) {
                queue.offer(lineEnd);
                curLevelNodeCount = nextLevelNodeCount;
                nextLevelNodeCount = 0;
            } else if (n==null) {
                sb.append("#,");
            } else {
                sb.append(n.val);
                sb.append(',');
                if (n.left!=null) {
                    queue.offer(n.left);
                    nextLevelNodeCount+=1;
                } else {
                    queue.offer(null);
                }
                if (n.right!=null) {
                    queue.offer(n.right);
                    nextLevelNodeCount+=1;
                } else {
                    queue.offer(null);
                }
                curLevelNodeCount-=1;
                if (0==curLevelNodeCount && 0==nextLevelNodeCount) {
                    break;
                }
            }
        }
        String ret = sb.toString();
        return ret;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        char prevc = ',';
        int val = 0;
        int sign = 1;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer> states = new LinkedList<Integer>();
        TreeNode fake = new TreeNode(0);
        nodes.offer(fake);
        states.offer(2);
        
        for (int i=0; i<data.length(); ++i) {
            char c = data.charAt(i);
            if (c=='-') {
                sign=-1;
            } else if (c==',' && prevc=='#') {
                int state = states.poll();
                if (state==1) {
                    nodes.peek().left = null;
                } else {
                    nodes.poll().right = null;
                }
                val=0;
                sign=1;
            } else if (c==',' && prevc!='#') {
                TreeNode nc = new TreeNode(sign*val);
                nodes.offer(nc);
                states.offer(1);
                states.offer(2);
                
                int state = states.poll();
                if (state==1) {
                    nodes.peek().left = nc;
                } else {
                    nodes.poll().right = nc;
                }
                val=0;
                sign=1;
            } else if (Character.isDigit(c)) {
                val = 10*val+Character.digit(c, 10);
            }
            prevc=c;
        }
        return fake.right;
    }
}
