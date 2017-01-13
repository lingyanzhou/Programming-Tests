package lzhou.programmingtest.lintcode.test78;

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
        String[] strs = {"ABCD", "ABEF", "ACEF"};
        String expected = "A";
        String actual = new Solution().longestCommonPrefix(strs);
        assertEquals(expected, actual);

    }
    
    public void testSolution2()
    {
        String[] strs = {"BBCD", "ABEF", "ACEF"};
        String expected = "";
        String actual = new Solution().longestCommonPrefix(strs);
        assertEquals(expected, actual);

    }
    
    public void testSolution3()
    {
        String[] strs = {"ABCDEFG", "ABCEFG", "ABCEFA"};
        String expected = "ABC";
        String actual = new Solution().longestCommonPrefix(strs);
        assertEquals(expected, actual);
    }

    
    
    public void testSolution4()
    {
        String[] strs = {"ABCDEFG"};
        String expected = "ABCDEFG";
        String actual = new Solution().longestCommonPrefix(strs);
        assertEquals(expected, actual);

    }
    
    public void testSolution5()
    {
        String[] strs = {"ABCDEFG", "ABCDEFGASD", "ABCDEFGASDASD"};
        String expected = "ABCDEFG";
        String actual = new Solution().longestCommonPrefix(strs);
        assertEquals(expected, actual);
    }
}
