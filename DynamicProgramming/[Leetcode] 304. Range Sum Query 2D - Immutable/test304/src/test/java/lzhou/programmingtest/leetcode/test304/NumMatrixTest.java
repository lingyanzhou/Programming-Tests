package lzhou.programmingtest.leetcode.test304;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class NumMatrixTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NumMatrixTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( NumMatrixTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        int[][] nums = {{3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                       };

        /*Expected: [[0, 0, 0, 0, 0, 0],
                     [0, 3, 3, 4, 8, 10],
                     [0, 8, 14, 18, 24, 27],
                     [0, 9, 17, 21, 28, 36],
                     [0, 13, 22, 26, 34, 49],
                     [0, 14, 23, 30, 38, 58]]
                     * */
        NumMatrix numMatrix = new NumMatrix(nums);
        
        assertEquals(3, numMatrix.sumRegion(0,0,0,0));
        assertEquals(5, numMatrix.sumRegion(4,4,4,4));
        assertEquals(1, numMatrix.sumRegion(4,0,4,0));
        assertEquals(13, numMatrix.sumRegion(3,3,4,4));
        assertEquals(15, numMatrix.sumRegion(0,3,2,4));
        assertEquals(58, numMatrix.sumRegion(0,0,4,4));
    }
}
