package lzhou.programmingtest.leetcode.test210;

import java.util.*;

public class Solution {
    //Tarjan's algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>(numCourses);
        for (int i=0; i<numCourses; ++i) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        for (int[] prereq: prerequisites) {
            adjacencyList.get(prereq[1]).add(prereq[0]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        Deque<Integer> sorted = new ArrayDeque<Integer>();
        Set<Integer> inStack = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        while (visited.size()<numCourses) {
            int cur = -1;
            for (int i=0; i<numCourses; ++i) {
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
        
        int[] ret = new int[numCourses];
        
        int index = 0;
        for (int i: sorted) {
            ret[index] = i;
            index+=1;
        }
        return ret;
    }
}
