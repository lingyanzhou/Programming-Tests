package lzhou.programmingtest.leetcode.test264;

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
    public void testSoluton1()
    {
        int in = 1;
        int expected = 1;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton2()
    {
        int in = 2;
        int expected = 2;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton3()
    {
        int in = 3;
        int expected = 3;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton4()
    {
        int in = 4;
        int expected = 4;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton5()
    {
        int in = 5;
        int expected = 5;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton6()
    {
        int in = 9;
        int expected = 10;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton7()
    {
        int in = 13;
        int expected = 18;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton8()
    {
        int in = 100;
        int expected = 1536;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
    public void testSoluton9()
    {
        int in = 300;
        int expected = 82944;
        assertEquals(expected, new Solution().nthUglyNumber(in));
    }
}
