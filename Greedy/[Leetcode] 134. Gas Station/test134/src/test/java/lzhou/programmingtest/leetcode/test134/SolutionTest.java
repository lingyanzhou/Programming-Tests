package lzhou.programmingtest.leetcode.test134;

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
        int[] gas = {4};
        int[] cost = {5};
        int expected = -1;
        int actual = new Solution().canCompleteCircuit(gas, cost);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        int[] gas = {5};
        int[] cost = {5};
        int expected = 0;
        int actual = new Solution().canCompleteCircuit(gas, cost);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        int[] gas = {4,2};
        int[] cost = {5,1};
        int expected = 1;
        int actual = new Solution().canCompleteCircuit(gas, cost);
        assertEquals(expected, actual);
    }
    public void testSolution4()
    {
        int[] gas = {1,1,3,1};
        int[] cost = {2,2,1,1};
        int expected = 2;
        int actual = new Solution().canCompleteCircuit(gas, cost);
        assertEquals(expected, actual);
    }
}
