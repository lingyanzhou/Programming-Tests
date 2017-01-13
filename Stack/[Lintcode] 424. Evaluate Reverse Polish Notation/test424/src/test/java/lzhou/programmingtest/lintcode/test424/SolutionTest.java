package lzhou.programmingtest.lintcode.test424;

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
    public void testSolutionSingleValue()
    {
        String[] tokens = {"18"};
        int expected = 18;
        int actual = new Solution().evalRPN(tokens);
        assertEquals(expected, actual);
    }
    public void testSolutionAdd()
    {
        String[] tokens = {"18", "2", "+"};
        int expected = 20;
        int actual = new Solution().evalRPN(tokens);
        assertEquals(expected, actual);
    }
    public void testSolutionMinus()
    {
        String[] tokens = {"1", "2", "-"};
        int expected = -1;
        int actual = new Solution().evalRPN(tokens);
        assertEquals(expected, actual);
    }
    public void testSolutionDivision()
    {
        String[] tokens = {"18", "2", "/"};
        int expected = 9;
        int actual = new Solution().evalRPN(tokens);
        assertEquals(expected, actual);
    }
    public void testSolutionProduct()
    {
        String[] tokens = {"3", "2", "*"};
        int expected = 6;
        int actual = new Solution().evalRPN(tokens);
        assertEquals(expected, actual);
    }
    public void testSolutionComplexOp()
    {
        String[] tokens = {"3", "2", "*","4","-","5","2","/","+"};
        int expected = 4;
        int actual = new Solution().evalRPN(tokens);
        assertEquals(expected, actual);
    }
}
