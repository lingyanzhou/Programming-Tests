package lzhou.programmingtest.lintcode.test50;

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
        ArrayList<Long> expected = longArrayToList(new long[]{6,3,2});
        ArrayList<Integer> in = intArrayToList(new int[]{1, 2, 3});
        Solution sol = new Solution();
        ArrayList<Long> actual = sol.productExcludeItself(in);
        assertArrayListEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        ArrayList<Long> expected = longArrayToList(new long[]{336,168,84,56,48});
        ArrayList<Integer> in = intArrayToList(new int[]{1,2,4,6,7});
        Solution sol = new Solution();
        ArrayList<Long> actual = sol.productExcludeItself(in);
        assertArrayListEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        ArrayList<Long> expected = longArrayToList(new long[]{32073194668032L,40091493335040L,17818441482240L,20045746667520L,17818441482240L,20045746667520L,80182986670080L,13363831111680L,53455324446720L,40091493335040L,22909424762880L,17818441482240L,160365973340160L,80182986670080L,80182986670080L,40091493335040L,26727662223360L,53455324446720L,160365973340160L,80182986670080L,4334215495680L,40091493335040L});
        ArrayList<Integer> in = intArrayToList(new int[]{5,4,9,8,9,8,2,12,3,4,7,9,1,2,2,4,6,3,1,2,37,4});
        Solution sol = new Solution();
        ArrayList<Long> actual = sol.productExcludeItself(in);
        assertArrayListEquals(expected, actual);
    }

    private ArrayList<Long> longArrayToList(long[] in) {
        ArrayList<Long> ret = new ArrayList<Long>();
        for (long l: in) {
            ret.add(l);
        }
        return ret;
    }

    private ArrayList<Integer> intArrayToList(int[] in) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i: in) {
            ret.add(i);
        }
        return ret;
    }

    private void assertArrayListEquals(ArrayList<Long> expected, ArrayList<Long> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
