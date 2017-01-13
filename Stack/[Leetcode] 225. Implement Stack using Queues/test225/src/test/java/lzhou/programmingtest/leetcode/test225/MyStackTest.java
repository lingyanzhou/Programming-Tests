package lzhou.programmingtest.leetcode.test225;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MyStackTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MyStackTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MyStackTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMyStack()
    {
        MyStack mystack = new MyStack();
        assertTrue(mystack.empty());
        mystack.push(1);
        assertFalse(mystack.empty());
        mystack.push(3);
        assertEquals(3, mystack.top());
        mystack.pop();
        assertEquals(1, mystack.top());
        assertFalse(mystack.empty());
        mystack.pop();
        assertTrue(mystack.empty());
    }
}
