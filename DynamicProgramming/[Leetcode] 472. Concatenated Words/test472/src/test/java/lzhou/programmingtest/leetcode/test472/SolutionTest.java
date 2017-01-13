package lzhou.programmingtest.leetcode.test472;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

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
        String[] in = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        String[] out = {"catsdogcats","dogcatsdog","ratcatdogcat"};
        List<String> result = new Solution().findAllConcatenatedWordsInADict(in);
        assertStringArrayEquals(out, result.toArray(new String[0]));
    }

    public void testSolution1()
    {
        String[] in = {""};
        String[] out = {};
        List<String> result = new Solution().findAllConcatenatedWordsInADict(in);
        assertStringArrayEquals(out, result.toArray(new String[0]));
    }

    public void testSolution2()
    {
        String[] in = {"a", "aa","aaa","aaaa","aaaaa"};
        String[] out = {"aa","aaa","aaaa","aaaaa"};
        List<String> result = new Solution().findAllConcatenatedWordsInADict(in);
        assertStringArrayEquals(out, result.toArray(new String[0]));
    }

    public void testSolution3()
    {
        String[] in = {"re", "tin", "ti","nu","la", "retinula"};
        String[] out = {"retinula"};
        List<String> result = new Solution().findAllConcatenatedWordsInADict(in);
        assertStringArrayEquals(out, result.toArray(new String[0]));
    }

    
    private void assertStringArrayEquals(String[] o1, String[] o2) {
        assertEquals(o1.length, o2.length);

        for (int i=0; i<o1.length; ++i) {
            assertEquals(o1[i], o2[i]);
        }
    }
}
