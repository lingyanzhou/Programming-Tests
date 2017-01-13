package lzhou.programmingtest.lintcode.test387;

import java.util.*;

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i=0; int j=0;
        int diff = Integer.MAX_VALUE;
        while (diff!=0 && i<A.length && j<B.length) {
            if (A[i]<B[j]) {
                int newI = Arrays.binarySearch(A, i, A.length, B[j]);
                if (newI>=0) {
                    diff=0;
                } else {
                    newI = -1-newI;
                    if (newI>0) {
                        diff = Math.min(diff, (int)Math.abs(B[j]-A[newI-1]));
                    }
                    if (newI<A.length-1) {
                        diff = Math.min(diff, (int)Math.abs(B[j]-A[newI+1]));
                    }
                    i=newI;
                }
            } else {
                int newJ = Arrays.binarySearch(B, j, B.length, A[i]);
                if (newJ>=0) {
                    diff=0;
                } else {
                    newJ = -1-newJ;
                    if (newJ>0) {
                        diff = Math.min(diff, (int)Math.abs(A[i]-B[newJ-1]));
                    }
                    if (newJ<B.length-1) {
                        diff = Math.min(diff, (int)Math.abs(A[i]-B[newJ+1]));
                    }
                    j=newJ;
                }
            }
        }
        return diff;
    }
}
