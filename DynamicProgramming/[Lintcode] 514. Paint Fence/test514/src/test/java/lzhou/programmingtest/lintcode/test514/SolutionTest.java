package lzhou.programmingtest.lintcode.test514;

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
        int m = 3;
        int k = 2;
        int expected = 6;
        int actual = new Solution().numWays(m,k);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int m = 1;
        int k = 2;
        int expected = 2;
        int actual = new Solution().numWays(m,k);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int m = 0;
        int k = 3;
        int expected = 0;
        int actual = new Solution().numWays(m,k);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        int m = 3;
        int k = 1;
        int expected = 0;
        int actual = new Solution().numWays(m,k);
        assertEquals(expected, actual);
    }
    public void testSolution5()
    {
        int m = 6;
        int k = 8;
        int expected = 247352;
        int actual = new Solution().numWays(m,k);
        assertEquals(expected, actual);
    }
    public void testSolution6()
    {
        int m = 4;
        int k = 30;
        int expected = 808230;
        int actual = new Solution().numWays(m,k);
        assertEquals(expected, actual);
    }
    
    public void testSolution7()
    {
        int m = 2;
        int k = 1;
        int expected = 1;
        int actual = new Solution().numWays(m,k);
        assertEquals(expected, actual);
    }
}
