package lzhou.programmingtest.leetcode.test44;

//Use dp to accelerate.
public class Solution 
{
    public boolean isMatch(String s, String p) {
        byte[][] dp = new byte[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = 1;
        return isMatchHelper(s.toCharArray(), 0, p.toCharArray(), 0, dp);
    }

    public boolean isMatchHelper(char[] sChars, int sStart, char[] pChars, int pStart, byte[][] dp) {
        if (dp[sStart][pStart]!=0) {
            return dp[sStart][pStart]==1;
        }
        boolean ret = false;
        if (sStart==sChars.length) {
            if (pChars[pStart]=='*') {
                ret = isMatchHelper(sChars, sStart, pChars, pStart+1, dp);
            } else {
                ret = false;
            }
        } else if (pStart==pChars.length) {
            ret =  false;
        } else if (sChars[sStart]==pChars[pStart] || pChars[pStart]=='?') {
            ret = isMatchHelper(sChars, sStart+1, pChars, pStart+1, dp);
        } else if (pChars[pStart]=='*') {
            ret = isMatchHelper(sChars, sStart, pChars, pStart+1, dp) ||
                    isMatchHelper(sChars, sStart+1, pChars, pStart, dp);
        }
        if (ret) {
            dp[sStart][pStart] = 1;
        } else {
            dp[sStart][pStart] = -1;
        }
        return ret;
    }
}
