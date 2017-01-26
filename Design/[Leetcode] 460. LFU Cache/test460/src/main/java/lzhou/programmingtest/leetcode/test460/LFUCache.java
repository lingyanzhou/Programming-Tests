package lzhou.programmingtest.leetcode.test460;

import java.util.*;

/**
 * http://dhruvbird.com/lfu.pdf
 *   Idea: 
 *   1. Keep a linked list of frequency, with each node containing a list of values. 
 *   2. Keep a hash table, mapping from keys to values.
 */
public class LFUCache {
    RankNode head;
    RankNode tail;
    int capacity;
    int size;
    Map<Integer, ListNode> map;
    
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        map = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
        size=0;
        head = new RankNode(-1);
        tail = new RankNode(Integer.MAX_VALUE);
        head.next=tail;
        tail.prev=head;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void put(int key, int value) {
        // Write your code here
        if (capacity==0) {
            return;
        }
        if (map.containsKey(key)) {
            promote(map.get(key));
            map.get(key).val=value;
        } else {
            size+=1;
            if (size>capacity) {
                size-=1;
                map.remove(head.next.listHead.next.key);
                head.next.listHead.next.remove();
                head.next.purge();
            }
            if (head.next.rank==1) {
                RankNode r = head.next;
                ListNode n = new ListNode(r, key, value);
                n.next=r.listTail;
                r.listTail.prev.next=n;
                n.prev=r.listTail.prev;
                r.listTail.prev=n;
                map.put(key, n);
            } else {
                RankNode insert = new RankNode(1);
                ListNode n = new ListNode(insert, key, value);
                insert.next = head.next;
                head.next = insert;
                insert.next.prev = insert;
                insert.prev = head;
                
                n.prev = insert.listHead;
                n.next = insert.listHead.next;
                insert.listHead.next.prev=n;
                insert.listHead.next = n;
                n.rank = insert;
                map.put(key, n);
            }
        }
    }

    public int get(int key) {
        // Write your code here
        if (map.containsKey(key)) {
            promote(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    private void promote(ListNode n) {
        RankNode r = n.rank;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        if (r.next.rank==1+r.rank) {
            n.next=r.next.listTail;
            r.next.listTail.prev.next=n;
            n.prev=r.next.listTail.prev;
            r.next.listTail.prev=n;
            n.rank = r.next;
        } else { //
            RankNode insert = new RankNode(1+r.rank);
            insert.next = r.next;
            r.next = insert;
            insert.next.prev = insert;
            insert.prev = r;
            
            n.prev = insert.listHead;
            n.next = insert.listHead.next;
            insert.listHead.next.prev=n;
            insert.listHead.next = n;
            n.rank = insert;
        }
        r.purge();
    }
}

class RankNode {
    int rank=-1;
    RankNode next=null;
    RankNode prev=null;
    ListNode listHead=null;
    ListNode listTail=null;
    
    RankNode() {
        listHead=new ListNode(this);
        listTail=new ListNode(this);
        listHead.next=listTail;
        listTail.prev=listHead;
    }
    
    RankNode(int rank) {
        this();
        this.rank = rank;
    }
    
    void remove() {
        RankNode p = prev;
        RankNode n = next;
        p.next=n;
        n.prev=p;
        prev=null;
        next=null;
    }
    
    void purge() {
        if (listHead.next==listTail) { // Remove original rank node if necessary
            remove();
        }
    }
}
class ListNode {
    int key=0;
    int val=0;
    RankNode rank=null;
    ListNode next=null;
    ListNode prev=null;
    
    ListNode(RankNode rank) {
        key=0;
        val=0;
        next=null;
        prev=null;
        this.rank=rank;
    }
    
    ListNode(RankNode rank, int key, int val) {
        this(rank);
        this.key = key;
        this.val = val;
    }
    
    void remove() {
        ListNode p = prev;
        ListNode n = next;
        p.next=n;
        n.prev=p;
        prev=null;
        next=null;
    }
}
