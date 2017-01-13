package lzhou.programmingtest.leetcode.test372;

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
    public Timeout globalTimeout = Timeout.millis(10);
    
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
    public void test_method_zero_a_b() {
        int a = 0;
        int[] b = {0};
        int expected= 0;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void test_method_zero_a() {
        int a = 0;
        int[] b = {1,3};
        int expected= 0;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void test_method_zero_b() {
        int a = 3;
        int[] b = {0};
        int expected= 1;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void test_method_a_1() {
        int a = 1;
        int[] b = {9,9,3,2,4};
        int expected= 1;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void test_method_tiny_a_b() {
        int a = 2;
        int[] b = {4};
        int expected= 16;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void test_method_small_a_b() {
        int a = 23;
        int[] b = {9};
        int expected= 841;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void test_method_median_a_b() {
        int a = 55;
        int[] b = {9,0,3};
        int expected= 734;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void test_method_large_a_b() {
        int a = 512035;
        int[] b = {4, 4, 5, 2, 3, 2, 3, 7, 9, 4, 3, 8, 9, 8, 7, 3, 8, 10, 7, 6, 5, 7, 4, 4, 9, 2, 5, 4, 10, 0, 9, 9, 1, 7, 8, 2, 6, 4, 5, 0, 8, 2, 3, 10, 3, 0, 10, 6, 5, 2, 0, 2, 3, 2, 2, 10, 10, 0, 9, 7, 8, 4, 4, 5, 6, 9, 2, 7, 8, 5, 6, 0, 6, 9, 2, 8, 7, 5, 5, 6, 6, 7, 7, 9, 6, 8, 10, 2, 1, 2, 1, 10, 10, 6, 4, 0, 0, 8, 1, 0, 0, 7, 3, 4, 9, 5, 9, 4, 7, 9, 6, 6, 7, 6, 5, 0, 3, 0, 8, 4, 7, 10, 10, 3, 0, 6, 7, 7, 0, 0, 10, 9, 7, 4, 3, 2, 10, 8, 3, 7, 5, 2, 1, 1, 5, 3, 7, 6, 4, 3, 6, 0, 2, 10, 3, 9, 7, 10, 0, 7, 2, 2, 10, 4, 4, 8, 6, 8, 10, 9, 5, 8, 8, 6, 2, 3, 1, 7, 5, 4, 3, 6, 3, 8, 4, 7, 6, 9, 3, 1, 6, 0, 1, 1, 1, 1, 5, 8, 6, 7};
        int expected= 41;
        int actual = new Solution().superPow(a, b);
        assertEquals(expected, actual);
    }
}
