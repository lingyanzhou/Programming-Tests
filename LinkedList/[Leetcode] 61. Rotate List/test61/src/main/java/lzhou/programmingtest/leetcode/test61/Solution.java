package lzhou.programmingtest.leetcode.test61;
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || k==0) {
            return head;
        }
        // write your code here
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode ahead = head;
        int length = 0;
        while (ahead!=null && length<k) {
            ahead = ahead.next;
            length+=1;
        }
        
        if (length==k && ahead==null) {
            return head;
        }
        
        if (ahead==null) {
            k=k%length;
            return rotateRight(head, k);
        }
        
        ListNode cur = head;
        while (ahead.next!=null) {
            ahead = ahead.next;
            cur = cur.next;
        }
        
        fake.next = cur.next;
        cur.next = null;
        ahead.next = head;
        
        return fake.next;
    }
}
