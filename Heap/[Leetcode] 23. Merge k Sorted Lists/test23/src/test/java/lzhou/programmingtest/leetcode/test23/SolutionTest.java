package lzhou.programmingtest.leetcode.test23;

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
        ListNode[] lists = new ListNode[0];
        int[] expected = {};
        ListNode merged = new Solution().mergeKLists(lists);
        assertListEquals(expected, merged);
    }
    
    public void testSolution2()
    {
        ListNode[] lists = new ListNode[1];
        int[] expected = {};
        ListNode merged = new Solution().mergeKLists(lists);
        assertListEquals(expected, merged);
    }
    
    public void testSolution3()
    {
        ListNode[] lists = new ListNode[2];
        lists[0] = toList(new int[] {1,2,3});
        lists[1] = toList(new int[] {1,4});
        int[] expected = {1,1,2,3,4};
        ListNode merged = new Solution().mergeKLists(lists);
        assertListEquals(expected, merged);
    }
    
    public void testSolution4()
    {
        ListNode[] lists = new ListNode[3];
        lists[0] = toList(new int[] {1,5,9,13,16});
        lists[1] = toList(new int[] {1,2,3,7,8,10,14,15,16});
        lists[2] = toList(new int[] {14,16,18,20,33,40});
        int[] expected = {1,1,2,3,5,7,8,9,10,13,14,14,15,16,16,16,18,20,33,40};
        ListNode merged = new Solution().mergeKLists(lists);
        assertListEquals(expected, merged);
    }

    private ListNode toList(int[] list) {
        if (list.length==0) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        for (int i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return fakeHead.next;
    }

    public void assertListEquals(int[] expected, ListNode list) {
        for (int i=0; i<expected.length; ++i) {
            if (list==null) {
                assertFalse(true);
                return;
            }
            assertEquals(expected[i], list.val);
            list = list.next;
        }
        assertTrue(list==null);
    }
}
