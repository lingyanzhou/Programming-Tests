package lzhou.programmingtest.leetcode.test313;

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
        return new TestSuite(SolutionTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSolution1()
    {
        int n = 1;
        int[] primes = {2,3,5};
        int expected = 1;
        int actual = new Solution().nthSuperUglyNumber(n, primes);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        int n = 3;
        int[] primes = {2,3,5};
        int expected = 3;
        int actual = new Solution().nthSuperUglyNumber(n, primes);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        int n = 78;
        int[] primes = {2,3,5};
        int expected = 750;
        int actual = new Solution().nthSuperUglyNumber(n, primes);
        assertEquals(expected, actual);
    }
    public void testSolution4()
    {
        int n = 10;
        int[] primes = {3,5,7,13};
        int expected = 27;
        int actual = new Solution().nthSuperUglyNumber(n, primes);
        assertEquals(expected, actual);
    }
    public void testSolution5()
    {
        int n = 233;
        int[] primes = {2,5,7,19};
        int expected = 29792;
        int actual = new Solution().nthSuperUglyNumber(n, primes);
        assertEquals(expected, actual);
    }
    public void testSolutionLarge()
    {
        int n = 100000;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
        int expected = 588756;
        int actual = new Solution().nthSuperUglyNumber(n, primes);
        assertEquals(expected, actual);
    }
}
