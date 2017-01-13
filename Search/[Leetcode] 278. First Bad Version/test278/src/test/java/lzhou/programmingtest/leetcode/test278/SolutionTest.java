package lzhou.programmingtest.leetcode.test278;

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
        int expected = 2147483647;
        int actual = new Solution(expected).firstBadVersion(2147483647);
        
        assertEquals(expected, actual);
    }
    
    public void testSolution1()
    {
        int expected = 1;
        int actual = new Solution(expected).firstBadVersion(1);
        
        assertEquals(expected, actual);
    }
}
