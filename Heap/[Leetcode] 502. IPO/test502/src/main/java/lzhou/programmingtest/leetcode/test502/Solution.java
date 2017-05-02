package lzhou.programmingtest.leetcode.test502;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        assert n == Capital.length;
        Project[] projects = IntStream.range(0, n).mapToObj(i->new Project(Profits[i], Capital[i])).toArray(Project[]::new);
        Arrays.sort(projects, (p1, p2)-> {
            return Integer.compare(p1.capital, p2.capital);
        });
        
        Queue<Project> heap = new PriorityQueue<Project>(n, (p1, p2)-> -Integer.compare(p1.profit, p2.profit));
        
        for (int i=0; i<n && k>0; ++i) {
            if (W<projects[i].capital) {
                if (heap.size()>0) {
                    Project p = heap.poll();
                    if (p.capital<=W) {
                        W += p.profit;
                        k -= 1;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            heap.offer(projects[i]);
        }
        
        while (k>0 && heap.size()>0) {
            Project p = heap.poll();
            if (p.capital<=W) {
                W += p.profit;
                k -= 1;
            }
        }
        
        return W;
    }
    
    static class Project {
        int profit;
        int capital;
        
        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
        
        public String toString() {
            return "[profit="+profit+", capital="+capital+"]";
        }
    }
}


