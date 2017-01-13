package lzhou.programmingtest.lintcode.test371;
import java.util.*;
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
    public void testSolution0()
    {
        int N=0;
        List<Integer> actual = new Solution().numbersByRecursion(N);
        assertSolutionCorrect(N, actual);
    }
    public void testSolution1()
    {
        int N=1;
        List<Integer> actual = new Solution().numbersByRecursion(N);
        assertSolutionCorrect(N, actual);
    }
    public void testSolution2()
    {
        int N=2;
        List<Integer> actual = new Solution().numbersByRecursion(N);
        assertSolutionCorrect(N, actual);
    }
    public void testSolution3()
    {
        int N=3;
        List<Integer> actual = new Solution().numbersByRecursion(N);
        assertSolutionCorrect(N, actual);
    }
    public void testSolution5()
    {
        int N=5;
        List<Integer> actual = new Solution().numbersByRecursion(N);
        assertSolutionCorrect(N, actual);
    }

    private void assertSolutionCorrect(int N, List<Integer> actual) {
        assertEquals((int)Math.pow(10, N)-1, actual.size());
        for (int i=0; i<actual.size(); ++i) {
            assertEquals(i+1, actual.get(i).intValue());
        }
    }
}
