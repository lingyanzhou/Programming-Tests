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
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode p1 = head;
        ListNode p2 = slow.next;
        slow.next =null;
        
        p1 = mergeSort(p1);
        p2 = mergeSort(p2);
        
        return merge(p1, p2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode cur = fake;
        while (l1!=null || l2!=null) {
            if (l1==null) {
                cur.next = l2;
                l2= l2.next;
            } else if (l2==null) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l1.val<l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2= l2.next;
            }
            cur=cur.next;
            cur.next = null;
        }
        return fake.next;
    }
}
