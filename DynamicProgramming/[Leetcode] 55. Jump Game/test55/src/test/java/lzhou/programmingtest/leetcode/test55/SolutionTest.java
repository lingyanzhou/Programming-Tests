package lzhou.programmingtest.leetcode.test55;

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
        assertTrue(new Solution().canJump(A));
    }
    public void testSolution2()
    {
        int[] A = {1,0};
        assertTrue(new Solution().canJump(A));
    }
    public void testSolution3()
    {
        int[] A = {2,3,2,0,2,0,1,1,4,10,0,4,0,0,4,0,0,0,40,0,0,0,0,1};
        assertTrue(new Solution().canJump(A));
    }
    public void testSolution4()
    {
        int[] A = {0,8,4,0,2};
        assertFalse(new Solution().canJump(A));
    }
    public void testSolution5()
    {
        int[] A = {2,1,0,2,3};
        assertFalse(new Solution().canJump(A));
    }
    public void testSolution6()
    {
        int[] A = {4,0,0,1,0,3};
        assertFalse(new Solution().canJump(A));
    }
}
