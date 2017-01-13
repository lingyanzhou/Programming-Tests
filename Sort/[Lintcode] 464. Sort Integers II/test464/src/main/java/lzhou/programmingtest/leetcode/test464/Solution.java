package lzhou.programmingtest.leetcode.test464;

import java.util.*;

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        quicksort(A);
    }
    
    private void quicksort(int[] A) {
        quicksortHelper(A, 0, A.length);
    }
    
    private void quicksortHelper(int[] A, int start, int end) {
        if (start>=A.length || end-start<=1) {
            return;
        }
        int p1End = start;
        int pivotEnd = 1+start; 
        int pivot = A[start];
        
        for (int i=start+1; i<end; ++i) {
            if (A[i]==pivot) {
                swap(A, i, pivotEnd);
                pivotEnd+=1;
            } else if (A[i]<pivot) {
                swap(A, i, p1End);
                swap(A, i, pivotEnd);
                p1End+=1;
                pivotEnd+=1;
            } else {//A[i]>pivot 
            
            }
        }
        
        quicksortHelper(A, start, p1End);
        quicksortHelper(A, pivotEnd, end);
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
