package lzhou.algorithm.graph.topologicalsort.kahnalgo;

import java.util.*;

public class KahnAlgo {
    //Tarjan's algorithm
    public int[] findOrder(int numNodes, int[][] links) {
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>(numNodes);
        int[] indegrees = new int[numNodes];
        for (int i=0; i<numNodes; ++i) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        for (int[] link: links) {
            adjacencyList.get(link[0]).add(link[1]);
            indegrees[link[1]] +=1;
        }

        Queue<Integer> sorted = new LinkedList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i=0; i<numNodes; ++i) {
            if (indegrees[i]==0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sorted.offer(cur);
            for (int c: adjacencyList.get(cur)) {
                indegrees[c]-=1;
                if (indegrees[c]==0) {
                    queue.offer(c);
                }
            }
        }

        if (sorted.size()!=numNodes) {
            return new int[0];
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
