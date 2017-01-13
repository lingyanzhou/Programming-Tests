package lzhou.programmingtest.lintcode.test141;

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
        int in = 2147483647;
        int expected = 46340;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
    public void testSolution2()
    {
        int in = 0;
        int expected = 0;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
    public void testSolution3()
    {
        int in = 1;
        int expected = 1;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
    public void testSolution4()
    {
        int in = 2;
        int expected = 1;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
    public void testSolution5()
    {
        int in = 4;
        int expected = 2;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
    public void testSolution6()
    {
        int in = 18;
        int expected = 4;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
    public void testSolution7()
    {
        int in = 101;
        int expected = 10;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
    public void testSolution8()
    {
        int in = 99;
        int expected = 9;
        Solution sol = new Solution();
        assertEquals(expected, sol.sqrt(in));
    }
}
