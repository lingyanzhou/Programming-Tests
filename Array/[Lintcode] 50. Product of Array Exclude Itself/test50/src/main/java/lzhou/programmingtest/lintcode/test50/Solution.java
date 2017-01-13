package lzhou.programmingtest.lintcode.test50;
import java.util.*;

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>(A.size());
        ArrayList<Long> forward = new ArrayList<Long>(A.size());
        ArrayList<Long> backward = new ArrayList<Long>(A.size());
        long tmp = 1;
        for (int i=0; i<A.size(); ++i) {
            forward.add(tmp);
            tmp*= A.get(i);
        }
    
        tmp =1;
        for (int i=A.size()-1; i>=0; --i) {
            backward.add(tmp);
            tmp*= A.get(i);
        }
        
        
        for (int i=0; i<A.size(); ++i) {
            result.add(forward.get(i)*backward.get(A.size()-1-i));
        }
        return result;
    }
}
