package lzhou.programmingtest.leetcode.test406;
import java.util.*;

/*
 * 1. We can always find the first element by searching for k=0. If there are multiple elements, find the smallest h.
 * 2. After we found the first, we need to decrease people's k whose h is no larger than thar of the first
 * 3. From 1, we sort the array increasingly by h. From 2, we sort elements with the same h by k decreasingly. We can now look for the first element with k=0 form left to right, then decrease k for all elements on the left.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int ret = Integer.compare(o1[0], o2[0]);
                if (ret==0) {
                    ret = -Integer.compare(o1[1], o2[1]);
                }
                return ret;
            }
        };
        int[][] ret = new int[people.length][];
        int[] ks = new int[people.length];
        Arrays.sort(people, comparator);

        for (int i=0; i<people.length; ++i) {
            ks[i] = people[i][1];
        }

        for (int i=0; i<people.length; ++i) {
            int selected = -1;
            for (int j=0; j<people.length; ++j) {
                if (ks[j]==0) {
                    selected = j;
                    break;
                }
            }

            ret[i] = people[selected];
            for (int j=0; j<=selected; ++j) {
                if (ks[j]>=0) {
                    ks[j]-=1;
                }
            }
        }
        
        return ret;
    }
}
