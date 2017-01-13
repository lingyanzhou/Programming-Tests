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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<2 || head==null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = prev.next;
        while (cur!=null) {
            int count=0;
            ListNode p1 = prev;
            ListNode p3 = cur;
            while (count!=k && cur!=null) {
                prev = prev.next;
                cur = cur.next;
                count+=1;
            }
            if (count!=k) {
                break;
            }
            ListNode p2 = prev;
            ListNode p4 = cur;
            
            p1.next = null;
            p2.next = null;
            
            reverse(p3);
            p1.next = p2;
            p3.next = p4;
            
            prev = p3;
            cur = p4;
        }
        return fakeHead.next;
    }
    
    public ListNode reverse(ListNode head) {
        
        //dbg_print(head);
        if (head==null || head.next==null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        
        while (cur!=null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //dbg_print(prev);
        
        return prev;
    }
    
    public static void dbg_print(ListNode head) {
        System.out.println("print");
        while (head!=null) {
            System.out.print(head.val);
            System.out.print(", ");
            head = head.next;
        }
        System.out.println();
    }
}
