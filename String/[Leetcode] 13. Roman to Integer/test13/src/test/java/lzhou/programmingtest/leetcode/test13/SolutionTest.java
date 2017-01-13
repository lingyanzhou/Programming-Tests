package lzhou.programmingtest.leetcode.test13;

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
        String a = "I";
        int expected = 1;
        assertEquals(expected, new Solution().romanToInt(a));
    }

    @Test
    public void test_6() {
        String a = "VI";
        int expected = 6;
        assertEquals(expected, new Solution().romanToInt(a));
    }

    @Test
    public void test_9() {
        String a = "IX";
        int expected = 9;
        assertEquals(expected, new Solution().romanToInt(a));
    }

    @Test
    public void test_13() {
        String a = "XIII";
        int expected = 13;
        assertEquals(expected, new Solution().romanToInt(a));
    }

    @Test
    public void test_C() {
        String a = "XCIX";
        int expected = 99;
        assertEquals(expected, new Solution().romanToInt(a));
    }

    @Test
    public void test_D() {
        String a = "DCXXI";
        int expected = 621;
        assertEquals(expected, new Solution().romanToInt(a));
    }
}
