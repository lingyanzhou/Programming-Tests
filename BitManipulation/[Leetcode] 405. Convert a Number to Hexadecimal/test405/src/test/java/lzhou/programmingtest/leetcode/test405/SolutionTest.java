package lzhou.programmingtest.leetcode.test405;

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
        int in = 26;
        String expected = "1a";
        String actual = new Solution().toHex(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int in = -1;
        String expected = "ffffffff";
        String actual = new Solution().toHex(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int in = 0;
        String expected = "0";
        String actual = new Solution().toHex(in);
        assertEquals(expected, actual);
    }
}
