package lzhou.programmingtest.lintcode.test399;

import java.util.*;

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBCompare comparator) {
        // write your code here
        sortNutsAndBoltsHelper(nuts, bolts, 0, nuts.length, comparator);
    }
    
    
    private void sortNutsAndBoltsHelper(String[] nuts, String[] bolts, int start, int end, NBCompare comparator) {
        // write your code here
        if (start>=end) {
            return;
        }
        int ltEnd = start;
        int pivotEnd = start;
        String refNut = nuts[start];
        String refBolt = null;
        for (int i=start; i<end; ++i) {
            String bolt = bolts[i];
            int compareResult = comparator.cmp(refNut, bolt);
            if (compareResult==0) {
                refBolt = bolt;
                swap(bolts, i, pivotEnd);
                pivotEnd+=1;
            } else if (compareResult==1) {
                swap(bolts, i, ltEnd);
                if (ltEnd!=pivotEnd) {
                    swap(bolts, i, pivotEnd);
                }
                ltEnd+=1;
                pivotEnd+=1;
            } else {
                
            }
        }
        
        pivotEnd = start;
        ltEnd = start;
        for (int i=start; i<end; ++i) {
            String nut = nuts[i];
            int compareResult = comparator.cmp(nut, refBolt);
            if (compareResult==0) {
                swap(nuts, i, pivotEnd);
                pivotEnd+=1;
            } else if (compareResult==-1) {
                swap(nuts, i, ltEnd);
                if (ltEnd!=pivotEnd) {
                    swap(nuts, i, pivotEnd);
                }
                ltEnd+=1;
                pivotEnd+=1;
            } else {
                
            }
        }
        
        sortNutsAndBoltsHelper(nuts, bolts, start, ltEnd, comparator);
        sortNutsAndBoltsHelper(nuts, bolts, pivotEnd, end, comparator);
    }
    
    private void swap(String[] s, int i, int j) {
        String tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
