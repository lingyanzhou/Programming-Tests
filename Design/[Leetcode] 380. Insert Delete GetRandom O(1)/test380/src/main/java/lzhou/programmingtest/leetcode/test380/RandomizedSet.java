package lzhou.programmingtest.leetcode.test380;

import java.util.*;

/**
 * Idea:
 *   * Keep a list of all values. Keep a map of their indices.
 *   * Geting a random element directly generates a random index and looks up the value from the list.
 *   * Inserting a new one appends it to the list, and adds the value and its index in the map.
 *   * Removing a value swaps the element in the list with the last element in the list, updates the last elements index, then delete the value from the list and the map.
 * Boundary cases:
 *   * getRandom is called when the list is empty.
 *   * remove() is called to remove the last element. In this case, we don't update the index. 
 */
public class RandomizedSet {
    List<Integer> list;
    Random rnd;
    Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        rnd = new Random();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastVal = list.get(list.size()-1);
        
        if (lastVal==val) {
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        list.set(index, lastVal);
        map.put(lastVal, index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if (list.size()==0) {
            return -1;
        }
        int i = rnd.nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
