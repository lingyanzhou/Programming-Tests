package lzhou.programmingtest.leetcode.test457;

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
        int[] in={2,-1,1,2,2};
        Solution sol = new Solution();
        assertTrue(sol.circularArrayLoop(in));
    }
    
    public void testSolution2()
    {
        int[] in={-1,2};
        Solution sol = new Solution();
        assertFalse(sol.circularArrayLoop(in));
    }
    
    public void testSolution3()
    {
        int[] in={-2, 1, -1, -2, -2};
        Solution sol = new Solution();
        assertFalse(sol.circularArrayLoop(in));
    }
    
    public void testSolution4()
    {
        int[] in={2,-2,2,-2,-1};
        Solution sol = new Solution();
        assertTrue(sol.circularArrayLoop(in));
    }
    
    public void testSolution5()
    {
        int[] in={3,3,-1,-1};
        Solution sol = new Solution();
        assertFalse(sol.circularArrayLoop(in));
    }
    
    public void testSolution6()
    {
        int[] in={1,3,-1,-1,-1};
        Solution sol = new Solution();
        assertFalse(sol.circularArrayLoop(in));
    }
}
