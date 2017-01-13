package lzhou.programmingtest.leetcode.test169;

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
        return new TestSuite(SolutionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSolution1()
    {
        int[] nums = {1, 1, 1, 1, 2, 2, 2};
        int expected = 1;
        int actual = new Solution().majorityElement(nums);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        int[] nums = {4,3,4};
        int expected = 4;
        int actual = new Solution().majorityElement(nums);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        int[] nums = {4,5,5,3,5,3,5,3,5,0,5,5,1,5,2};
        int expected = 5;
        int actual = new Solution().majorityElement(nums);
        assertEquals(expected, actual);
    }
}
