package lzhou.programmingtest.lintcode.test56;

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
        int[] numbers = {4,2,4};
        int target = 8;
        int[] expected = {1,3};
        int[] actual = new Solution().twoSum(numbers, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_against_i_eq_j() {
        int[] numbers = {3,2,4};
        int target = 6;
        int[] expected = {2,3};
        int[] actual = new Solution().twoSum(numbers, target);
        assertArrayEquals(expected, actual);
    }
}
