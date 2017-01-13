package lzhou.programmingtest.leetcode.test49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Table[] tables= new Table[strs.length];
        for (int i=0; i<strs.length; ++i) {
            String s=strs[i];
            tables[i] = new Table(s);
        }
        List<List<String>> ret = new ArrayList<List<String>>();
        HashMap<Table, List<String>> map = new HashMap<Table, List<String>>();
        
        for (int i=0; i<strs.length; ++i) {
            if (!map.containsKey(tables[i])) {
                map.put(tables[i], new ArrayList<String>());
            }
            map.get(tables[i]).add(strs[i]);
        }
        
        for (List<String> ls: map.values()) {
            ret.add(ls);
        }
        
        return ret;
    }
    
    static class Table {
        int length;
        String encoded;
        int hashcode;
        int[] table;
        Table(String s) {
            table = new int[26];
            for (int i=0; i<s.length(); ++i) {
                table[s.charAt(i)-'a']+=1;
            }
            length = s.length();
            hashcode = Arrays.hashCode(table);
        }
        
        public int hashCode() {
            return hashcode;
        }
        
        public boolean equals(Object o) {
            if (o instanceof Table) {
                if (length!=((Table)o).length) {
                    return false;
                }
                for (int i=0; i<26; ++i) {
                    if (table[i]!=((Table)o).table[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }
}
