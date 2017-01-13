package lzhou.programmingtest.leetcode.test61;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

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
        int k=1;
        ListNode root = toListNode(new int[]{});
        int[] expected = {};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
    }
    
    public void testSolution2()
    {
        int k=1;
        ListNode root = toListNode(new int[]{1});
        int[] expected = {1};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
    }
    
    public void testSolution3()
    {
        int k=1;
        ListNode root = toListNode(new int[]{1,2});
        int[] expected = {2,1};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
    }
    
    public void testSolution4()
    {
        int k=2;
        ListNode root = toListNode(new int[]{1,2});
        int[] expected = {1,2};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
    }
    
    public void testSolution5()
    {
        int k=2;
        ListNode root = toListNode(new int[]{1,2,3,4,5});
        int[] expected = {4,5,1,2,3};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
    }
    
    public void testSolution6()
    {
        int k=6;
        ListNode root = toListNode(new int[]{1,2,3,4,5});
        int[] expected = {5,1,2,3,4};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
    }
    
    public void testSolution7()
    {
        int k=0;
        ListNode root = toListNode(new int[]{1,2,3,4,5});
        int[] expected = {1,2,3,4,5};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
    }
    
    public void testSolution8()
    {
        int k=5;
        ListNode root = toListNode(new int[]{1,2,3,4,5});
        int[] expected = {1,2,3,4,5};
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(root, k);
        assertArrayEquals(expected, toArray(actual));
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
