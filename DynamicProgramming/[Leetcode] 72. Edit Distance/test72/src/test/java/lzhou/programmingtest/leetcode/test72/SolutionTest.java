package lzhou.programmingtest.leetcode.test72;

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
    public void testApp0()
    {
        Solution sol = new Solution();
        assertEquals(0, sol.minDistance("", ""));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        Solution sol = new Solution();
        
        assertEquals(3, sol.minDistance("abc", ""));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {
        Solution sol = new Solution();
        assertEquals(8, sol.minDistance("", "acdeefff"));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp3()
    {
        Solution sol = new Solution();
        assertEquals(5, sol.minDistance("lecodetde", "leetcode"));
    }
}
