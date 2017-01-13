package lzhou.programmingtest.leetcode.test278;

public class VersionControl {
    private int badVersion;
    public VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }
    protected boolean isBadVersion(int version) {
        if (version>=badVersion) {
            return true;
        }
        return false;
    }
}
