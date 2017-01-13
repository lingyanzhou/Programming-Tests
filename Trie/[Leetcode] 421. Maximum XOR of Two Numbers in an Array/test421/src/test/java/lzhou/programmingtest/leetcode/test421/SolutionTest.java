package lzhou.programmingtest.leetcode.test421;

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
        int expected = 28;
        int[] in = {3, 10, 5, 25, 2, 8};
        Solution sol = new Solution();
        int actual = sol.findMaximumXOR(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int expected = 31;
        int[] in = {5, 10, 16, 15, 14, 11, 6, 6, 9, 2};
        Solution sol = new Solution();
        int actual = sol.findMaximumXOR(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int expected = 2110086645;
        int[] in = {376410798, 1029358240, 1889567847, 1688129468, 1539754582, 1632929585, 420584700, 1183573926, 637769635, 1942809545};
        Solution sol = new Solution();
        int actual = sol.findMaximumXOR(in);
        assertEquals(expected, actual);
    }
    public void testSolution4()
    {
        int expected = 13;
        int[] in = {2147483642, 2147483645, 2147483643, 2147483643, 2147483647, 2147483638, 2147483642, 2147483639, 2147483643, 2147483642};
        Solution sol = new Solution();
        int actual = sol.findMaximumXOR(in);
        assertEquals(expected, actual);
    }
}
