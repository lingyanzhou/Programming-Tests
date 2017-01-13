package lzhou.programmingtest.lintcode.test197;
import java.util.*;

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        if (A.length==0) {
            return 0;
        }
        int[] Asorted = Arrays.copyOf(A, A.length);
        Arrays.sort(Asorted);
        
        int[] order = new int[A.length];
        for (int i=0; i<order.length; ++i) {
            order[i]=i;
        }

        long ret = 0;
        for (int i=0; i<A.length; ++i) {
            int j = A.length-1;
            for (; j>=0; --j) {
                if (Asorted[j]==A[i]) {
                    break;
                }
                order[j] -= 1;
            }
            ret+= order[j]*totalPermutation(A.length-1-i);
        }

        return ret+1;
    }

    private static long[] alreadyCalculated = {
                1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L
                };
    
    private long totalPermutation (int i) {
        if (i<=0 || i>20) {
            return 1L;
        }
        
        return alreadyCalculated[i];
    }
}
