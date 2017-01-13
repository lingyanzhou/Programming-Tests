package lzhou.programmingtest.leetcode.test167;

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
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0,1};
        int[] actual = new Solution().twoSum(numbers, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_2() {
        int[] numbers = {2, 7, 11, 15};
        int target = 18;
        int[] expected = {1,2};
        int[] actual = new Solution().twoSum(numbers, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_3() {
        int[] numbers = {2, 7, 11, 15};
        int target = 22;
        int[] expected = {1,3};
        int[] actual = new Solution().twoSum(numbers, target);
        assertArrayEquals(expected, actual);
    }
}
