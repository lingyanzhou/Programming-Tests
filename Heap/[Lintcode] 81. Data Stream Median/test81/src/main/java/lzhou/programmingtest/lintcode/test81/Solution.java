package lzhou.programmingtest.lintcode.test81;

import java.util.*;

/**
 * Heap solution
 * 
 *   1. Keep two heaps, one for the smaller half, one for the larger half.
 *   2. The smaller one is a max heap, the larger one a min heap.
 *   3. The median is always at the head of the max heap.
 *   4. Add values smaller than median to the max heap, and others to the min heap.
 *   5. If the heaps size is unbalanced, balance them.
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums.length==0) {
            return new int[0];
        }
        PriorityQueue<Integer> part1 = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        });
        PriorityQueue<Integer> part2 = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        
        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; ++i) {
            if (part1.size()==0 || nums[i]<part1.peek()) {
                part1.offer(nums[i]);
            } else {
                part2.offer(nums[i]);
            }
            if (part1.size()==part2.size()+2) {
                part2.offer(part1.poll());
            }
            if (part2.size()==part1.size()+1) {
                part1.offer(part2.poll());
            }
            result[i] = part1.peek();
        }
        
        return result;
    }
}
