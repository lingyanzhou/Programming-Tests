package lzhou.programmingtest.leetcode.test241;

import java.util.*;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<Integer>();
        
        List<String> tokens = tokenize(input);
        List<List<List<Integer>>> partialResults = new ArrayList<List<List<Integer>>>(tokens.size()/2);
        
        for (int i=0; i<(tokens.size()+1)/2; ++i) {
            List<List<Integer>> l = new ArrayList<List<Integer>>(partialResults.size());
            for (int j=0; j<(tokens.size()+1)/2; ++j) {
                l.add(null);
            }
            partialResults.add(l);
        }
        
        return diffWaysToComputeHelper(tokens, 0, tokens.size()-1, partialResults);
    }
    
    private List<Integer> diffWaysToComputeHelper(List<String> tokens, int start, int end, List<List<List<Integer>>> partialResults) {
        if (partialResults.get(start/2).get(end/2)!=null) {
            return partialResults.get(start/2).get(end/2);
        }
        List<Integer> ret = new ArrayList<Integer>();
        if (start==end) {
            ret.add(Integer.valueOf(tokens.get(start)));
        } else {
            for (int i=start+1; i<end; i+=2) {
                List<Integer> left = diffWaysToComputeHelper(tokens, start, i-1, partialResults);
                List<Integer> right = diffWaysToComputeHelper(tokens, i+1, end, partialResults);
                Operator op = getOperator(tokens.get(i));
                for (int o1: left) {
                    for (int o2: right) {
                        ret.add(op.calc(o1, o2));
                    }
                }
            }
        }
        partialResults.get(start/2).set(end/2, ret);
        return ret;
    }
    
    private List<String> tokenize(String input) {
        List<String> ret = new ArrayList<String>();
        
        boolean prevIsDigit = false;
        int numStart = 0;
        for (int i=0; i<input.length(); ++i) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                if (!prevIsDigit) {
                    prevIsDigit=true;
                    numStart = i;
                }
            } else {
                if (prevIsDigit) {
                    prevIsDigit=false;
                    ret.add(input.substring(numStart, i));
                }
                if (c=='+' || c=='-' || c=='*') {
                    ret.add(input.substring(i, i+1));
                }
            }
        }
        if (prevIsDigit) {
            ret.add(input.substring(numStart, input.length()));
        }
        return ret;
    }
    
    private Operator getOperator(String s) {
        if ("+".equals(s)) {
            return new Plus();
        } else if ("-".equals(s)) {
            return new Minus();
        } else {
            return new Mult();
        }
    }
}

interface Operator {
    public int calc(int o1, int o2);
}

class Plus implements Operator{
    public int calc(int o1, int o2) {
        return o1+o2;
    }
}
class Minus implements Operator{
    public int calc(int o1, int o2) {
        return o1-o2;
    }
}
class Mult implements Operator{
    public int calc(int o1, int o2) {
        return o1*o2;
    }
}
