package lzhou.programmingtest.lintcode.test98;

import java.util.*;

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
public class Solution2 {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        return quickSort(head);
    }
    
    private ListNode quickSort(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode p1fake= new ListNode(0);
        ListNode p2fake= new ListNode(0);
        ListNode pivot = head;
        head = head.next;

        ListNode p1cur = p1fake;
        ListNode p2cur = p2fake;
        ListNode pivotcur = pivot;

        while (head!=null) {
            if (head.val==pivot.val) {
                pivotcur.next = head;
                pivotcur = pivotcur.next;
                head = head.next;
                pivotcur.next = null;
            } else if (head.val<=pivot.val) {
                p1cur.next = head;
                p1cur = p1cur.next;
                head = head.next;
                p1cur.next = null;
            } else {
                p2cur.next = head;
                p2cur = p2cur.next;
                head = head.next;
                p2cur.next = null;
            }
        }
        
        p1fake.next = quickSort(p1fake.next);
        p2fake.next = quickSort(p2fake.next);
        p1fake = concate(p1fake, pivot);
        pivotcur.next = p2fake.next;
        
        return p1fake.next;
    }
    
    private ListNode concate(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        fake.next = l1;
        ListNode cur = fake;
        while (cur.next!=null) {
            cur = cur.next;
        }
        cur.next= l2;
        
        return fake.next;
    }
}
