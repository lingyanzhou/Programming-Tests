package lzhou.programmingtest.leetcode.test146;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LRUCacheTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LRUCacheTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LRUCacheTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
        cache.put(1,2);
        assertEquals(2, cache.get(1));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
        cache.put(2,3);
        assertEquals(3, cache.get(2));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp3()
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
        cache.put(2,3);
        assertEquals(3, cache.get(2));
        cache.put(4,45);
        assertEquals(45, cache.get(4));
        assertEquals(3, cache.get(2));
        assertEquals(-1, cache.get(1));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp4()
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
        cache.put(2,3);
        assertEquals(3, cache.get(2));
        cache.put(1,33);
        assertEquals(33, cache.get(1));
        cache.put(4,45);
        assertEquals(45, cache.get(4));
        assertEquals(33, cache.get(1));
        assertEquals(-1, cache.get(2));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp5()
    {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp6()
    {
        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(4));
    }
}
