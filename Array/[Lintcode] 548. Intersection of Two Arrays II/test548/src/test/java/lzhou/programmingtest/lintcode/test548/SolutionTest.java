package lzhou.programmingtest.lintcode.test548;

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
    public Timeout globalTimeout = Timeout.millis(20);
    
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
    public void test_method_emptyset1() {
        int[] nums1 = {};
        int[] nums2 = {};
        int[] expected = {};
        int[] actual = new Solution().intersection(nums1, nums2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_method_emptyset2() {
        int[] nums1 = {1,2,3};
        int[] nums2 = {5,6,7};
        int[] expected = {};
        int[] actual = new Solution().intersection(nums1, nums2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_method_smallset1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {3,2,4,2,5,3};
        int[] expected = {2,2};
        int[] actual = new Solution().intersection(nums1, nums2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_method_smallset2() {
        int[] nums1 = {1,2,2,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] nums2 = {3,2,4,2,5,3,1,1,1,1,1,1,1,1,1,1,1};
        int[] expected = {1,1,1,1,1,1,1,1,1,1,1,2,2};
        int[] actual = new Solution().intersection(nums1, nums2);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void test_method_largeset2() {
        int[] nums1 = {9, 2, 6, 10, 6, 2, 7, 3, 4, 0, 10, 1, 5, 8, 3, 4, 9, 1, 10, 4, 6, 9, 1, 9, 6, 3, 0, 9, 0, 4, 8, 0, 6, 6, 0, 8, 7, 8, 1, 4, 5, 0, 8, 0, 4, 10, 2, 0, 1, 10, 9, 2, 5, 0, 6, 1, 10, 3, 4, 2, 6, 1, 9, 7, 3, 10, 6, 8, 8, 10, 6, 1, 8, 8, 0, 8, 9, 6, 9, 9, 1, 3, 7, 1, 7, 6, 3, 3, 10, 3, 0, 3, 9, 2, 9, 4, 5, 9, 1, 5, 4, 9, 0, 2, 10, 1, 3, 6, 1, 8, 10, 9, 7, 1, 4, 0, 7, 3, 4, 3, 2, 5, 5, 2, 5, 2, 4, 0, 0, 4, 4, 2, 2, 1, 2, 6, 0, 7, 3, 3, 7, 9, 0, 6, 1, 4, 6, 4, 4, 8, 8, 4, 10, 4, 1, 3, 3, 2, 10, 9, 1, 7, 2, 7, 2, 3, 4, 6, 10, 2, 10, 4, 5, 10, 0, 7, 5, 7, 5, 10, 6, 5, 0, 8, 1, 0, 10, 9, 3, 0, 6, 6, 4, 8, 10, 10, 4, 2, 4, 2};
        int[] nums2 = {13, 9, 6, 9, 6, 13, 12, 8, 5, 13, 6, 12, 11, 5, 13, 7, 13, 8, 9, 11, 4, 5, 9, 10, 3, 8, 4, 11, 3, 9, 7, 8, 9, 5, 13, 6, 11, 9, 7, 3, 4, 12, 11, 13, 13, 3, 7, 12, 9, 11, 10, 12, 6, 10, 5, 8, 4, 6, 12, 11, 9, 12, 7, 3, 8, 7, 5, 3, 10, 11, 13, 9, 4, 10, 4, 5, 12, 4, 5, 6, 8, 7, 6, 5, 12, 7, 7, 6, 6, 10, 7, 12, 9, 5, 10, 10, 9, 4, 10, 8, 8, 11, 13, 9, 5, 4, 5, 9, 10, 6, 4, 4, 10, 10, 4, 12, 7, 6, 3, 3, 13, 6, 12, 12, 3, 7, 12, 7, 6, 6, 3, 6, 6, 5, 7, 7, 5, 3, 5, 12, 5, 13, 11, 11, 13, 11, 13, 8, 3, 9, 6, 10, 5, 5, 6, 7, 5, 7, 13, 4, 5, 11, 12, 9, 4, 7, 5, 9, 7, 11, 3, 8, 10, 9, 13, 6, 11, 12, 3, 12, 5, 3, 3, 6, 9, 5, 4, 11, 8, 5, 4, 12, 9, 12, 13, 9, 7, 5, 8, 13};
        int[] expected = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] actual = new Solution().intersection(nums1, nums2);
        assertArrayEquals(expected, actual);
    }
}
