package lzhou.programmingtest.leetcode.test234;

import java.util.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    
    //global timeout rule
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);
    
    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        //System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        //System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        //System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        //System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_empty() {
        ListNode list = toListNode(new int[]{});
        assertTrue(new Solution().isPalindrome(list));
    }

    @Test
    public void test_single() {
        ListNode list = toListNode(new int[]{1});
        assertTrue(new Solution().isPalindrome(list));
    }

    @Test
    public void test_two() {
        ListNode list = toListNode(new int[]{1,1});
        assertTrue(new Solution().isPalindrome(list));
    }

    @Test
    public void test_three() {
        ListNode list = toListNode(new int[]{1,4,1});
        assertTrue(new Solution().isPalindrome(list));
    }

    @Test
    public void test_four() {
        ListNode list = toListNode(new int[]{1,4,4,1});
        assertTrue(new Solution().isPalindrome(list));
    }

    @Test
    public void test_odd() {
        ListNode list = toListNode(new int[]{1,4,4,5,0,1,0,5,4,4,1});
        assertTrue(new Solution().isPalindrome(list));
    }

    @Test
    public void test_even() {
        ListNode list = toListNode(new int[]{0,0,1,4,6,7,7,6,4,1,0,0});
        assertTrue(new Solution().isPalindrome(list));
    }

    @Test
    public void test_two_f() {
        ListNode list = toListNode(new int[]{2,1});
        assertFalse(new Solution().isPalindrome(list));
    }

    @Test
    public void test_three_f() {
        ListNode list = toListNode(new int[]{1,4,2});
        assertFalse(new Solution().isPalindrome(list));
    }

    @Test
    public void test_four_f() {
        ListNode list = toListNode(new int[]{4,4,4,1});
        assertFalse(new Solution().isPalindrome(list));
    }

    @Test
    public void test_odd_f() {
        ListNode list = toListNode(new int[]{1,4,4,5,1,1,0,5,4,4,1});
        assertFalse(new Solution().isPalindrome(list));
    }

    @Test
    public void test_even_f() {
        ListNode list = toListNode(new int[]{0,0,1,4,6,7,1,6,4,1,0,0});
        assertFalse(new Solution().isPalindrome(list));
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
}
