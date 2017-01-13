package lzhou.programmingtest.leetcode.test410;

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
    public void testApp()
    {
        assertEquals(2, new Solution().splitArray(new int[]{2}, 1));
    }
    public void testApp1()
    {
        assertEquals(512, new Solution().splitArray(new int[]{7,2,5,10,8,512,4}, 4));
    }
    public void testApp2()
    {
        assertEquals(18, new Solution().splitArray(new int[]{7,2,5,10,8}, 2));
    }
}
