package lzhou.programmingtest.leetcode.test127;
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
    public void testApp()
    {

        Solution sol = new Solution();
        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        String s = "hit";
        String e = "cog";
        assertEquals( 5, sol.ladderLength(s,e,set) );
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {

        Solution sol = new Solution();
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("c");
        set.add("d");
        String s = "a";
        String e = "d";
        assertEquals( 2, sol.ladderLength(s,e,set) );
    }
}
