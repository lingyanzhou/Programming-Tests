package lzhou.programmingtest.leetcode.test189;

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
    public void testSolution_no_rotate()
    {
        int[] nums = {0,1};
        int[] expected = {0,1};
        int k= 0;
        Solution sol = new Solution();
        sol.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    public void testSolution_1_element()
    {
        int[] nums = {0};
        int[] expected = {0};
        int k= 1;
        Solution sol = new Solution();
        sol.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    public void testSolution_k_lt_n()
    {
        int[] nums = {1,2,3,4,5};
        int[] expected = {3,4,5,1,2};
        int k= 3;
        Solution sol = new Solution();
        sol.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    public void testSolution_k_eq_n()
    {
        int[] nums = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        int k= 5;
        Solution sol = new Solution();
        sol.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    public void testSolution_k_gt_n()
    {
        int[] nums = {1,2,3,4,5};
        int[] expected = {4,5,1,2,3};
        int k= 7;
        Solution sol = new Solution();
        sol.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i=0; i<expected.length; ++i) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
