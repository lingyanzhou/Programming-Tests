package lzhou.programmingtest.leetcode.test57;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;
/**
 * Unit test for simple App.
 */
public class SolutionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SolutionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SolutionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSolutionInsertIntoEmpty()
    {
        List<Interval> intervals = toIntervalList(new int[][]{});
        Interval newInterval = new Interval(1,2);
        List<Interval> expected = toIntervalList(new int[][]{{1,2}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionInsertAt0()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{3,4}});
        Interval newInterval = new Interval(1,2);
        List<Interval> expected = toIntervalList(new int[][]{{1,2},{3,4}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionInsertAtMiddle()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{3,4}});
        Interval newInterval = new Interval(1,2);
        List<Interval> expected = toIntervalList(new int[][]{{-1,0},{1,2},{3,4}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionInsertAtTail()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{3,4}});
        Interval newInterval = new Interval(5,6);
        List<Interval> expected = toIntervalList(new int[][]{{-1,0},{3,4},{5,6}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionFullyCoverOneInterval()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{3,4}});
        Interval newInterval = new Interval(2,6);
        List<Interval> expected = toIntervalList(new int[][]{{-1,0},{2,6}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionFullyInOneInterval()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{3,8}});
        Interval newInterval = new Interval(4,5);
        List<Interval> expected = toIntervalList(new int[][]{{-1,0},{3,8}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionTouchTwoIntervals()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{3,8},{11,12}});
        Interval newInterval = new Interval(0,3);
        List<Interval> expected = toIntervalList(new int[][]{{-1,8},{11,12}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionMergeAllIntervals()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{3,8},{11,12}});
        Interval newInterval = new Interval(-1, 99);
        List<Interval> expected = toIntervalList(new int[][]{{-1,99}});
        List<Interval> actual = new Solution().insert(intervals, newInterval);
        assertIntervalListEquals( expected, actual );
    }
    

    private List<Interval> toIntervalList(int[][] in) {
        List<Interval> ret = new ArrayList<Interval>(in.length);
        for (int i=0; i<in.length; ++i) {
            ret.add(new Interval(in[i][0], in[i][1]));
        }
        return ret;
    }
    
    private void assertIntervalListEquals(List<Interval> expected, List<Interval> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i).start, actual.get(i).start);
            assertEquals(expected.get(i).end, actual.get(i).end);
        }
    }
}
