package lzhou.programmingtest.leetcode.test544;

import java.util.*;

public class Solution 
{
    public String findContestMatch(int n) {
        List<String> matches = new ArrayList<String>();
        for (int i=1; i<=n; ++i) {
            matches.add(Integer.toString(i));
        }
        return findContestMatchHelper(matches);
    }

    private String findContestMatchHelper(List<String> matches) {
        int n=matches.size();
        assert (1<<31)%n==0;
        if (n==2) {
            return combineMatches(matches.get(0), matches.get(1));
        }
        List<String> nextMatches = new ArrayList<String>();
        int mid = n/2;
        for (int i=0; i<mid; ++i) {
            nextMatches.add(combineMatches(matches.get(i), matches.get(n-i-1)));
        }
        
        return findContestMatchHelper(nextMatches);
    }
    
    private String combineMatches(String m1, String m2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(m1);
        sb.append(",");
        sb.append(m2);
        sb.append(")");
        return sb.toString();
    }
}

