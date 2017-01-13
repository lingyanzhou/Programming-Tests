package lzhou.programmingtest.leetcode.test73;

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
        int[][] in = {{1,0,2,0,3},{99,29,39,10,-1},{23,32,0,123,32},{23,123,2147483647, -2147483648,1},{1,0,2,3,2147483647}};
        int[][] expected = {{0,0,0,0,0},{99,0,0,0,-1},{0,0,0,0,0},{23,0,0, 0,1},{0,0,0,0,0}};
        Solution sol = new Solution();
        sol.setZeroes(in);
        assert2DMatrixEquals(expected, in);
    }

    private void assert2DMatrixEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int i=0; i<expected.length; ++i) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j=0; j<expected[i].length; ++j) {
                assertEquals(""+i+", "+j, expected[i][j], actual[i][j]);
            }
        }
    }
}
