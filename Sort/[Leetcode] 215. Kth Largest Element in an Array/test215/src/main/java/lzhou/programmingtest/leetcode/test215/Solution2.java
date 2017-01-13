package lzhou.programmingtest.leetcode.test215;

import java.util.*;

/*
 * Heap:
 * O(nlogk) time, O(k) space
 */
class Solution2 {
    /*
     * @param k : k-th largest. 1-based.
     * @param nums : array of nums
     * @return: description of return
     */
    public int findKthLargest(int[] nums, int k)  {
        // write your code here
        if (nums.length==0 || k>nums.length || k<1) {
            return -1;
        }
        if (k*2>nums.length) {
            return findKthSmallest(nums, nums.length-k+1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k+1);

        for (int i: nums) {
            heap.offer(i);
            if (heap.size()==k+1) {
                heap.poll();
            }
        }

        return heap.poll();
    }
    
    private int findKthSmallest(int[] nums, int k)  {
        // write your code here
        if (nums.length==0 || k>nums.length || k<1) {
            return -1;
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k+1, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        
        for (int i: nums) {
            heap.offer(i);
            if (heap.size()==k+1) {
                heap.poll();
            }
        }

        return heap.poll();
    }
};
