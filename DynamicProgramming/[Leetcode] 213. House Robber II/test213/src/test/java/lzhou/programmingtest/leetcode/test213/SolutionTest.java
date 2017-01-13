package lzhou.programmingtest.leetcode.test213;

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
        int[] houses = {};
        int expected = 0;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len1() {
        int[] houses = {1};
        int expected = 1;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len2_1() {
        int[] houses = {2,1};
        int expected = 2;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len2_2() {
        int[] houses = {1,2};
        int expected = 2;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len3_1() {
        int[] houses = {1,3,1};
        int expected = 3;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len3_2() {
        int[] houses = {2,3,2};
        int expected = 3;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len4_1() {
        int[] houses = {2,4,2,1};
        int expected = 5;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len4_2() {
        int[] houses = {2,4,4,1};
        int expected = 6;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }

    @Test
    public void test_largeset() {
        int[] houses = {11, 9, 11, 6, 11, 13, 12, 7, 12, 3, 6, 12, 8, 9, 9, 8, 10, 4, 6, 12, 12, 10, 13, 10, 7, 3, 5, 5, 12, 3, 9, 13, 4, 9, 7, 8, 5, 12, 9, 10, 12, 10, 5, 13, 3, 11, 4, 5, 12, 7, 13, 10, 7, 6, 7, 4, 9, 11, 3, 8, 8, 6, 6, 7, 12, 12, 12, 12, 8, 12, 4, 8, 5, 3, 12, 5, 8, 6, 9, 7, 10, 5, 13, 8, 8, 6, 9, 5, 10, 6, 6, 11, 6, 5, 7, 7, 3, 10, 3, 13, 3, 11, 9, 12, 6, 9, 10, 7, 4, 11, 8, 4, 3, 4, 11, 7, 4, 9, 13, 12, 13, 3, 3, 9, 6, 12, 13, 11, 8, 10, 9, 9, 3, 11, 11, 3, 7, 12, 11, 9, 3, 9, 7, 12, 11, 13, 5, 8, 6, 10, 11, 5, 10, 5, 7, 8, 5, 10, 11, 7, 11, 4, 12, 8, 3, 8, 7, 4, 13, 4, 5, 12, 4, 3, 3, 6, 4, 12, 6, 11, 13, 9, 13, 7, 9, 5, 9, 13, 5, 5, 13, 4, 4, 3, 7, 12, 12, 9, 10, 9};
        int expected = 912;
        int actual = new Solution().rob(houses);
        assertEquals(expected, actual);
    }
}
