package lzhou.programmingtest.leetcode.test438;

import java.util.*;
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
        String inS = "cbaebabacd";
        String inP = "abc";
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(6);
        List<Integer> actual = new Solution().findAnagrams(inS, inP);
        assertListEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        String inS = "abab";
        String inP = "ab";
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        List<Integer> actual = new Solution().findAnagrams(inS, inP);
        assertListEquals(expected, actual);
    }

    private void assertListEquals(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
