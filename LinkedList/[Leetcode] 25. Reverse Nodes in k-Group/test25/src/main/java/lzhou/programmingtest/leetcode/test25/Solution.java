package lzhou.programmingtest.leetcode.test25;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (k==1 || head==null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        while (true){
            ListNode[] nodes = reverseNextK(pre.next, k);
            if (nodes==null) {
                break;
            }
            pre.next = nodes[0];
            pre = nodes[1];
        }
        return fakeHead.next;
    }
    
    public ListNode[] reverseNextK(ListNode head, int k) {
        ListNode tail = head;
        while (tail!=null && k!=0) {
            tail = tail.next;
            k-=1;
        }
        if (k!=0) {
            return null;
        }
        
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre=cur;
            cur=next;
        }
        head.next = tail;
        return new ListNode[]{pre, head};
    }
}
