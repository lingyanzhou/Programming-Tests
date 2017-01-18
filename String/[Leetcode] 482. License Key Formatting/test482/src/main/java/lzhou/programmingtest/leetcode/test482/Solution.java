package lzhou.programmingtest.leetcode.test482;

import java.util.*;

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int alphaNumericalCount = 0;
        for (int i=0; i<S.length(); ++i) {
            char c = S.charAt(i);
            if (c!='-') {
                alphaNumericalCount+=1;
            }
        }
        if (alphaNumericalCount==0) {
            return "";
        }
        int firstChunk = alphaNumericalCount%K;
        if (firstChunk==0) {
            firstChunk = K;
        }
        int dashCount = (alphaNumericalCount-firstChunk)/K;
        StringBuilder sb = new StringBuilder(alphaNumericalCount+dashCount);
        int chunkQuota = firstChunk;
        for (int i=0; i<S.length(); ++i) {
            char c = S.charAt(i);
            if (chunkQuota==0 && dashCount>0) {
                chunkQuota = K;
                dashCount-=1;
                sb.append('-');
            }
            if (c=='-') {
            } else if (Character.isDigit(c)) {
                sb.append(c);
                chunkQuota-=1;
            } else {
                sb.append(Character.toUpperCase(c));
                chunkQuota-=1;
            }
        }
        return sb.toString();
    }
}
