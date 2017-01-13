package lzhou.programmingtest.leetcode.test332;

import java.util.*;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        int totalTickets=tickets.length;
        List<String> result = new ArrayList<String>();
        result.add("JFK");
        if (totalTickets==0) {
            return result;
        }
        
        Map<String, List<String>> adjList = new HashMap<String, List<String>>();
        for (String[] t: tickets) {
            List<String> l = null;
            if (adjList.containsKey(t[0])) {
                l=adjList.get(t[0]);
            } else {
                l=new ArrayList<String>();
                adjList.put(t[0],l);
            }
            l.add(t[1]);
            
        }
        
        Map<String, List<Boolean>> usedList = new HashMap<String, List<Boolean>>();
        for (String[] t: tickets) {
            List<Boolean> l = null;
            if (!usedList.containsKey(t[0])) {
                l=new ArrayList<Boolean>();
                usedList.put(t[0],l);
                for (int i=adjList.get(t[0]).size(); i>0; --i) {
                    l.add(false);
                }
            }
        }
        
        for (List<String> l: adjList.values()) {
            Collections.sort(l);
        }
        
        boolean found = findItineraryHelper(adjList, usedList, result, totalTickets);
        return result;
    }
    
    public boolean findItineraryHelper(Map<String, List<String>> adjList,Map<String, List<Boolean>> usedList, List<String> result, int totalTickets) {
        if (result.size()-1==totalTickets) {
            return true;
        }
        if (result.size()==0) {
            return false;
        }
        String cur = result.get(result.size()-1);
        if (!adjList.containsKey(cur)) {
            return false;
        }
        for (int i=0; i<adjList.get(cur).size(); ++i) {
            if (usedList.get(cur).get(i)) {
                continue;
            }
            String next = adjList.get(cur).get(i);
            usedList.get(cur).set(i, true);
            result.add(next);
            boolean found = findItineraryHelper(adjList, usedList, result, totalTickets);
            if (found) {
                return true;
            }
            result.remove(result.size()-1);
            usedList.get(cur).set(i, false);
        }
        return false;
    }
}
