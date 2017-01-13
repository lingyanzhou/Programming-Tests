package lzhou.programmingtest.lintcode.test130;

import java.util.*;

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        //You can simply sort it. O(nlogn)
        //Arrays.sort(A);
        buildMinHeap(A);
    }

    /**
     * Build the heap bottom up
     * O(n)
     */
    private void buildMinHeap(int[] A) {
        for (int i=A.length/2; i>=0; --i) {
            minHeapPush(A, i);
        }
    }

    /**
     * Heapify a single error heap. Assuming the error is at the top parents.
     *
     * @param A the array
     * @param i current heap head
     */
    private void minHeapPush(int[] A, int i) {
        while (true) {
            int child1Ind = child1(i);
            int child2Ind = child2(i);
            int minChildInd = i;
            //Exchange i with its smallest child.
            // Then heapify the child heap.
            if (child1Ind>=A.length) {
                break;
            }
            if (child2Ind<A.length) {
                if (A[i]>A[child2Ind]) {
                    minChildInd = child2Ind;
                }
            }
            
            if (A[minChildInd]>A[child1Ind]) {
                minChildInd = child1Ind;
            }
            if (minChildInd==i) {
                break;
            }
            swap(A, i, minChildInd);
            i=minChildInd;
        }
    }

    private int parent(int i) {
        return (i+1)/2-1;
    }
    
    private int child1(int i) {
        return 2*i+1;
    }
    private int child2(int i) {
        return 2*i+2;
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
