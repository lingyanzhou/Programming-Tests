package lzhou.programmingtest.leetcode.test268;

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
        int[] in = {0};
        int expected = 1;
        int actual = new Solution1().missingNumber(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution1_2()
    {
        int[] in = {0,1,3};
        int expected = 2;
        int actual = new Solution1().missingNumber(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution1_3()
    {
        int[] in = {0,1,2};
        int expected = 3;
        int actual = new Solution1().missingNumber(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution1_4()
    {
        int[] in = {2,1,3};
        int expected = 0;
        int actual = new Solution1().missingNumber(in);
        assertEquals(expected, actual);
    }
}
