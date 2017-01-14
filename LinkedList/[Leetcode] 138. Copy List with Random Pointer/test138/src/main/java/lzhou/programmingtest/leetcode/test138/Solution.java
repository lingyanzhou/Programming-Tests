package lzhou.programmingtest.leetcode.test138;

import java.util.*;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<Integer, RandomListNode> created = new HashMap<Integer, RandomListNode>();
        
        RandomListNode fakeHead = new RandomListNode(0);
        RandomListNode cpyCur = fakeHead;
        while (head!=null) {
            if (!created.containsKey(head.label)) {
                created.put(head.label, new RandomListNode(head.label));
            }
            RandomListNode cpy = created.get(head.label);
            if (head.random!=null) {
                if (!created.containsKey(head.random.label)) {
                    created.put(head.random.label, new RandomListNode(head.random.label));
                }
                cpy.random = created.get(head.random.label);
            }
            cpyCur.next = cpy;
            cpyCur = cpyCur.next;
            head = head.next;
        }
        
        return fakeHead.next;
    }
}
