package lzhou.programmingtest.leetcode.test464;

import java.util.*;

public class Solution2 {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        mergesort(A);
    }
    
    private void mergesort(int[] A) {
        if (A.length<=1) {
            return;
        }
        int[] A1 = new int[A.length/2];
        int[] A2 = new int[A.length-A1.length];
        System.arraycopy(A, 0, A1, 0, A1.length);
        System.arraycopy(A, A1.length, A2, 0, A2.length);
        mergesort(A1);
        mergesort(A2);
        merge(A1, A2, A);
    }
    
    private void merge(int[] A1, int[] A2, int[] A) {
        int i=0; int j=0;
        while (i<A1.length || j<A2.length) {
            if (i<A1.length && j<A2.length) {
                if (A1[i]<A2[j]) {
                    A[i+j]=A1[i];
                    i+=1;
                } else {
                    A[i+j]=A2[j];
                    j+=1;
                }
            } else if (i<A1.length) {
                A[i+j]=A1[i];
                i+=1;
            } else {
                A[i+j]=A2[j];
                j+=1;
            }
        }
    }
}
