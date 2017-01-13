package lzhou.programmingtest.leetcode.test307;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class NumArrayTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NumArrayTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( NumArrayTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testNumArrayTest1()
    {
        assertEquals(2, NumArray.calcParentIndex(3));
        assertEquals(0, NumArray.calcParentIndex(1));
        assertEquals(0, NumArray.calcParentIndex(2));
        assertEquals(0, NumArray.calcParentIndex(4));
        assertEquals(0, NumArray.calcParentIndex(8));
        assertEquals(10, NumArray.calcParentIndex(11));
        assertEquals(4, NumArray.calcParentIndex(5));
        assertEquals(4, NumArray.calcParentIndex(6));
        assertEquals(6, NumArray.calcParentIndex(7));
        assertEquals(6, NumArray.calcNextIndex(5));
        assertEquals(8, NumArray.calcNextIndex(6));
        assertEquals(4, NumArray.calcNextIndex(3));
        assertEquals(8, NumArray.calcNextIndex(4));
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testNumArrayTest2()
    {
        int [] input= {1,3,5};
        NumArray numarray = new NumArray(input);
        assertEquals(1, numarray.sumRange(0,0));
        assertEquals(4, numarray.sumRange(0,1));
        assertEquals(9, numarray.sumRange(0,2));
        assertEquals(8, numarray.sumRange(1,2));
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testNumArrayTest3()
    {
        int [] input= {1,3,5,9};
        NumArray numarray = new NumArray(input);
        assertEquals(18, numarray.sumRange(0,3));
        numarray.update(0,5); // 5 3 5 9
        assertEquals(5, numarray.sumRange(0,0));
        assertEquals(8, numarray.sumRange(1,2));
        assertEquals(14, numarray.sumRange(2,3));
        assertEquals(22, numarray.sumRange(0,3));
        assertEquals(13, numarray.sumRange(0,2));
        numarray.update(3,100); // 5 3 5 100
        assertEquals(8, numarray.sumRange(1,2));
        assertEquals(108, numarray.sumRange(1,3));
        assertEquals(13, numarray.sumRange(0,2));
        numarray.update(1, 0); // 5 0 5 100
        assertEquals(5, numarray.sumRange(1,2));
        assertEquals(105, numarray.sumRange(1,3));
        assertEquals(10, numarray.sumRange(0,2));
         
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testNumArrayTest4()
    {
        int [] input= {1,3,5,9};
        NumArray numarray = new NumArray(input);
        assertEquals(18, numarray.sumRange(0,3));
        numarray.update(0,5); // 5 3 5 9
        assertEquals(5, numarray.sumRange(0,0));
        assertEquals(8, numarray.sumRange(1,2));
        assertEquals(14, numarray.sumRange(2,3));
        assertEquals(22, numarray.sumRange(0,3));
        assertEquals(13, numarray.sumRange(0,2));
        numarray.update(0,100); // 100 3 5 9
        assertEquals(8, numarray.sumRange(1,2));
        assertEquals(17, numarray.sumRange(1,3));
        assertEquals(108, numarray.sumRange(0,2));
        assertEquals(117, numarray.sumRange(0,3));
        numarray.update(0, 10); // 10 3 5 9
        assertEquals(8, numarray.sumRange(1,2));
        assertEquals(17, numarray.sumRange(1,3));
        assertEquals(18, numarray.sumRange(0,2));
        assertEquals(27, numarray.sumRange(0,3));
    }
}
