package lzhou.programmingtest.lintcode.test185;

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
    public void testSolutionHorizontal()
    {
        int[][] in = {{1,0,2,0,3}};
        int[] expected = {1,0,2,0,3};
        Solution sol = new Solution();
        int[] actual = sol.printZMatrix(in);
        assertArrayEquals(expected, actual);
    }
    public void testSolutionVertical()
    {
        int[][] in = {{1},{0},{2},{0},{3}};
        int[] expected = {1,0,2,0,3};
        Solution sol = new Solution();
        int[] actual = sol.printZMatrix(in);
        assertArrayEquals(expected, actual);
    }
    public void testSolutionSingle()
    {
        int[][] in = {{1}};
        int[] expected = {1};
        Solution sol = new Solution();
        int[] actual = sol.printZMatrix(in);
        assertArrayEquals(expected, actual);
    }
    public void testSolutionEmpty()
    {
        int[][] in = {{}};
        int[] expected = {};
        Solution sol = new Solution();
        int[] actual = sol.printZMatrix(in);
        assertArrayEquals(expected, actual);
    }
    public void testSolution2x2()
    {
        int[][] in = {{1,2},{3,4}};
        int[] expected = {1,2,3,4};
        Solution sol = new Solution();
        int[] actual = sol.printZMatrix(in);
        assertArrayEquals(expected, actual);
    }
    public void testSolution4x2()
    {
        int[][] in = {{1,2},{3,5},{4,6},{7,8}};
        int[] expected = {1,2,3,4,5,6,7,8};
        Solution sol = new Solution();
        int[] actual = sol.printZMatrix(in);
        assertArrayEquals(expected, actual);
    }
    public void testSolution2x3()
    {
        int[][] in = {{1,2,5},{3,4,6}};
        int[] expected = {1,2,3,4,5,6};
        Solution sol = new Solution();
        int[] actual = sol.printZMatrix(in);
        assertArrayEquals(expected, actual);
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i=0; i<expected.length; ++i) {
            assertEquals("Element: "+i, expected[i], actual[i]);
        }
    }
}
