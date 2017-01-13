package lzhou.algorithm.permutation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;
/**
 * Unit test for simple App.
 */
public class SJTPermutationGeneratorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SJTPermutationGeneratorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SJTPermutationGeneratorTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testPermute0()
    {
        int[] in={1,2};
        List<int[]> expected = new ArrayList<int[]>();
        expected.add(new int[]{1,2});
        expected.add(new int[]{2,1});
        SJTPermutationGenerator generator = new SJTPermutationGenerator();
        List<int[]> out = generator.permute(in);
        assertListOfArrayEquals(expected, out);
    }
    
    public void testPermute1()
    {
        int[] in={1,2,3};
        List<int[]> expected = new ArrayList<int[]>();
        expected.add(new int[]{1,2,3});
        expected.add(new int[]{1,3,2});
        expected.add(new int[]{3,1,2});
        expected.add(new int[]{3,2,1});
        expected.add(new int[]{2,3,1});
        expected.add(new int[]{2,1,3});
        SJTPermutationGenerator generator = new SJTPermutationGenerator();
        List<int[]> out = generator.permute(in);
        assertListOfArrayEquals(expected, out);
    }
    
    public void testPermute2()
    {
        int[] in={1,2,3,4};
        List<int[]> expected = new ArrayList<int[]>();
        expected.add(new int[]{1,2,3,4});
        expected.add(new int[]{1,2,4,3});
        expected.add(new int[]{1,4,2,3});
        expected.add(new int[]{4,1,2,3});
        expected.add(new int[]{4,1,3,2});
        expected.add(new int[]{1,4,3,2});
        expected.add(new int[]{1,3,4,2});
        expected.add(new int[]{1,3,2,4});
        expected.add(new int[]{3,1,2,4});
        expected.add(new int[]{3,1,4,2});
        expected.add(new int[]{3,4,1,2});
        expected.add(new int[]{4,3,1,2});
        expected.add(new int[]{4,3,2,1});
        expected.add(new int[]{3,4,2,1});
        expected.add(new int[]{3,2,4,1});
        expected.add(new int[]{3,2,1,4});
        expected.add(new int[]{2,3,1,4});
        expected.add(new int[]{2,3,4,1});
        expected.add(new int[]{2,4,3,1});
        expected.add(new int[]{4,2,3,1});
        expected.add(new int[]{4,2,1,3});
        expected.add(new int[]{2,4,1,3});
        expected.add(new int[]{2,1,4,3});
        expected.add(new int[]{2,1,3,4});
        SJTPermutationGenerator generator = new SJTPermutationGenerator();
        List<int[]> out = generator.permute(in);
        assertListOfArrayEquals(expected, out);
    }

    private void assertListOfArrayEquals(List<int[]> expected, List<int[]> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            int[] a = expected.get(i);
            int[] b = actual.get(i);
            assertEquals(a.length, b.length);
            for (int j=0; j<a.length; ++j) {
                assertEquals(a[j], b[j]);
            }
        }
    }
}
