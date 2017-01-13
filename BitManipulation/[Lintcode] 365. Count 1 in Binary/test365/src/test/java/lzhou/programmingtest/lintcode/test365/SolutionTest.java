package lzhou.programmingtest.lintcode.test365;

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
        int num = 32;
        int expected = 1;
        int actual = new Solution().countOnes(num);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        int num = 5;
        int expected = 2;
        int actual = new Solution().countOnes(num);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        int num = 1023;
        int expected = 10;
        int actual = new Solution().countOnes(num);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        int num = 234451;
        int expected = 11;
        int actual = new Solution().countOnes(num);
        assertEquals(expected, actual);
    }
}
