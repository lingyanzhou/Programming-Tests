package lzhou.programmingtest.leetcode.test313;

public class SolutionHeapless {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        int[] ptr = new int[primes.length];
        
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; ++i) {
            dp[i] = primes[0]*dp[ptr[0]];
            for (int j=1; j<primes.length; ++j) {
                dp[i] = Math.min(dp[i], primes[j]*dp[ptr[j]]);
            }
            for (int j=0; j<primes.length; ++j) {
                while (primes[j]*dp[ptr[j]]<=dp[i]) {
                    ptr[j]+=1;
                }
            }
        }
        return dp[n-1];
    }
}
