package lzhou.programmingtest.leetcode.test45;

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
        int[] A = {0};
        int expected = 0;
        assertEquals(expected, new Solution().jump(A));
    }
    public void testSolution2()
    {
        int[] A = {1,0};
        int expected = 1;
        assertEquals(expected, new Solution().jump(A));
    }
    public void testSolution3()
    {
        int[] A = {2,0,2,1,3,1,1,8};
        int expected = 3;
        assertEquals(expected, new Solution().jump(A));
    }
    public void testSolution4()
    {
        int[] A = {0,8,4,0,2};
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, new Solution().jump(A));
    }
    public void testSolution5()
    {
        int[] A = {2,1,0,2,3};
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, new Solution().jump(A));
    }
    public void testSolution6()
    {
        int[] A = {4,0,0,1,0,3};
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, new Solution().jump(A));
    }
    public void testSolution7()
    {
        int[] A = {4,0,0,1,0,0};
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, new Solution().jump(A));
    }
    public void testSolution8()
    {
        int[] A = {1,2,3,4,5};
        int expected = 3;
        assertEquals(expected, new Solution().jump(A));
    }
}
