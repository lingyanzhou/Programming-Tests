package lzhou.programmingtest.lintcode.test128;

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
        char[] key= "abcd".toCharArray();
        int HASH_SIZE = 100;
        int expected = 78;
        int actual = new Solution().hashCode(key, HASH_SIZE);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        char[] key= "Wrong answer or accepted?".toCharArray();
        int HASH_SIZE = 1000000007;
        int expected = 382528955;
        int actual = new Solution().hashCode(key, HASH_SIZE);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        char[] key= "aaaaaaaaa".toCharArray();
        int HASH_SIZE = 1000000;
        int expected = 93417;
        int actual = new Solution().hashCode(key, HASH_SIZE);
        assertEquals(expected, actual);
    }
}
