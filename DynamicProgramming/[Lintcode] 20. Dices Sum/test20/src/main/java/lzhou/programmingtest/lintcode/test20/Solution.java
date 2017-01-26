package lzhou.programmingtest.lintcode.test20;

import java.util.*;

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> ret = new ArrayList<Map.Entry<Integer, Double>>();
        if (n<=0) {
            return ret;
        }

        double[] dpCur= new double[n*5+1];
        for (int i=0; i<6; ++i) {
            dpCur[i]=1.0/6.0;
        }
        
        double[] dpNext= new double[n*5+1];
        for (int i=2; i<=n; ++i) {
            for (int j=0; j<6; ++j) {
                for (int k=0; k<i*5-4; ++k) {
                    dpNext[j+k] += dpCur[k]/6.0;
                }
            }
            double[] tmp = dpNext;
            dpNext = dpCur;
            dpCur = tmp;
            Arrays.fill(dpNext, 0.0);
        }
        
        for (int i=0; i<n*5+1; ++i) {
            ret.add(new AbstractMap.SimpleEntry<Integer, Double>(i+n, dpCur[i]));
        }
        
        return ret;
    }
}
