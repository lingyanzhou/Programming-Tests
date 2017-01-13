package lzhou.programmingtest.leetcode.test63;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
    public void testSolution0()
    {
        int[][] in = {{0}};
        int expected = 1;
        int actual = new Solution().uniquePathsWithObstacles(in);
        assertEquals(expected, actual);
    }
    public void testSolution1()
    {
        int[][] in = {{0,0},{0,0}};
        int expected = 2;
        int actual = new Solution().uniquePathsWithObstacles(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int[][] in = {{0,0,0},{0,1,0},{0,0,0}};
        int expected = 2;
        int actual = new Solution().uniquePathsWithObstacles(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int[][] in = {{0,0,0,1,0},{1,0,0,0,1},{0,0,1,0,0},{0,0,0,0,0}};
        int expected = 5;
        int actual = new Solution().uniquePathsWithObstacles(in);
        assertEquals(expected, actual);
    }
}
