package lzhou.programmingtest.leetcode.test172;

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
        int in = 1;
        int expected = 0;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        int in = 4;
        int expected = 0;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        int in = 6;
        int expected = 1;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution4()
    {
        int in = 29;
        int expected = 6;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution5()
    {
        int in = 40;
        int expected = 9;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution6()
    {
        int in = 928;
        int expected = 230;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution7()
    {
        int in = 1874;
        int expected = 464;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution8()
    {
        int in = 75923;
        int expected = 18976;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution9()
    {
        int in = 288883;
        int expected = 72217;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
    public void testSolution10()
    {
        int in = 89776644;
        int expected = 22444154;
        Solution sol = new Solution();
        int actual = sol.trailingZeroes(in);
        assertEquals(expected, actual);
    }
}
