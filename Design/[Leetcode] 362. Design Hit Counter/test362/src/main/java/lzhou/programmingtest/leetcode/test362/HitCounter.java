package lzhou.programmingtest.leetcode.test362;

import java.util.*;

public class HitCounter 
{
    int total = 0;
    int[] counts = new int[300];
    int timestamp = 0;
    
    public int getHits(int ts) {
        advance(ts);
        return total;
    }

    public void hit(int ts) {
        advance(ts);
        counts[timestamp%300]+=1;
        total+=1;
    }

    private void advance(int ts) {
        if (ts-timestamp>300) {
            total=0;
            Arrays.fill(counts, 0);
        } else {
            for (int i=1; i<=ts-timestamp; ++i) {
                total-=counts[(timestamp+i)%300];
                counts[(timestamp+i)%300]=0;
            }
        }
        timestamp=ts;
    }
}
