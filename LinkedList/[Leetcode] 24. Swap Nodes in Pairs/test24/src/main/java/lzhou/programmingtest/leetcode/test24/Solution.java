package lzhou.programmingtest.leetcode.test24;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode prev = fakeHead;
        ListNode n1=null;
        ListNode n2=null;

        while (prev!=null && prev.next!=null && prev.next.next!=null) {
            n1 = prev.next;
            n2 = n1.next;

            ListNode tmp = n2.next;
            prev.next = n2;
            n2.next = n1;
            n1.next = tmp;
            prev = n1;
        }
        
        return fakeHead.next;
    }
}
