package lzhou.programmingtest.lintcode.test399;

public class StringIgnoreCaseNBCompare implements NBCompare {
    public int cmp(String a, String b) {
        return a.compareToIgnoreCase(b);
    }
}
