package lzhou.programmingtest.leetcode.test555;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public String splitLoopedString(String[] strs) {
        //System.out.println("========");
        int n = strs.length;
        String[] orderedStrs = Arrays.stream(strs).map(s-> {
            String reversed = new StringBuilder(s).reverse().toString();
            if (reversed.compareTo(s)>0) {
                return reversed;
            } else {
                return s;
            }
        }).toArray(i->new String[i]);
        
        //Arrays.stream(orderedStrs).forEach(System.out::println);
        
        char largestChar = (char)Arrays.stream(strs).mapToInt(Solution::getMaxCharacter).max().orElse('a');
        
        //System.out.println(largestChar);
        
        String result = "";
        for (int i=0; i<n; ++i) {
            boolean notPossible = true;
            for (int j=0; j<orderedStrs[i].length(); ++j) {
                if (orderedStrs[i].charAt(j)==largestChar) {
                    notPossible=false;
                    break;
                }
            }
            if (notPossible) {
                continue;
            }
            
            String others = Arrays.stream(orderedStrs).skip(i+1).collect(Collectors.joining());
            others = Arrays.stream(orderedStrs).limit(i).collect(Collectors.joining("", others, ""));
            //System.out.print(">>>");
            //System.out.println(others);
            
            String candidate = getMaxBreakPoint(orderedStrs, largestChar, i, new StringBuilder(orderedStrs[i]), others);
            if (result.compareTo(candidate)<0) {
                result = candidate;
            }
            candidate = getMaxBreakPoint(orderedStrs, largestChar, i, new StringBuilder(orderedStrs[i]).reverse(), others);
            if (result.compareTo(candidate)<0) {
                result = candidate;
            }
        }
        
        return result;
    }
    
    private static int getMaxCharacter(String s) {
        return s.chars().max().orElse('a');
    }
    
    private static String getMaxBreakPoint(String[] orderedStrs, char largestChar, int skip, StringBuilder current,  String others) {
        String result = "";
        for (int j=0; j<current.length(); ++j) {
            if (current.charAt(j)==largestChar) {
                StringBuilder candidate = new StringBuilder(current.substring(j));
                candidate.append(others);
                candidate.append(current.substring(0,j));
                if (result.compareTo(candidate.toString())<0) {
                    result = candidate.toString();
                }
            }
        }
        return result;
    }
    
}
