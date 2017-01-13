package lzhou.programmingtest.leetcode.test442;

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
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(3);
        int[] in = {4,3,2,7,8,2,3,1};
        List<Integer> actual = new Solution().findDuplicates(in);
        assertListEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(3);
        int[] in = {4,3,2,7,8,5,3,1};
        List<Integer> actual = new Solution().findDuplicates(in);
        assertListEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        int[] in = {2,2};
        List<Integer> actual = new Solution().findDuplicates(in);
        assertListEquals(expected, actual);
    }

    public void testSolution4()
    {
        List<Integer> expected = new ArrayList<Integer>();
        int[] in = {1,2};
        List<Integer> actual = new Solution().findDuplicates(in);
        assertListEquals(expected, actual);
    }

    private static void assertListEquals(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
