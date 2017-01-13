package lzhou.programmingtest.leetcode.test62;

//Combination: put n down movement in m+n slots
public class Solution2 {
    public int uniquePaths(int m, int n) {
        if (m>n) {
            int tmp = m;
            m=n;
            n=tmp;
        }
        m-=1;
        n-=1;
        long ret = 1;
        for (int i=0; i<m; ++i) {
            ret*= n+m-i;
        }
        for (int i=m; i>=2; --i) {
            ret/=i;
        }
        return (int)ret;
    }
}
