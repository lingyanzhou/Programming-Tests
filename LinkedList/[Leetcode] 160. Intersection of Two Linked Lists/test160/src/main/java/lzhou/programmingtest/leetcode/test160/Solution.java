package lzhou.programmingtest.leetcode.test160;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA!=null && curB!=null) {
            curA=curA.next;
            curB=curB.next;
        }
        if (curA==null && curB==null) {
            curA=headA;
            curB=headB;
        } else {
            if (curA==null) {
                curA=headA;
                ListNode aheadB = curB;
                curB=headB;
                while (aheadB!=null) {
                    curB=curB.next;
                    aheadB=aheadB.next;
                }
            }
            if (curB==null) {
                curB=headB;
                ListNode aheadA = curA;
                curA=headA;
                while (aheadA!=null) {
                    curA=curA.next;
                    aheadA=aheadA.next;
                }
            }
        }
        while (curA!=null && curB!=null) {
            if (curA==curB) {
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }  
}
