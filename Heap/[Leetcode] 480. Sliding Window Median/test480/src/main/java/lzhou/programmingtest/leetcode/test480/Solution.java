package lzhou.programmingtest.leetcode.test480;

import java.util.*;

import java.util.stream.*;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k==0 || nums.length<k) {
            return new double[0];
        }
        if (k==1) {
            double[] result = new double[nums.length];
            for (int i=0; i<nums.length; ++i) {
                result[i] = nums[i];
            }
            return result;
        }
        
        PriorityQueue<Integer> heapFirstHalf = new PriorityQueue<Integer>(k-k/2, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2, i1);
            }
        });
        PriorityQueue<Integer> heapSecondHalf = new PriorityQueue<Integer>(k/2);
        double[] result = new double[nums.length-k+1];
        for (int i=0; i<nums.length; ++i) {
            int num = nums[i];
            if (heapSecondHalf.size()<k/2) {
                heapSecondHalf.offer(num);
            } else {
                if (heapFirstHalf.size()<k-k/2) {
                    heapSecondHalf.offer(num);
                    heapFirstHalf.offer(heapSecondHalf.poll());
                } else {
                    int numRemove = nums[i-k];
                    if (heapSecondHalf.remove(numRemove)) {
                        if (num<=heapFirstHalf.peek()) {
                            heapFirstHalf.offer(num);
                            heapSecondHalf.offer(heapFirstHalf.poll());
                        } else {
                            heapSecondHalf.offer(num);
                        }
                    } else {
                        heapFirstHalf.remove(numRemove);
                        if (num<heapSecondHalf.peek()) {
                            heapFirstHalf.offer(num);
                        } else {
                            heapSecondHalf.offer(num);
                            heapFirstHalf.offer(heapSecondHalf.poll());
                        }
                    }
                }
            }
            if (i>=k-1) {
                result[i-k+1]=heapFirstHalf.peek();
                if (k-k/2==k/2) {
                    result[i-k+1]= ((double)heapFirstHalf.peek()+(double)heapSecondHalf.peek())/2.0;
                }
            }
        }
        return result;
    }
}
