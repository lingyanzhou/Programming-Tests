package lzhou.algorithm.graph.topologicalsort.kahnalgo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class KahnAlgoTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KahnAlgoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KahnAlgoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSolution()
    {
        int nNodes = 2;
        int[][] links = {{0,1}};
        int[] expected = {0,1};
        KahnAlgo algo = new KahnAlgo();
        int[] out = algo.findOrder(nNodes, links);
        assertArrayEquals(expected, out);
    }
    
    public void testSolution2()
    {
        int nNodes = 5;
        int[][] links = {{0,1},{0,2},{1,3},{2,3}};
        int[] expected = {0,4,1,2,3};
        KahnAlgo algo = new KahnAlgo();
        int[] out = algo.findOrder(nNodes, links);
        assertArrayEquals(expected, out);
    }
    
    public void testSolution3()
    {
        int nNodes = 2;
        int[][] links = {{1,0},{0,1}};
        int[] expected = {};
        KahnAlgo algo = new KahnAlgo();
        int[] out = algo.findOrder(nNodes, links);
        assertArrayEquals(expected, out);
    }
    
    public void assertArrayEquals(int[] expected, int[] out) {
        assertEquals(expected.length, out.length);
        for (int i=0; i<expected.length; ++i) {
            assertEquals(expected[i], out[i]);
        }
    }
}
