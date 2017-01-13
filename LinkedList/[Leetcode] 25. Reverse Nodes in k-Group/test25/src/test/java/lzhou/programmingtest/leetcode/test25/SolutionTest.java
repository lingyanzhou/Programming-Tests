package lzhou.programmingtest.leetcode.test25;

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
    public void testApp1()
    {
        int[] iarray = {1,2,3,4,5};
        int[] oarray = {5,4,3,2,1};
        ListNode head = toListNodes(iarray);
        Solution sol = new Solution();
        ListNode newHead = sol.reverseKGroup(head, 5);
        assertListNodeEquals( newHead,  oarray);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {
        int[] iarray = {1,2,3,4,5};
        int[] oarray = {2,1,4,3,5};
        ListNode head = toListNodes(iarray);
        Solution sol = new Solution();
        ListNode newHead = sol.reverseKGroup(head, 2);
        assertListNodeEquals( newHead,  oarray);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp3()
    {
        int[] iarray = {1,2,3,4,5};
        int[] oarray = {3,2,1,4,5};
        ListNode head = toListNodes(iarray);
        Solution sol = new Solution();
        ListNode newHead = sol.reverseKGroup(head, 3);
        assertListNodeEquals( newHead,  oarray);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp4()
    {
        int[] iarray = {1,2,3,4,5,6};
        int[] oarray = {2,1,4,3,6,5};
        ListNode head = toListNodes(iarray);
        Solution sol = new Solution();
        ListNode newHead = sol.reverseKGroup(head, 2);
        assertListNodeEquals( newHead,  oarray);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp5()
    {
        int[] iarray = {1};
        int[] oarray = {1};
        ListNode head = toListNodes(iarray);
        Solution sol = new Solution();
        ListNode newHead = sol.reverseKGroup(head, 1);
        assertListNodeEquals( newHead,  oarray);
    }

    private static ListNode toListNodes(int[] array) {
        ListNode fakehead = new ListNode(0);
        ListNode cur = fakehead;
        for (int i:array) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return fakehead.next;
    }
    
    private static void assertListNodeEquals(ListNode head, int[] array) {
        for (int i:array) {
            assertTrue(head!=null);
            assertEquals(i, head.val);
            head = head.next;
        }
    }
}
