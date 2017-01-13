package lzhou.programmingtest.leetcode.test190;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Solution1Test 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Solution1Test( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Solution1Test.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSolution1_1()
    {
        int expected = 0x80000000;
        int in = 1;
        assertEquals(expected, new Solution1().reverseBits(in));
    }
    public void testSolution1_2()
    {
        int expected = 0xE3972C8F;
        int in = 0xF134E9C7;
        assertEquals(expected, new Solution1().reverseBits(in));
    }
}
