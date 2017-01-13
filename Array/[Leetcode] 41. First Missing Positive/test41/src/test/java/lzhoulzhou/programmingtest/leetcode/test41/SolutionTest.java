package lzhoulzhou.programmingtest.leetcode.test41;

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
        int[] in = {1,2,0};
        int expected = 3;
        assertEquals(expected, new Solution().firstMissingPositive(in));
    }
    public void testSolution2()
    {
        int[] in = {3,4,-1,1};
        int expected = 2;
        assertEquals(expected, new Solution().firstMissingPositive(in));
    }
    public void testSolution3()
    {
        int[] in = {3,1,3,4,4};
        int expected = 2;
        assertEquals(expected, new Solution().firstMissingPositive(in));
    }
}
