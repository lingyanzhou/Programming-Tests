package lzhou.programmingtest;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.RuntimeException;

public class MedianFinder {
    List<Integer> list = new ArrayList<Integer>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        int ret = Collections.binarySearch(list, num);
        if (ret>=0) {
            list.add(ret, Integer.valueOf(num));
        } else {
            ret = -(ret+1);
            list.add(ret, Integer.valueOf(num));
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (list.size()==0) {
            throw new RuntimeException();
        }
        if (list.size()%2==1) {
            return list.get(list.size()/2);
        } else {
            int tmp = list.size()/2;
            return ((double)list.get(tmp-1) + (double)list.get(tmp))/2.0;
        }
    }
};
