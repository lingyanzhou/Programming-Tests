package lzhou.programmingtest.leetcode.test278;

public class Solution extends VersionControl {
    public Solution(int badVersion) {
        super(badVersion);
    }
    
    public int firstBadVersion(int n) {
        long start = 1; 
        long end = (long)n+1;
        while (start<end) {
            int mid = (int)((start+end)/2);
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = (long)mid+1;
            }
        }
        return (int)start;
    }
}
