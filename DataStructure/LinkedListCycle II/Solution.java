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
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
    }
    class IntPair {
        final int x;
        final int y;
        IntPair(int x, int y) {this.x=x;this.y=y;}
    }
    public ListNode detectCycle(ListNode head) {
        IntPair p = hasCycle(head);
        if (null==p) {
            //System.out.println("==1=");
            return null;
        }
           System.out.println("x="+p.x +" y="+p.y);
        int possibleIndex=p.x-p.y;
        for (int i=0; i<possibleIndex; i++) {
            head = head.next;
        }
            System.out.println(head.val);
        for (int i=0; i<p.y+1; i++) {
            ListNode test = head;
            for (int j=0; j<p.y; j++) {
                test = test.next;
            }
            System.out.println(test.val);
            if (head==test) {
                return head;
            }
            head = head.next;
        }
           System.out.println("==2=");
        return null;
        
    }
    
    
    public IntPair hasCycle(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        int steps1 = 0;
        boolean isLoop = false;
        while (slow.next!=null && fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast=fast.next.next;
            steps1+=1;
            if (slow==fast) {
                isLoop = true;
                break;
            }
        }
        if (!isLoop) {
            //System.out.println("====");
            return null;
        }
        int loopSize = 0;
        
        do{
            slow = slow.next;
            fast=fast.next.next;
            loopSize+=1;
        } while (slow!=fast) ;
        return new IntPair(steps1, loopSize);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        /*
        ListNode [] nodes = new ListNode[]{new ListNode(1),
            new ListNode(2)
            };
            */
        ListNode [] nodes = new ListNode[]{new ListNode(1),
            new ListNode(2),
            new ListNode(3),
            new ListNode(4),
            new ListNode(5),
            new ListNode(6),
            new ListNode(7),
            new ListNode(8),
            new ListNode(9),
            new ListNode(10)
            };
            
        ListNode head = nodes[0];
        for (int i=0; i<nodes.length-1; i++) {
            nodes[i].next = nodes[i+1];
        }
        nodes[nodes.length-1].next = nodes[9];
        ListNode c = s.detectCycle(head);
        if (c==null) {
            System.out.println("No Cycle");
        } else {
            System.out.println(c.val);
        }
    }
        
}
