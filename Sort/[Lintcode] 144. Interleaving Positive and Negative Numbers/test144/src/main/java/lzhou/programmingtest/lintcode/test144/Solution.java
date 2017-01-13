package lzhou.programmingtest.lintcode.test144;

import java.util.*;

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        int lt0End = 0;
        for (int i=0; i<A.length; ++i) {
            if (A[i]<0) {
                swap(A, lt0End, i);
                lt0End+=1;
            } else {
            }
        }
        int skipLt0 = 0;
        int skipGt0 = 0;
        int mid = A.length/2;

        int i=0;
        int j=A.length-1;
        if (lt0End==A.length-lt0End) {
        } else if (lt0End==A.length-lt0End+1) {
            i+=1;
        } else if (lt0End==A.length-lt0End-1) {
            j-=1;
        }
        while (i<j) {
            swap(A, i, j);
            i+=2;
            j-=2;
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
