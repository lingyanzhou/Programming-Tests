package lzhou.programmingtest.leetcode.test621;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        PriorityQueue<CharCount> heap = new PriorityQueue<CharCount>((cc1,cc2)->Integer.compare(cc2.count, cc1.count));
        Queue<CharCount> cools = new LinkedList<CharCount>();
        for (char c: tasks) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c)+1);
            } else {
                counts.put(c, 1);
            }
        }

        for (Character c: counts.keySet()) {
            heap.offer(new CharCount(c, counts.get(c)));
        }

        int result = 0;
        int done = 0;
        while (done < counts.size()) {
            if (heap.size()==0 && cools.size()>0) {
                cools.offer(CharCount.dummy);

            } else {
                CharCount cur = heap.poll();
                cur.count -=1;
                if (cur.count==0) {
                    done +=1;
                    cools.offer(CharCount.dummy);
                } else {
                    cools.offer(cur);
                }
                if (result<10) {
                    System.out.println(cur.ch);
                }
            }
            if (cools.size()==n+1) {
                CharCount cur = cools.poll();
                if (cur != CharCount.dummy) {
                    if (cur.count>0) {
                        heap.offer(cur);
                    }
                }
            }
            result += 1;
        }
        return result;
    }
}
class CharCount {
    char ch;
    int count;
    static CharCount dummy = new CharCount('_', 0);
    CharCount(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
