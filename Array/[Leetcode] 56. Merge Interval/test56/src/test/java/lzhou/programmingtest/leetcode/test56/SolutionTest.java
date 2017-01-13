package lzhou.programmingtest.leetcode.test56;

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
    public void testSolutionEmpty()
    {
        List<Interval> intervals = toIntervalList(new int[][]{});
        List<Interval> expected = toIntervalList(new int[][]{});
        List<Interval> actual = new Solution().merge(intervals);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionMerge2To1()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{1,3},{3,4}});
        List<Interval> expected = toIntervalList(new int[][]{{1,4}});
        List<Interval> actual = new Solution().merge(intervals);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionNotOrdered()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{2,3},{5,7},{3,4}});
        List<Interval> expected = toIntervalList(new int[][]{{-1,0},{2,4},{5,7}});
        List<Interval> actual = new Solution().merge(intervals);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionMergeAll()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{2,3},{0,1},{-1,0},{3,4},{1,2}});
        List<Interval> expected = toIntervalList(new int[][]{{-1,4}});
        List<Interval> actual = new Solution().merge(intervals);
        assertIntervalListEquals( expected, actual );
    }
    public void testSolutionFullyCoverOneInterval()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,99},{3,4}});
        List<Interval> expected = toIntervalList(new int[][]{{-1,99}});
        List<Interval> actual = new Solution().merge(intervals);
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
