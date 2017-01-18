package lzhou.programmingtest.lintcode.test127;

import java.util.*;

/**
 * DFS solution
 *   1. Select a random not-visited node
 *   2. DFS a node with no neighbors. Push intermediate nodes into a stack. Add the node to the result. Pop the stack. Repeat util the stack is empty.
 *   3. Repeat 1,2 util all nodes are added.
 */

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<Integer, DirectedGraphNode> nodes = new HashMap<Integer, DirectedGraphNode>();
        Set<Integer> visited = new HashSet<Integer>();
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        
        for (DirectedGraphNode n : graph) {
            nodes.put(n.label, n);
        }
        
        while (result.size()<graph.size()) {
            for (Integer i: nodes.keySet()) {
                if (!visited.contains(i)) {
                    stack.push(nodes.get(i));
                    visited.add(i);
                    break;
                }
            }
            while (stack.size()>0) {
                DirectedGraphNode cur = stack.peek();
                DirectedGraphNode child = null;
                for (DirectedGraphNode nhb: cur.neighbors) {
                    if (!visited.contains(nhb.label)) {
                        child = nhb;
                        break;
                    }
                }
                if (child==null) {
                    result.add(0, cur);
                    stack.pop();
                } else {
                    stack.push(child);
                    visited.add(child.label);
                }
            }
        }
        return result;
    }
}
