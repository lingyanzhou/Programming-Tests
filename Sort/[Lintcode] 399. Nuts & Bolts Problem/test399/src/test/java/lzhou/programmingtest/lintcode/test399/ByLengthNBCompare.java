package lzhou.programmingtest.lintcode.test399;

public class ByLengthNBCompare implements NBCompare {
    public int cmp(String a, String b) {
        return Integer.compare(a.length(), b.length());
    }
}
