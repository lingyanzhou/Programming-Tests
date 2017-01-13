package lzhou.programmingtest.leetcode.test300;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Solution2Test 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Solution2Test( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Solution2Test.class );
    }

    /**
     * Rigourous Test :-)
     */
     
    public void testSoltion1()
    {
        int[] in = {};
        int expected = 0;
        assertEquals(expected, new Solution2().lengthOfLIS(in));
    }
    
    public void testSoltion2()
    {
        int[] in = {1};
        int expected = 1;
        assertEquals(expected, new Solution2().lengthOfLIS(in));
    }
    
    public void testSoltion3()
    {
        int[] in = {1,2,3};
        int expected = 3;
        assertEquals(expected, new Solution2().lengthOfLIS(in));
    }
    
    public void testSoltion4()
    {
        int[] in = {3,2,1};
        int expected = 1;
        assertEquals(expected, new Solution2().lengthOfLIS(in));
    }
    
    public void testSoltion5()
    {
        int[] in = {10, 9, 2, 5, 3, 7, 101, 18};
        int expected = 4;
        assertEquals(expected, new Solution2().lengthOfLIS(in));
    }

    
    public void testSoltion6()
    {
        int[] in = {15, 4, 9, 12, 8, 12, 12, 3, 11, 1};
        int expected = 3;
        assertEquals(expected, new Solution2().lengthOfLIS(in));
    }
    
    public void testSoltion7()
    {
        int[] in = {1, 16, 9, 8, 5, 3, 1, 12, 11, 4, 13, 14, 3, 4, 6, 13, 8, 11, 10, 6, 10, 7, 2, 12, 7, 1, 5, 1, 10, 5, 14, 10, 11, 5, 2, 2, 4, 9, 7, 11, 1, 10, 10, 1, 9, 2, 1, 9, 6, 6, 10, 14, 3, 3, 5, 14, 12, 5, 10, 9, 16, 16, 4, 6, 13, 5, 4, 15, 16, 1, 2, 2, 11, 1, 3, 11, 8, 16, 7, 10, 2, 10, 15, 11, 12, 16, 7, 12, 4, 10, 12, 9, 5, 7, 16, 8, 5, 14, 6, 1};
        int expected = 11;
        assertEquals(expected, new Solution2().lengthOfLIS(in));
    }
}
