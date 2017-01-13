package lzhou.programmingtest.leetcode.test151;

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
        String expected = "";
        String in = "";
        Solution sol = new Solution();
        String actual = sol.reverseWords(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        String expected = "asd";
        String in = "asd";
        Solution sol = new Solution();
        String actual = sol.reverseWords(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        String expected = "asd das";
        String in = "das asd";
        Solution sol = new Solution();
        String actual = sol.reverseWords(in);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        String in = "  aac asd   das  ";
        String expected = "das asd aac";
        Solution sol = new Solution();
        String actual = sol.reverseWords(in);
        assertEquals(expected, actual);
    }
    public void testSolution5()
    {
        String expected = "";
        String in = "  ";
        Solution sol = new Solution();
        String actual = sol.reverseWords(in);
        assertEquals(expected, actual);
    }
    public void testSolution6()
    {
        String in = " abcd   ";
        String expected = "abcd";
        Solution sol = new Solution();
        String actual = sol.reverseWords(in);
        assertEquals(expected, actual);
    }
}
