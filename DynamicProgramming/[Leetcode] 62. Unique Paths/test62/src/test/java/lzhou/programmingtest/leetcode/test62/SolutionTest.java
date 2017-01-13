package lzhou.programmingtest.leetcode.test62;

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
    public void testSolution1()
    {
        int m = 1;
        int n = 2;
        int expected = 1;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
    
    public void testSolution2()
    {
        int m = 2;
        int n = 2;
        int expected = 2;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
    
    public void testSolution3()
    {
        int m = 10;
        int n = 10;
        int expected = 48620;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
    
    public void testSolution4()
    {
        int m = 3;
        int n = 7;
        int expected = 28;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
    public void testSolution5()
    {
        int m = 4;
        int n = 5;
        int expected = 35;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
}
