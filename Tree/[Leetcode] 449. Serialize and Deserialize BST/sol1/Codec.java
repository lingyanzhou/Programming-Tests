import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) {
            return "";
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int level = 0;
        while (true) {
            boolean levelHasNode = false;
            int start = (int)Math.pow(2, level)-1;
            int end = (int)Math.pow(2, level+1)-1;
            for (int i=start; i<end; ++i) {
                if (list.get(i)==null) {
                    list.add(null);
                    list.add(null);
                } else {
                    levelHasNode = true;
                    list.add(list.get(i).left);
                    list.add(list.get(i).right);
                }
            }
            if (!levelHasNode) {
                break;
            }
            level+=1;
        }
        
        
        //Remove trailing null
        while (list.get(list.size()-1)==null) {
            list.remove(list.size()-1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); ++i) {
            if (list.get(i)!=null) {
                sb.append(list.get(i).val);
            }
            if (i!=list.size()-1) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] splittedData =data.split(",");
        assert !splittedData[0].equals("");
        TreeNode[] nodes = new TreeNode[splittedData.length];
        nodes[0] = new TreeNode(Integer.parseInt(splittedData[0]));
        
        for (int i=1; i<splittedData.length; ++i) {
            if (!splittedData[i].equals("")) {
                nodes[i] = new TreeNode(Integer.parseInt(splittedData[i]));
                assert nodes[(i+1)/2-1]!=null;
                if (i%2==1) {
                    nodes[(i+1)/2-1].left=nodes[i];
                } else {
                    nodes[(i+1)/2-1].right=nodes[i];
                }
            }
        }
        return nodes[0];
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
