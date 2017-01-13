package lzhou.programmingtest.lintcode.test113;

/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode prev = fakehead;
        ListNode cur = fakehead.next;
        
        while (cur!=null && cur.next!=null) {
            if (cur.val==cur.next.val) {
                while (cur!=null && prev.next.val==cur.val) {
                    cur = cur.next;
                }
                prev.next = cur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        
        return fakehead.next;
    }
}
