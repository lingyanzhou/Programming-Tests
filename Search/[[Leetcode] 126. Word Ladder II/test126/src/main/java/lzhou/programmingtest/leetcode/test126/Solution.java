package lzhou.programmingtest.leetcode.test126;

import java.util.*;

/**
 * DFS + BFS
 *   1. BFS: Build a partial graph, that goes only deep enough to find end, and we do not need to find links that link a deeper node to a shallower one. 
 *   2. DFS: construct paths from the partial graph. Note that some paht may not be terminated in end, and need to be removed.
 * Note: Directly use BFS can be slow as multiple paths can have common subpaths.
 */

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        dict.add(end);
        dict.remove(start);
        
        
        Map<String, List<String>> adjList = new HashMap<String, List<String>>();
        boolean done = bfsMakeGraph(start, end, dict, adjList);
        
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        if (done) {
            dfsGeneratePaths(start,end,adjList,path,ret);
        }
        return ret;
    }
    
    boolean bfsMakeGraph(String start, String end, Set<String> dict, Map<String, List<String>> adjList) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        queue.offer(null);
        Set<String> used = new HashSet<String>();
        
        boolean done = false;
        
        while (queue.size()>0 ) {
            String s = queue.poll();
            
            if (s==null) {
                if (done) {
                    break;
                }
                if (queue.size()>0) {
                    queue.offer(null);
                }
                dict.removeAll(used);
                used.clear();
                continue;
            }
            if (!adjList.containsKey(s)) {
                adjList.put(s, new ArrayList<String>());
            }
            for (String t: dict) {
                if (adjacent(s,t)) {
                    adjList.get(s).add(t);
                    if (!used.contains(t)) {
                        queue.add(t);
                        used.add(t);
                    }
                    if (end.equals(t)) {
                        done=true;
                    }
                }
            }
        }
        return done;
    }
    
    void dfsGeneratePaths(String start, String end, Map<String, List<String>> adjList, List<String> path, List<List<String>> ret) {
        path.add(start);
        if (start.equals(end)) {
            ret.add(new ArrayList<String>(path));
            path.remove(path.size()-1);
            return;
        }
        if (adjList.get(start)==null || adjList.get(start).size()==0) {
            path.remove(path.size()-1);
            return;
        }
        for (String n: adjList.get(start)) {
            dfsGeneratePaths(n, end, adjList, path, ret);
        }
        path.remove(path.size()-1);
    }
    
    public boolean adjacent(String s1, String s2) {
        assert s1.length()==s2.length();
        int diff = 0;
        for (int i=0; i<s1.length(); ++i) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                diff+=1;
                if (diff==2) {
                    return false;
                }
            }
        }
        return (diff==1);
    }
}
