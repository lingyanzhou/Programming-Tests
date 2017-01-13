package lzhou.programmingtest.lintcode.test515;

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
        int[][] costs = {{14,2,11}};
        int expected = 2;
        int actual = new Solution().minCost(costs);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        int[][] costs = {{14,2,11},{11,14,5}};
        int expected = 7;
        int actual = new Solution().minCost(costs);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
        int expected = 10;
        int actual = new Solution().minCost(costs);
        assertEquals(expected, actual);
    }
    public void testSolution4()
    {
        int[][] costs = {{14,2,11},{11,14,5},{14,3,10},{14,2,11},{11,14,5},{14,3,10},{14,2,11},{11,14,5},{14,3,10}};
        int expected = 52;
        int actual = new Solution().minCost(costs);
        assertEquals(expected, actual);
    }
}
