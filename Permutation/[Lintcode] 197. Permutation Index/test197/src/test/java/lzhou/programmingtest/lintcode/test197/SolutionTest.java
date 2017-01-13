package lzhou.programmingtest.lintcode.test197;

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
        int[] A = {};
        long expected = 0;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    
    public void testSolution2()
    {
        int[] A = {1};
        long expected = 1;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    
    public void testSolution3()
    {
        int[] A = {1,2,3};
        long expected = 1;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    
    public void testSolution4()
    {
        int[] A = {3,2,1};
        long expected = 6;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    
    public void testSolution5()
    {
        int[] A = {1,5,3,2};
        long expected = 6;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    public void testSolution6()
    {
        int[] A = {1,5,4,2,3};
        long expected = 23;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    
    public void testSolution7()
    {
        int[] A = {1,4,5,3,2};
        long expected = 18;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    
    public void testSolution8()
    {
        int[] A = {1,4,5,2,3};
        long expected = 17;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
    
    public void testSolution9()
    {
        int[] A = {19,2,3,4,5,6,7,8,9,11,12,13,14,17,18};
        long expected = 1220496076801L;
        long actual = new Solution().permutationIndex(A);
        assertEquals( expected, actual );
    }
}
