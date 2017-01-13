package lzhou.programmingtest.leetcode.test204;

//Sieve of Eratosthenes
public class Solution {
    public int countPrimes(int n) {
        if (n<2) {
            return 0;
        }
        boolean[] dp = new boolean[n];
        int sqrtN = (int)Math.sqrt(n);
        for (int i=0; i<=sqrtN-2; ++i) {
            if (!dp[i]) {
                for (long j=((long)i+2)*(i+2)-2; j<n-2; j+=i+2) {
                    dp[(int)j]=true;
                }
            }
        }
        
        int ret = 0;
        for (int i=0; i<n-2; ++i) {
            if (!dp[i]) {
                ret+=1;
            }
        }
        return ret;
    }
}
