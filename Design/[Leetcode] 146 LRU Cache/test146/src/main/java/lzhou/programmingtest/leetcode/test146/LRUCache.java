package lzhou.programmingtest.leetcode.test146;
import java.util.*;

public class LRUCache {
    int maxCapacity;
    int size;
    Map<Integer, ListNode> map;
    ListNode head, tail;
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.maxCapacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next=tail;
        tail.prev = head;
        map = new HashMap<Integer, ListNode>();
        size=0;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        ListNode n =map.get(key);
        if (n==null) {
            return -1;
        }
        promote(n);
        
        return n.val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void put(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            promote(map.get(key));
            map.get(key).val=value;
        } else {
            ListNode n = new ListNode(key, value);
            map.put(key, n);
            
            n.prev=head;
            n.next=head.next;
            head.next=n;
            n.next.prev=n;
            
            size+=1;
            
            if (size>maxCapacity) {
                size-=1;
                ListNode last = tail.prev;
                map.remove(last.key);
                tail.prev=last.prev;
                last.prev.next = tail;
                last.next = null;
                last.prev = null;
            }
        }
    }
    
    private void promote(ListNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev=head;
        n.next=head.next;
        head.next=n;
        n.next.prev=n;
    } 
}

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int k, int v) {key=k; val=v; next=null; prev=null;}
}
