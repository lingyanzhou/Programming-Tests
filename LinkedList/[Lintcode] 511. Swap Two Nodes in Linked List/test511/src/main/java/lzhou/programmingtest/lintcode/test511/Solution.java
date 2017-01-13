package lzhou.programmingtest.lintcode.test511;

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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next= head;
        ListNode prev1 = null;
        ListNode prev2 = null;
        ListNode n1 = null;
        ListNode n2 = null;
        ListNode prev = fakeHead;
        ListNode cur = fakeHead.next;
        
        while (cur!=null && (n1==null || n2==null)) {
            if (n1==null && cur.val==v1) {
                prev1 = prev;
                n1 = cur;
            }
            if (n2==null && cur.val==v2) {
                prev2 = prev;
                n2 = cur;
            }
            prev = cur;
            cur = cur.next;
        }
        
        if (n1!=null && n2!=null) {
            swapNodes(prev1, n1, prev2, n2);
        }
        return fakeHead.next;
    }
    
    private void swapNodes(ListNode prev1, ListNode n1, ListNode prev2, ListNode n2) {
        prev1.next = n2;
        prev2.next = n1;
        ListNode tmp = n2.next;
        n2.next = n1.next;
        n1.next = tmp;
    }
}
