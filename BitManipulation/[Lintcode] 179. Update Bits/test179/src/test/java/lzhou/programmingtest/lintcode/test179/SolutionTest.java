package lzhou.programmingtest.lintcode.test179;

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
    public void testSolution1()
    {
        int n =1;
        int m =-1;
        int i =0;
        int j =31;
        int expected = -1;
        Solution sol = new Solution();
        int actual = sol.updateBits(n, m, i, j);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int n =1023;
        int m =6;
        int i =2;
        int j =6;
        int expected = 923;
        Solution sol = new Solution();
        int actual = sol.updateBits(n, m, i, j);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int n =1023;
        int m =4098;
        int i =8;
        int j =20;
        int expected = 1049343;
        Solution sol = new Solution();
        int actual = sol.updateBits(n, m, i, j);
        assertEquals(expected, actual);
    }
}
