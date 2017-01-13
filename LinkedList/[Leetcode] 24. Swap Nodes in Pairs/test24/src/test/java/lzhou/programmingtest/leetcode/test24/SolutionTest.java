package lzhou.programmingtest.leetcode.test24;

import java.util.*;
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
    public void testSolution1()
    {
        int[] expected = {1};
        ListNode head = toListNode(new int[]{1});
        ListNode newHead = new Solution().swapPairs(head);
        assertArrayEquals(expected, toArray(newHead));
    }
    public void testSolution2()
    {
        int[] expected = {1,2};
        ListNode head = toListNode(new int[]{2,1});
        ListNode newHead = new Solution().swapPairs(head);
        assertArrayEquals(expected, toArray(newHead));
    }
    public void testSolution3()
    {
        int[] expected = {2,1,4,3,5};
        ListNode head = toListNode(new int[]{1,2,3,4,5});
        ListNode newHead = new Solution().swapPairs(head);
        assertArrayEquals(expected, toArray(newHead));
    }
    public void testSolution4()
    {
        int[] expected = {2,1,4,3};
        ListNode head = toListNode(new int[]{1,2,3,4});
        ListNode newHead = new Solution().swapPairs(head);
        assertArrayEquals(expected, toArray(newHead));
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i=0; i<expected.length; ++i) {
            assertEquals(expected[i], actual[i]);
        }
    }
    private ListNode toListNode(int[] a) {
        ListNode fake = new ListNode(0);
        ListNode cur = fake;
        for (int i: a) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return fake.next;
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur!=null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] ret = new int[list.size()];
        for (int i=0; i<ret.length; ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
