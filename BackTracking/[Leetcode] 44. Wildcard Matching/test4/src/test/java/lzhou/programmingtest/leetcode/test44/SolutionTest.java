package lzhou.programmingtest.leetcode.test44;

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
        String s = "aa";
        String p = "a";
        Solution sol = new Solution();
        assertFalse(sol.isMatch(s,p));
    }
    public void testSolution2()
    {
        String s = "aa";
        String p = "aa";
        Solution sol = new Solution();
        assertTrue(sol.isMatch(s,p));
    }
    public void testSolution3()
    {
        String s = "aa";
        String p = "aaa";
        Solution sol = new Solution();
        assertFalse(sol.isMatch(s,p));
    }
    public void testSolution4()
    {
        String s = "aa";
        String p = "*";
        Solution sol = new Solution();
        assertTrue(sol.isMatch(s,p));
    }
    public void testSolution5()
    {
        String s = "aa";
        String p = "a*";
        Solution sol = new Solution();
        assertTrue(sol.isMatch(s,p));
    }
    public void testSolution6()
    {
        String s = "ab";
        String p = "?*";
        Solution sol = new Solution();
        assertTrue(sol.isMatch(s,p));
    }
    public void testSolution7()
    {
        String s = "aab";
        String p = "c*a*b";
        Solution sol = new Solution();
        assertFalse(sol.isMatch(s,p));
    }
    public void testSolution8()
    {
        String s = "abca";
        String p = "ab*c?*";
        Solution sol = new Solution();
        assertTrue(sol.isMatch(s,p));
    }
    public void testSolution9()
    {
        String s = "aaaaaabbaavaababba";
        String p = "**b*a*";
        Solution sol = new Solution();
        assertTrue(sol.isMatch(s,p));
    }
    public void testSolution10()
    {
        String s = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
        String p = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";
        Solution sol = new Solution();
        assertTrue(sol.isMatch(s,p));
    }
    public void testSolution11()
    {
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        Solution sol = new Solution();
        assertFalse(sol.isMatch(s,p));
    }
}
