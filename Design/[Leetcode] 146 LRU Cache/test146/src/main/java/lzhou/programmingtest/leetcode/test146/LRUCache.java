package lzhou.programmingtest.leetcode.test146;
import java.util.*;

public class LRUCache {
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    
    static class Node {
        public int val;
        public int key;
        public Node next;
        public Node prev;
        
        public Node(int k, int v) {
            key = k;
            val =v;
            next = null;
            prev = null;
        }
    }
    
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
        map = new HashMap<Integer,Node>(capacity);
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(Integer.valueOf(key))) {
            return -1;
        }
        Node node = map.get(Integer.valueOf(key));
        moveToHead(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(Integer.valueOf(key))) {
            addToHead(key, value);
            map.put(Integer.valueOf(key), head);
            if (map.size()>capacity) {
                map.remove(Integer.valueOf(tail.key));
                removeTail();
            }
        } else {
            Node node = map.get(Integer.valueOf(key));
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(int k, int v) {
        if (head==null) {
            head = new Node(k, v);
            tail = head;
            return;
        }
        Node tmp = head;
        head = new Node(k, v);
        head.next = tmp;
        tmp.prev = head;
        return;
    }

    private void moveToHead(Node node) {
        if (node==head) {
            return;
        }
        if (node==tail) {
            tail = node.prev;
            node.prev.next=null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev=null;
        node.next=head;
        head.prev = node;
        head = node;
    }
        
    public void removeTail() {
        if (tail==null) {
            return;
        }
        if (head == tail) {
            head=null;
            tail = null;
            return;
        }
        Node tmp = tail.prev;
        tail.prev.next = null;
        tail.prev = null;
        tail = tmp;
    }
        
    public void printFromHead() {
        Node tmp = head;
        while (tmp!=null) {
            System.out.print(tmp.key);
            System.out.print(", ");
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
        
    public void printFromTail() {
        Node tmp = tail;
        while (tmp!=null) {
            System.out.print(tmp.key);
            System.out.print(", ");
            System.out.println(tmp.val);
            tmp = tmp.prev;
        }
    }
}
