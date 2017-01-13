package lzhou.algorithms;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class HeapTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HeapTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HeapTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        Heap<Integer> heap = new Heap<Integer>(new IntegerComparator()); 
        assertEquals(0, heap.size());
        heap.add(Integer.valueOf(1));
        assertEquals(1, heap.peekMax().intValue());
        assertEquals(1, heap.size());
        heap.add(Integer.valueOf(12));
        assertEquals(12, heap.peekMax().intValue());
        assertEquals(2, heap.size());
        heap.add(Integer.valueOf(11));
        assertEquals(12, heap.peekMax().intValue());
        assertEquals(3, heap.size());
        heap.add(Integer.valueOf(111));
        assertEquals(111, heap.peekMax().intValue());
        assertEquals(4, heap.size());
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {
        List<Integer> list = new ArrayList<Integer>(5);
        for (int i=0; i<5; ++i) {
            list.add(Integer.valueOf((3*i)%5+(7*i+28)%13)); 
            // 2 12 4 14 6
        }
        Heap<Integer> heap = new Heap<Integer>(list, new IntegerComparator()); 
        assertEquals(14, heap.peekMax().intValue());
        assertEquals(5, heap.size());
        heap.add(Integer.valueOf(1));
        assertEquals(14, heap.peekMax().intValue());
        assertEquals(6, heap.size());
        heap.add(Integer.valueOf(11));
        assertEquals(14, heap.peekMax().intValue());
        assertEquals(7, heap.size());
        heap.add(Integer.valueOf(111));
        assertEquals(111, heap.peekMax().intValue());
        assertEquals(8, heap.size());
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp3()
    {
        List<Integer> list = new ArrayList<Integer>(5);
        for (int i=0; i<5; ++i) {
            list.add(Integer.valueOf((3*i)%5+(7*i+28)%13)); 
            // 2 12 4 14 6
        }
        Heap<Integer> heap = new Heap<Integer>(list, new IntegerComparator()); 
        assertEquals(5, heap.size());
        assertEquals(14, heap.removeMax().intValue());
        assertEquals(4, heap.size());
        assertEquals(12, heap.removeMax().intValue());
        assertEquals(3, heap.size());
        assertEquals(6, heap.removeMax().intValue());
        assertEquals(2, heap.size());
        assertEquals(4, heap.removeMax().intValue());
        assertEquals(1, heap.size());
        assertEquals(2, heap.removeMax().intValue());
        assertEquals(0, heap.size());
    }
}

class IntegerComparator
  implements Comparator<Integer>
{
    public int compare(Integer o1, Integer o2) {
        assert o1!=null && o2!=null;
        return o1.compareTo(o2);
    }

    public boolean equals(Object obj) {
        return false;
    }
}
