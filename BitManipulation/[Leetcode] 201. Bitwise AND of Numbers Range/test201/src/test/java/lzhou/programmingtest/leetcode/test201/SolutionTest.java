package lzhou.programmingtest.leetcode.test201;

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
        int expected = 0;
        int actual = new Solution().rangeBitwiseAnd(1023,1421);
        assertEquals(expected, actual);
    }

    public void testSolution2()
    {
        int expected = 0;
        int actual = new Solution().rangeBitwiseAnd(1,2147483647);
        assertEquals(expected, actual);
    }

    public void testSolution3()
    {
        int expected = 4;
        int actual = new Solution().rangeBitwiseAnd(5,7);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        int expected = 8192;
        int actual = new Solution().rangeBitwiseAnd(11232,14432);
        assertEquals(expected, actual);
    }
}
