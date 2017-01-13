package lzhou.programmingtest.lintcode.test128;

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long result = 0;
        for (int i=0; i<key.length; ++i) {
            result += (result<<5)%HASH_SIZE;
            result %= HASH_SIZE;
            result += (int)key[i];
            result %= HASH_SIZE;
        }
        return (int)(result);
    }
};
