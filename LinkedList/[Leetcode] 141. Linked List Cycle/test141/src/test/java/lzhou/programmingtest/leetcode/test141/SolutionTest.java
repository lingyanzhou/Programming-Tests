package lzhou.programmingtest.leetcode.test141;

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
    public void testSolution()
    {
        ListNode root = new ListNode(0);
        root.next = root; 
        Solution sol = new Solution();
        assertTrue(sol.hasCycle(root));
    }
    
    public void testSolution1()
    {
        ListNode root = new ListNode(0);
        root.next = new ListNode(0); 
        Solution sol = new Solution();
        assertFalse(sol.hasCycle(root));
    }
    
    public void testSolution2()
    {
        ListNode root = new ListNode(0);
        root.next = new ListNode(0); 
        root.next.next = new ListNode(0); 
        root.next.next.next = new ListNode(0); 
        root.next.next.next.next = new ListNode(0); 
        root.next.next.next.next.next = new ListNode(0); 
        root.next.next.next.next.next.next = new ListNode(0); 
        Solution sol = new Solution();
        assertFalse(sol.hasCycle(root));
    }
    
    public void testSolution3()
    {
        ListNode root = new ListNode(0);
        root.next = new ListNode(0); 
        root.next.next = new ListNode(0); 
        root.next.next.next = new ListNode(0); 
        root.next.next.next.next = new ListNode(0); 
        root.next.next.next.next.next = new ListNode(0); 
        root.next.next.next.next.next.next = root.next.next.next.next; 
        Solution sol = new Solution();
        assertTrue(sol.hasCycle(root));
    }
}
