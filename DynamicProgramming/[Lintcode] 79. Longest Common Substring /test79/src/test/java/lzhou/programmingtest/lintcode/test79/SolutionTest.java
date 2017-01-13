package lzhou.programmingtest.lintcode.test79;

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
    public void testSolutionSingle()
    {
        String a = "abcd";
        String b = "a";
        int expected = 1;
        int actual = new Solution().longestCommonSubstring(a, b);
        assertEquals(expected, actual);
    }
    public void testSolutionSame()
    {
        String a = "abcd";
        String b = "abcd";
        int expected = 4;
        int actual = new Solution().longestCommonSubstring(a, b);
        assertEquals(expected, actual);
    }

    public void testSolutionSameNull()
    {
        String a = "";
        String b = "";
        int expected = 0;
        int actual = new Solution().longestCommonSubstring(a, b);
        assertEquals(expected, actual);
    }
    
    public void testSolutionNullNotNull()
    {
        String a = "";
        String b = "abcd";
        int expected = 0;
        int actual = new Solution().longestCommonSubstring(a, b);
        assertEquals(expected, actual);
    }
    
    public void testSolutionPrefix()
    {
        String a = "abcsedse";
        String b = "abcd";
        int expected = 3;
        int actual = new Solution().longestCommonSubstring(a, b);
        assertEquals(expected, actual);
    }
    
    public void testSolutionPostfix()
    {
        String a = "asdtyunfasdasdbcd";
        String b = "abcd";
        int expected = 3;
        int actual = new Solution().longestCommonSubstring(a, b);
        assertEquals(expected, actual);
    }
    
    public void testSolutionMiddle()
    {
        String a = "abcd";
        String b = "asdfvdasdabcdasrdfvdbcd";
        int expected = 4;
        int actual = new Solution().longestCommonSubstring(a, b);
        assertEquals(expected, actual);
    }
}
