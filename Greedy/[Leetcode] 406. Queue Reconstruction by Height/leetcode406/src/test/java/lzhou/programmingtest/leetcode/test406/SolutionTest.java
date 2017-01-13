package lzhou.programmingtest.leetcode.test406;

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
    public void testApp1()
    {
        int[][] input = {{1,0}};
        int[][] expected =  {{1,0}};
        Solution sol = new Solution();
        int[][] output = sol.reconstructQueue(input);
        
        assert2dArrayEquals(expected, output);
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {
        int[][] input = {{3,0},{2,0}};
        int[][] expected =  {{2,0},{3,0}};
        Solution sol = new Solution();
        int[][] output = sol.reconstructQueue(input);
        
        assert2dArrayEquals(expected, output);
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp3()
    {
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] expected =  {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        Solution sol = new Solution();
        int[][] output = sol.reconstructQueue(input);
        
        assert2dArrayEquals(expected, output);
    }

    private void assert2dArrayEquals(int[][] expected, int[][] test) {
        
        if (expected.length != test.length) {
            assertTrue(false);
        }
        for (int i=0; i<expected.length; ++i) {
            if (expected[i].length != test[i].length) {
                assertTrue(false);
            }
            for (int j=0; j<expected[i].length; ++j) {
                assertEquals(expected[i][j], test[i][j]);
            }
        }
        
    }
}
