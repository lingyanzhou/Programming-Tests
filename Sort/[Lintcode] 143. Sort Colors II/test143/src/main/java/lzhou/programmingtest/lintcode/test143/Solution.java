package lzhou.programmingtest.lintcode.test143;

import java.util.*;

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int unsortedStart = 0;
        for (int i=1; i<k; ++i) {
            unsortedStart = sortColors2Helper(colors, unsortedStart, i);
        }
    }
    
    private int sortColors2Helper(int[] colors, int unsortedStart, int pivot) {
        int ltEnd=unsortedStart;
        int pivotEnd=unsortedStart;
        for (int i=unsortedStart; i<colors.length; ++i) {
            if (colors[i]==pivot) {
                swap(colors, i, pivotEnd);
                pivotEnd+=1;
            } else if (colors[i]<pivot){
                swap(colors, i, ltEnd);
                if (pivotEnd!=ltEnd) {
                    swap(colors, i, pivotEnd);
                }
                pivotEnd+=1;
                ltEnd+=1;
            } else {
            }
        }
        return pivotEnd;
    }
    
    private void swap(int [] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
