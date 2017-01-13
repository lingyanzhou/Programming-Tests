package lzhou.programmingtest.leetcode.test474;

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
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int expected = 4;
        int actual = new Solution().findMaxForm(strs, m, n);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        int expected = 2;
        int actual = new Solution().findMaxForm(strs, m, n);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 8;
        int n = 8;
        int expected = 5;
        int actual = new Solution().findMaxForm(strs, m, n);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        String[] strs = {"10","0001","111001","101","0000"};
        int m = 5;
        int n = 4;
        int expected = 3;
        int actual = new Solution().findMaxForm(strs, m, n);
        assertEquals(expected, actual);
    }
}
