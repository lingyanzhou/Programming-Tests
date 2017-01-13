package lzhou.programmingtest.leetcode.test234;

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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head==null) {
            return true;
        }
        ListNode[] middles = middle(head);
        boolean isLengthOdd = middles[0]==middles[1];
        boolean ret = false;
        ListNode p2s=null;
        ListNode p1e=null;
        if (isLengthOdd) {
            p2s = middles[1].next;
            p1e = middles[0];
            p1e.next = null;
            reverse(head);
            ret = listEquals(p1e.next, p2s);
        } else {
            p2s = middles[1];
            p1e = middles[0];
            p1e.next = null;
            reverse(head);
            ret = listEquals(p1e, p2s);
        }
        reverse(p1e);
        p1e.next = p2s;
        return ret;
    }
    
    private ListNode[] middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        if (fast!=null) {
            return new ListNode[]{slow, slow};
        }
        return new ListNode[]{slowPrev, slow};
    }
    
    private int length(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur!=null) {
            len+=1;
            cur = cur.next;
        }
        return len;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur!=null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    private boolean listEquals(ListNode n1, ListNode n2) {
        while (n1!=null && n2!=null) {
            if (n1.val!=n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        
        if (n1!=null) {
            System.out.println("n1"+n1.val);
        }
        
        if (n2!=null) {
            System.out.println(n1.val);
        }
        if (n1!=n2) {
            return false;
        }
        return true;
    }
}
