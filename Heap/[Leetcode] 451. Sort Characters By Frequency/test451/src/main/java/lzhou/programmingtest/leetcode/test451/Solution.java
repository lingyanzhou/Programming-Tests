package lzhou.programmingtest.leetcode.test451;
import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        int [] table = new int[256];
        for (char c: s.toCharArray()) {
            table[c]+=1;
        }
        PriorityQueue<CharAndFreq> queue = new PriorityQueue<CharAndFreq>();
        for (int i=0; i<256; ++i) {
            if (table[i]!=0) {
                queue.offer(new CharAndFreq((char)i, table[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            CharAndFreq cnf = queue.poll();
            for (int i=0; i<cnf.freq; ++i) {
                sb.append(cnf.c);
            }
        }
        return sb.toString();
    }

    static private class CharAndFreq implements Comparable<CharAndFreq> {
        public char c;
        public int freq;
        
        public CharAndFreq(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        public int compareTo(CharAndFreq o) {
            int ret = Integer.compare(o.freq, freq);
            if (ret==0) {
                ret = Character.compare(c, o.c);
            }
            return ret;
        }
    }
}
