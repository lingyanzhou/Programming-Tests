package lzhou.programmingtest.leetcode.test373;

import java.util.*;

/** 
 * Heap solution
 * 
 * Ref  https://discuss.leetcode.com/topic/50885/simple-java-o-klogk-solution-with-explanation
 *  
 *   * Use a min heap to keep track of current min. 
 *   * First, add each nums1 to nums2[0]. The min  is now in the heap.
 *   * Each time we remove the min from the heap, we find the next candidate by adding the same nums1 element with the next nums2 element, if we have the next nums2 element. 
 *   * Remove from the min heap k times or until the heap is empty.
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>(k);
        if (nums1.length==0 || nums2.length==0) {
            return ret;
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(1, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        
        for (int i=0; i<k && i<nums1.length; ++i) {
            heap.offer(new int[]{i, 0, nums1[i]+nums2[0]});
        }
        
        while (ret.size()<k && heap.size()>0) {
            int[] tmp = heap.poll();
            if (tmp[1]+1<nums2.length) {
                heap.offer(new int[]{tmp[0], tmp[1]+1, nums1[tmp[0]]+nums2[tmp[1]+1]});
            }
            ret.add(new int[]{nums1[tmp[0]], nums2[tmp[1]]});
        }
        
        return ret;
    }
}
