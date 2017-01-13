package lzhou.programmingtest.lintcode.test39;

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
    public void test_no_rotate()
    {
        int[] nums = {0,1};
        int[] expected = {0,1};
        Solution sol = new Solution();
        sol.recoverRotatedSortedArray(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test_1_element()
    {
        int[] nums = {0};
        int[] expected  = {0};
        Solution sol = new Solution();
        sol.recoverRotatedSortedArray(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test_k_lt_n()
    {
        int[] nums  = {3,4,5,1,2};
        int[] expected  = {1,2,3,4,5};
        Solution sol = new Solution();
        sol.recoverRotatedSortedArray(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test_k_eq_n()
    {
        int[] nums = {1,2,3,4,5};
        int[] expected  = {1,2,3,4,5};
        Solution sol = new Solution();
        sol.recoverRotatedSortedArray(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test_k_gt_n()
    {
        int[] nums = {4,5,1,2,3};
        int[] expected  = {1,2,3,4,5};
        Solution sol = new Solution();
        sol.recoverRotatedSortedArray(nums);
        assertArrayEquals(expected, nums);
    }
}
