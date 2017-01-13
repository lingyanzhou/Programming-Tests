public class Solution {
    public static int firstBadVersion(int n) {
            //System.out.println(n);
        int top = n;
        int bottom = 0;
        while (bottom+1!=top) {
            //System.out.println(bottom+", "+ top);
            int tmp = (int)(((long)top+bottom)/2);
            if (isBadVersion(tmp)) {
                top = tmp;
            } else {
                bottom = tmp;
            }
        }
        return top;
    }
    public static boolean isBadVersion(int i) {
        if (i>=1702766719) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
        System.out.println(firstBadVersion(1));
        System.out.println(firstBadVersion(2));
    }
}
