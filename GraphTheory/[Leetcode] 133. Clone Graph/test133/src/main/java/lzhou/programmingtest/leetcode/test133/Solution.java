package lzhou.programmingtest.leetcode.test133;

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node==null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> created = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> copies = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> toCopy = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        created.put(root.label, root);
        copies.offer(root);
        toCopy.offer(node);
        
        while (copies.size()>0) {
            UndirectedGraphNode cp = copies.poll();
            UndirectedGraphNode tcp = toCopy.poll();
            
            for (UndirectedGraphNode tcpc: tcp.neighbors) {
                UndirectedGraphNode cpc = created.get(tcpc.label);
                if (cpc==null) {
                    cpc = new UndirectedGraphNode(tcpc.label);
                    created.put(cpc.label, cpc);
                    copies.offer(cpc);
                    toCopy.offer(tcpc);
                }
                cp.neighbors.add(cpc);
            }
        }
        
        return root;
    }
}
