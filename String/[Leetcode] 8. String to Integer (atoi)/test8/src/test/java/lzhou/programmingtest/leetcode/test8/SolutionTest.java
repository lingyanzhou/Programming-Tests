package lzhou.programmingtest.leetcode.test8;

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
        String in = "0";
        int expected = 0;
        assertEquals(expected, new Solution().myAtoi(in));
    }

    public void testSolution2()
    {
        String in = "10";
        int expected = 10;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution3()
    {
        String in = "-31";
        int expected = -31;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution4()
    {
        String in = "-2147483648";
        int expected = -2147483648;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution5()
    {
        String in = "-2147483649";
        int expected = -2147483648;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution6()
    {
        String in = "2147483647";
        int expected = 2147483647;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution7()
    {
        String in = "2147483648";
        int expected = 2147483647;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution8()
    {
        String in = "    214748sd";
        int expected = 214748;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution9()
    {
        String in = "  -21  47483648";
        int expected = -21;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution10()
    {
        String in = "";
        int expected = 0;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution11()
    {
        String in = "asdasd123123";
        int expected = 0;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution12()
    {
        String in = "   ";
        int expected = 0;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution13()
    {
        String in = "12312312312123123123";
        int expected = 2147483647;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution14()
    {
        String in = "-12312312312123123123";
        int expected = -2147483648;
        assertEquals(expected, new Solution().myAtoi(in));
    }
    
    public void testSolution15()
    {
        String in = "0000000000";
        int expected = 0;
        assertEquals(expected, new Solution().myAtoi(in));
    }
}
