package lzhou.programmingtest.leetcode.test279;

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
        int in = 0;
        int expected = 0;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int in = 1;
        int expected = 1;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int in = 4;
        int expected = 1;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        int in = 625;
        int expected = 1;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution5()
    {
        int in = 12;
        int expected = 3;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution6()
    {
        int in = 13;
        int expected = 2;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution7()
    {
        int in = 464;
        int expected = 2;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution8()
    {
        int in = 4581;
        int expected = 2;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution9()
    {
        int in = 12312;
        int expected = 3;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution10()
    {
        int in = 23;
        int expected = 4;
        int actual = new Solution().numSquares(in);
        assertEquals(expected, actual);
    }
}
