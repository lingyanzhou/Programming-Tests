package lzhou.programmingtest.leetcode.test142;

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
        return new TestSuite(SolutionTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSolution1()
    {
        ListNode root = new ListNode(0);
        ListNode expected = null;
        Solution sol = new Solution();
        ListNode actual = sol.detectCycle(root);
        assertEquals(expected, actual);
    }
    
    public void testSolution2()
    {
        ListNode root = new ListNode(0);
        root.next = new ListNode(0);
        root.next.next = new ListNode(0);
        root.next.next.next = root.next;
        ListNode expected = root.next;
        Solution sol = new Solution();
        ListNode actual = sol.detectCycle(root);
        assertEquals(expected, actual);
    }
    
    public void testSolution3()
    {
        ListNode root = new ListNode(0);
        root.next = new ListNode(0);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(0);
        ListNode expected = null;
        Solution sol = new Solution();
        ListNode actual = sol.detectCycle(root);
        assertEquals(expected, actual);
    }
    
    public void testSolution4()
    {
        ListNode root = new ListNode(0);
        root.next=root;
        ListNode expected = root;
        Solution sol = new Solution();
        ListNode actual = sol.detectCycle(root);
        assertEquals(expected, actual);
    }
}
