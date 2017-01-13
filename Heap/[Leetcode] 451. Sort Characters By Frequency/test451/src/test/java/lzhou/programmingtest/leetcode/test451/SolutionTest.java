package lzhou.programmingtest.leetcode.test451;

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
        String in = "tree";
        String expected = "eert";
        String actual = new Solution().frequencySort(in);
        assertTrue( true );
    }
    
    public void testSolution2()
    {
        String in = "cccaaa";
        String expected = "aaaccc";
        String actual = new Solution().frequencySort(in);
        assertTrue( true );
    }
    
    public void testSolution3()
    {
        String in = "Aabb";
        String expected = "bbAa";
        String actual = new Solution().frequencySort(in);
        assertTrue( true );
    }
}
