package lzhou.programmingtest.leetcode.test160;

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
    public void testSolutionNull()
    {
        ListNode headA = null;
        ListNode headB = null;
        ListNode expected = null;
        Solution sol = new Solution();
        ListNode actual = sol.getIntersectionNode(headA, headB);
        assertSame(expected, actual);
    }
    public void testSolutionIntersectAtMiddle()
    {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        ListNode headB = new ListNode(0);
        headB.next = headA.next;
        
        ListNode expected = headA.next;
        Solution sol = new Solution();
        ListNode actual = sol.getIntersectionNode(headA, headB);
        assertSame(expected, actual);
    }
    public void testSolutionIntersectAtRoot()
    {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        ListNode headB = headA;
        ListNode expected = headB;
        Solution sol = new Solution();
        ListNode actual = sol.getIntersectionNode(headA, headB);
        assertSame(expected, actual);
    }
    public void testSolutionIntersectAtTail()
    {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        ListNode headB = new ListNode(10);
        headB.next = headA.next.next;
        ListNode expected = headB.next;
        Solution sol = new Solution();
        ListNode actual = sol.getIntersectionNode(headA, headB);
        assertSame(expected, actual);
    }
    public void testSolutionNotIntersect()
    {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        ListNode headB = new ListNode(10);
        headB.next = new ListNode(11);
        ListNode expected = null;
        Solution sol = new Solution();
        ListNode actual = sol.getIntersectionNode(headA, headB);
        assertSame(expected, actual);
    }
}
