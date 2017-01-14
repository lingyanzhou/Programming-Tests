package lzhou.programmingtest.leetcode.test382;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 * Reservior sampling
 * Idea:
 *   The probability to grab 0 at step 0 is 1.
 *   The probability to grab 1 at step 1 is 1/2, to remain 0 is 1-1/2=1/2
 *   The probability to grab 2 at step 2 is 1/3, to remain previous value is 1-1/3=2/3. But previous 0 and 1 have equal probability 2/3*1/2=1/3.
 *   Inductively, grab n at step n is 1/n, remaining previous value is (n-1)/n, with (n-1) equally possible values.
 */
public class Solution {
    Random rng;
    ListNode head;
    
    public Solution(ListNode head) {
        rng = new Random();
        this.head = head;
    }
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public int getRandom() {
        // write your code here
        ListNode cur = head;
        int n=0;
        int ret = 0;
        while (cur!=null) {
            n+=1;
            if (rng.nextInt(n)==0) {
                ret = cur.val;
            }
            cur = cur.next;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
