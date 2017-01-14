package lzhou.programmingtest.lintcode.test129;

import java.util.*;

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int newSize = hashTable.length*2;
        ListNode[] newHashTable = new ListNode[newSize];
        ListNode[] curLists = new ListNode[newSize];
        
        for (int i=0; i<newSize; ++i) {
            newHashTable[i] = new ListNode(0);
            curLists[i] = newHashTable[i];
        }
        
        for (int i=0; i<hashTable.length; ++i) {
            while (hashTable[i]!=null) {
                int newHash = (hashTable[i].val%newSize+newSize)%newSize;
                curLists[newHash].next = hashTable[i];
                hashTable[i] = hashTable[i].next;
                curLists[newHash] = curLists[newHash].next;
                curLists[newHash].next = null;
            }
        }
        
        for (int i=0; i<newSize; ++i) {
            newHashTable[i] = newHashTable[i].next;
        }
        return newHashTable;
    }
};

