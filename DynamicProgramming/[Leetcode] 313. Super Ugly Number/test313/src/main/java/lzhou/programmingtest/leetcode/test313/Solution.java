package lzhou.programmingtest.leetcode.test313;

import java.util.*;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n<=0) {
            return 0;
        }

        PriorityQueue<PrimeIndexAndNextUglyNumber>  queue = new PriorityQueue<PrimeIndexAndNextUglyNumber>();
        
        int k = primes.length;
        int[] dp = new int[n];
        int[] ptr = new int[k];
        dp[0] = 1;

        for (int i=0; i<k; ++i) {
            queue.offer(new PrimeIndexAndNextUglyNumber(i, dp[ptr[i]]*primes[i]));
        }

        for (int i=1; i<n;) {
            PrimeIndexAndNextUglyNumber p = queue.poll();
            if (p.nextUglyNumber<=dp[i-1]) {
                ptr[p.primesIndex]+=1;
                queue.offer(new PrimeIndexAndNextUglyNumber(p.primesIndex, dp[ptr[p.primesIndex]]*primes[p.primesIndex]));
                continue;
            }
            dp[i] = p.nextUglyNumber;
            ptr[p.primesIndex] += 1;
            queue.offer(new PrimeIndexAndNextUglyNumber(p.primesIndex, dp[ptr[p.primesIndex]]*primes[p.primesIndex]));
            i+=1;
        }
        
        return dp[n-1];
    }

    static public class PrimeIndexAndNextUglyNumber
        implements Comparable<PrimeIndexAndNextUglyNumber> {
        int primesIndex;
        int nextUglyNumber;
        PrimeIndexAndNextUglyNumber(int primesIndex, int nextUglyNumber) {
            this.primesIndex = primesIndex;
            this.nextUglyNumber = nextUglyNumber;
        }

        public int compareTo(PrimeIndexAndNextUglyNumber o) {
            return Integer.compare(nextUglyNumber, o.nextUglyNumber);
        }
    }
}
