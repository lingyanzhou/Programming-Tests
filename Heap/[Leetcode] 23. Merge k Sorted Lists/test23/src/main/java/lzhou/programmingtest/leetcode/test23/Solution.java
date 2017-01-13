package lzhou.programmingtest.leetcode.test23;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        for (ListNode n: lists) {
            if (n!=null) {
                queue.offer(n);
            }
        }

        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            cur.next = n;
            cur = n;
            if (n.next!=null) {
                queue.offer(n.next);
            }
            cur.next = null;
        }
        return fakeHead.next;
    }
}

class ListNodeComparator implements Comparator<ListNode> {
    public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
    }
}
