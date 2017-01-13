package lzhou.programmingtest.leetcode.test60;

import java.util.*;

class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        List<Character> charList = new LinkedList<Character>();
        for (int i=1; i<=n; ++i) {
            charList.add((char)(i+'0'));
        }
        
        char[] buff = new char[n];
        int[] futyrePermCount = new int[n];
        for (int i=n-2; i>=0; --i) {
            if (i==n-2) {
                futyrePermCount[i] = 1;
                continue;
            }
            futyrePermCount[i] = futyrePermCount[i+1]*(n-1-i);
        }
        
        k -= 1;
        int digitPos= 0;
        int guessK = 0;
        
        while (k>guessK) {
            int nthLargestChar = (k-guessK)/futyrePermCount[digitPos];
            buff[digitPos] = charList.get(nthLargestChar);
            charList.remove(nthLargestChar);
            guessK+=futyrePermCount[digitPos]*nthLargestChar;
            digitPos+=1;
        }
        
        for (int i=digitPos; i<n; ++i) {
            buff[i]=charList.get(i-digitPos);
        }
        
        return new String(buff);
    }
}
