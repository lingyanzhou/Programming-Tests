package lzhou.programmingtest.leetcode.test260;

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
    public void testSolution1()
    {
        int[] in = {1,2,1,3};
        int[] expected = {2,3};
        Solution sol = new Solution();
        int[] actual = sol.singleNumber(in);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
    public void testSolution2()
    {
        int[] in = {0,4,1,2,3,1,2,3};
        int[] expected = {0,4};
        Solution sol = new Solution();
        int[] actual = sol.singleNumber(in);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
    public void testSolution3()
    {
        int[] in = {8,8,4,4,2,2,1,16};
        int[] expected = {1,16};
        Solution sol = new Solution();
        int[] actual = sol.singleNumber(in);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
    public void testSolution4()
    {
        int[] in = {1023,1023,4,8,7,7,31,31,33,33,90,90,2929,2929,30,30,100,100,127,127};
        int[] expected = {4,8};
        Solution sol = new Solution();
        int[] actual = sol.singleNumber(in);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i=0; i<expected.length; ++i) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
