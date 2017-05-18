package lzhou.programmingtest.leetcode.test587;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point that = (Point) o;
            return x==that.x && y==that.y;
        } else {
            return false;
        }
    }
    public int hashCode() {
        return (x+31)*31+y;
    }
}
