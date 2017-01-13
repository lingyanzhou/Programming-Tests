package lzhou.programmingtest.leetcode.test204;

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
        int expected = 0;
        int in = 0;
        Solution sol = new Solution();
        int actual = sol.countPrimes(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int expected = 0;
        int in = 2;
        Solution sol = new Solution();
        int actual = sol.countPrimes(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int expected = 1;
        int in = 3;
        Solution sol = new Solution();
        int actual = sol.countPrimes(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        int expected = 93852;
        int in = 1213123;
        Solution sol = new Solution();
        int actual = sol.countPrimes(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution5()
    {
        int expected = 19084;
        int in = 213441;
        Solution sol = new Solution();
        int actual = sol.countPrimes(in);
        assertEquals(expected, actual);
    }
}
