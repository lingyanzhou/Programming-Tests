package lzhou.programmingtest.leetcode.test403;

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
        assertTrue(new Solution().canCross(new int[]{0,1,3,4,5,7,9,10,12}));
    }
    public void testSolution1()
    {
        assertFalse(new Solution().canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
}
