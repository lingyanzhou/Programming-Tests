package lzhou.programmingtest.leetcode.test162;

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
    public void testSolution()
    {
        int[] nums = {1};
        int[] expected = {0};
        int actual = new Solution().findPeakElement(nums);
        assertIntInArray(expected, actual);
    }
    public void testSolution1()
    {
        int[] nums = {1, 2, 3, 1};
        int[] expected = {2};
        int actual = new Solution().findPeakElement(nums);
        assertIntInArray(expected, actual);
    }
    public void testSolution2()
    {
        int[] nums = {1,2,3,4,5};
        int[] expected = {4};
        int actual = new Solution().findPeakElement(nums);
        assertIntInArray(expected, actual);
    }
    public void testSolution3()
    {
        int[] nums = {0,-1,-2,-3,-4,-5};
        int[] expected = {0};
        int actual = new Solution().findPeakElement(nums);
        assertIntInArray(expected, actual);
    }
    public void testSolution4()
    {
        int[] nums = {1,0,1,0,1,0};
        int[] expected = {0,2,4};
        int actual = new Solution().findPeakElement(nums);
        assertIntInArray(expected, actual);
    }

    private void assertIntInArray(int[] expected, int actual) {
        for (int i:expected) {
            if (i==actual) {
                return;
            }
        }
        fail("Not in list: "+actual);
    }
}
