package lzhou.programmingtest.lintcode.test92;

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
        int m= 10;
        int[] A={2, 3, 5, 7};
        int expected = 10;
        int actual = new Solution().backPack(m, A);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        int m= 12;
        int[] A={2, 3, 5, 7};
        int expected = 12;
        int actual = new Solution().backPack(m, A);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        int m= 20;
        int[] A={5, 7, 14};
        int expected = 19;
        int actual = new Solution().backPack(m, A);
        assertEquals(expected, actual);
    }
    public void testSolutionLargeSet()
    {
        int m= 5000;
        int[] A={828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388};
        int expected = 5000;
        int actual = new Solution().backPack(m, A);
        assertEquals(expected, actual);
    }
}
