package lzhou.programmingtest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MedianFinderTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MedianFinderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MedianFinderTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(1.0, medianFinder.findMedian());
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp3()
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(1);
        assertEquals(3.5, medianFinder.findMedian());
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0 , medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(3.0, medianFinder.findMedian());
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp4()
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp5()
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(1);
        assertEquals(6.0, medianFinder.findMedian());
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp6()
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(0);
        assertEquals(0.0, medianFinder.findMedian());
        medianFinder.addNum(1);
        assertEquals(0.5, medianFinder.findMedian());
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(2);
        assertEquals(1.0, medianFinder.findMedian());
    }
}
