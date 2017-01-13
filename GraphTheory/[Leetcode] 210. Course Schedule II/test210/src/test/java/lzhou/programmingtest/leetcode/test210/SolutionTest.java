package lzhou.programmingtest.leetcode.test210;

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
    public void testSolution()
    {
        int numCourses = 2;
        int[][] prereq = {{1,0}};
        int[] expected = {0,1};
        Solution sol = new Solution();
        int[] out = sol.findOrder(numCourses, prereq);
        assertArrayEquals(expected, out);
    }
    
    public void testSolution2()
    {
        int numCourses = 4;
        int[][] prereq = {{1,0},{2,0},{3,1},{3,2}};
        int[] expected = {0,2,1,3};
        Solution sol = new Solution();
        int[] out = sol.findOrder(numCourses, prereq);
        assertArrayEquals(expected, out);
    }
    
    public void testSolution3()
    {
        int numCourses = 2;
        int[][] prereq = {{1,0},{0,1}};
        int[] expected = {};
        Solution sol = new Solution();
        int[] out = sol.findOrder(numCourses, prereq);
        assertArrayEquals(expected, out);
    }
    
    public void assertArrayEquals(int[] expected, int[] out) {
        assertEquals(expected.length, out.length);
        for (int i=0; i<expected.length; ++i) {
            assertEquals(expected[i], out[i]);
        }
    }
}
