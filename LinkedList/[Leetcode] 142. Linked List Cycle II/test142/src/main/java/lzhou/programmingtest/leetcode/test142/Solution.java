package lzhou.programmingtest.leetcode.test142;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCircle = false;
        //Detect whether we have a circle
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow=slow.next;
            if (slow==fast) {
                hasCircle = true;
                break;
            }
        }
        //No Circle
        if (!hasCircle) {
            return null;
        }

        //reset fast, move fast and slow at the same pace
        //Now the distance difference is a multiple of circumsference c. They will meet at the start of the circle.
        
        fast = head;
        while (fast!=slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
