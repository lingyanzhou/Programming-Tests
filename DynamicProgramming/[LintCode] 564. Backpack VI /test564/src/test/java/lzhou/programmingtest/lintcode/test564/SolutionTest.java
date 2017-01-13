package lzhou.programmingtest.lintcode.test564;

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
        int[] nums= {4};
        int target = 4;
        int expected = 1;
        int actual = new Solution().backPackVI(nums, target);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        int[] nums= {1,2,4};
        int target = 4;
        int expected = 6;
        int actual = new Solution().backPackVI(nums, target);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        int[] nums= {1,2,4,5,6};
        int target = 20;
        int expected = 104604;
        int actual = new Solution().backPackVI(nums, target);
        assertEquals(expected, actual);
    }
}
