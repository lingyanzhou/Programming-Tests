package lzhou.programmingtest.leetcode.test464;

import java.util.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class Solution2Test {
    
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
        int[] A={};
        int[] expected = {};
        new Solution2().sortIntegers2(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void test_len1() {
        int[] A={1};
        int[] expected = {1};
        new Solution2().sortIntegers2(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void test_len2() {
        int[] A={2,1};
        int[] expected = {1,2};
        new Solution2().sortIntegers2(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void test_len5() {
        int[] A={6,3,5,1,0};
        int[] expected = {0,1,3,5,6};
        new Solution2().sortIntegers2(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void test_large() {
        int[] A={6, 8, 1, 3, 7, 8, 10, 9, 3, 0, 2, 9, 0, 1, 10, 4, 9, 4, 0, 8, 2, 10, 7, 4, 0, 6, 5, 5, 3, 7, 4, 4, 7, 0, 5, 2, 1, 5, 5, 4, 10, 1, 0, 10, 10, 7, 3, 8, 5, 4, 6, 4, 1, 4, 5, 4, 6, 6, 8, 2, 10, 2, 7, 10, 6, 10, 7, 9, 9, 7, 5, 8, 3, 5, 8, 3, 10, 3, 4, 3, 0, 6, 2, 6, 9, 6, 6, 3, 0, 10, 7, 3, 4, 6, 4, 2, 10, 1, 9, 1, 3, 3, 9, 8, 5, 3, 0, 7, 1, 9, 3, 9, 7, 8, 10, 1, 9, 9, 0, 7, 8, 9, 4, 9, 6, 5, 1, 2, 10, 5, 10, 2, 0, 4, 9, 8, 0, 4, 2, 6, 1, 2, 3, 2, 6, 5, 1, 7, 8, 6, 1, 6, 6, 10, 6, 7, 5, 1, 1, 2, 7, 3, 2, 9, 4, 3, 9, 2, 10, 9, 8, 2, 1, 9, 0, 9, 1, 8, 8, 1, 6, 3, 2, 10, 9, 0, 0, 8, 8, 0, 2, 1, 0, 2, 4, 7, 9, 6, 1, 1};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        new Solution2().sortIntegers2(A);
        assertArrayEquals(expected, A);
    }
}
