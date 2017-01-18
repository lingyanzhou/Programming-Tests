package lzhou.algorithm.graph.topologicalsort.tarjanalgo;

import java.util.*;

public class TarjanAlgo {
    //Tarjan's algorithm
    public int[] findOrder(int numNodes, int[][] links) {
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>(numNodes);
        for (int i=0; i<numNodes; ++i) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        for (int[] link: links) {
            adjacencyList.get(link[0]).add(link[1]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        Deque<Integer> sorted = new ArrayDeque<Integer>();
        Set<Integer> inStack = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        while (visited.size()<numNodes) {
            int cur = -1;
            for (int i=0; i<numNodes; ++i) {
                if (!visited.contains(i)) {
                    cur = i;
                    break;
                }
            }
            stack.push(cur);
            inStack.add(cur);
            
            while (!stack.isEmpty()) {
                int i = stack.peek();
                int child = -1;
                for (int c: adjacencyList.get(i)) {
                    if (inStack.contains(c)) {
                        return new int[0];
                    }
                    if (!visited.contains(c)) {
                        child = c;
                        break;
                    }
                }
                if (child == -1) {
                    stack.pop();
                    inStack.remove(i);
                    visited.add(i);
                    sorted.push(i);
                } else {
                    stack.push(child);
                    inStack.add(child);
                }
            }
        }
        
        int[] ret = new int[numNodes];
        
        int index = 0;
        for (int i: sorted) {
            ret[index] = i;
            index+=1;
        }
        return ret;
    }
}
