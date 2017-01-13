package lzhou.programmingtest.leetcode.test232;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MyQueueTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MyQueueTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MyQueueTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMyQueue()
    {
        MyQueue myqueue = new MyQueue();
        assertTrue(myqueue.empty());
        myqueue.push(1);
        assertFalse(myqueue.empty());
        myqueue.push(3);
        assertEquals(1, myqueue.peek());
        myqueue.pop();
        assertEquals(3, myqueue.peek());
        assertFalse(myqueue.empty());
        myqueue.pop();
        assertTrue(myqueue.empty());
    }
}
