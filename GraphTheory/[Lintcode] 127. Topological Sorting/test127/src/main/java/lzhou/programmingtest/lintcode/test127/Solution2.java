package lzhou.programmingtest.lintcode.test127;

import java.util.*;

/**
 * BFS solution
 *   1. Find all nodes with no inbound links
 *   2. Add them to the result
 *   3. Decrement inbound link counts of all their neihbors
 *   4. Continue 1-3 util all nodes are added.
 */

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution2 {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<Integer, DirectedGraphNode> nodes = new HashMap<Integer, DirectedGraphNode>();
        Map<Integer,Integer> indegrees = new HashMap<Integer,Integer>();
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        
        for (DirectedGraphNode n : graph) {
            nodes.put(n.label, n);
            indegrees.put(n.label, 0);
        }
        
        for (DirectedGraphNode n : graph) {
            for (DirectedGraphNode m: n.neighbors) {
                int count = indegrees.get(m.label)+1;
                indegrees.put(m.label, count);
            }
        }
        
        while (result.size()<graph.size()) {
            for (Map.Entry<Integer, Integer> e: indegrees.entrySet()) {
                if (e.getValue()==0) {
                    e.setValue(-1);
                    DirectedGraphNode n = nodes.get(e.getKey());
                    result.add(n);
                    
                    for (DirectedGraphNode m: n.neighbors) {
                        indegrees.put(m.label, indegrees.get(m.label)-1);
                    }
                }
            }
        }
        return result;
    }
}
