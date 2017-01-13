package lzhou.programmingtest.lintcode.test548;

import java.util.*;

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<Integer>();
        int i=0; 
        int j=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i+=1;
                j+=1;
            } else if (nums1[i] < nums2[j]) {
                //Key to speed: binary search for next possible index.
                i = Arrays.binarySearch(nums1, i+1, nums1.length, nums2[j]);
                if (i<0) {
                    i=-i-1;
                } else {
                    while (nums1[i]==nums2[j]) {
                        i-=1;
                    }
                    i+=1;
                }
            } else {
                j = Arrays.binarySearch(nums2, j+1, nums2.length, nums1[i]);
                if (j<0) {
                    j=-j-1;
                } else {
                    while (nums1[i]==nums2[j]) {
                        j-=1;
                    }
                    j+=1;
                }
            }
        }
        
        int[] ret = new int[list.size()];
        for (int ii=0; ii<list.size(); ++ii) {
            ret[ii] = list.get(ii);
        }
        return ret;
    }
}
