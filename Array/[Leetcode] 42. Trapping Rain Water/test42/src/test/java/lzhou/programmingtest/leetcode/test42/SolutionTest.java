package lzhou.programmingtest.leetcode.test42;

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
    public void test_1() {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        int actual = new Solution().trapRainWater(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test_2() {
        int[] heights = {0,4,2,3,5,1,2,3,9,9,9,2,3,2,1,1,2,2,0,0,1};
        int expected = 17;
        int actual = new Solution().trapRainWater(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len1() {
        int[] heights = {1};
        int expected = 0;
        int actual = new Solution().trapRainWater(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len2() {
        int[] heights = {0,1};
        int expected = 0;
        int actual = new Solution().trapRainWater(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test_len3() {
        int[] heights = {0,1,0};
        int expected = 0;
        int actual = new Solution().trapRainWater(heights);
        assertEquals(expected, actual);
    }
}
