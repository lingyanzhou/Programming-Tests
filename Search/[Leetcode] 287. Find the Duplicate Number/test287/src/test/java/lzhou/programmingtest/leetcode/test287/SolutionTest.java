package lzhou.programmingtest.leetcode.test287;

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
    public void test_n2() {
        int[] nums = {2,1,1};
        int expected = 1;
        int actual= new Solution().findDuplicate(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test_n3() {
        int[] nums = {3,3,2,1};
        int expected = 3;
        int actual= new Solution().findDuplicate(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test_n6() {
        int[] nums = {1,2,3,4,5,3,6};
        int expected = 3;
        int actual= new Solution().findDuplicate(nums);
        assertEquals(expected, actual);
    }
}
