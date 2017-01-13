package lzhou.programmingtest.lintcode.test173;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode newhead = null;
        
        while (head!=null) {
            ListNode n = head;
            head=  head.next;
            n.next =null; 
            newhead = insertionSortListHelper(newhead, n);
        }
        
        return newhead;
    }
    
    public ListNode insertionSortListHelper(ListNode head, ListNode n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode prev = fakeHead;
        
        while (cur!=null) {
            if (cur.val>n.val) {
                prev.next = n;
                n.next = cur;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        
        if (cur==null) {
            prev.next = n;
        }
        return fakeHead.next;
    }
}
