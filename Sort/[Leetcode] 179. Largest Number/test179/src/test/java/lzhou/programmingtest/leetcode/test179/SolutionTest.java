package lzhou.programmingtest.leetcode.test179;

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
    public void test_00() {
        int[] num = {0,0};
        String expected = "0";
        String actual = new Solution().largestNumber(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test_lsb_larger() {
        int[] num = {9,900,990,909,911,9002};
        String expected = "99909119099009002";
        String actual = new Solution().largestNumber(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test_lsb_smaller() {
        int[] num = {1,11,12,123};
        String expected = "12312111";
        String actual = new Solution().largestNumber(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test_lsb_mixed() {
        int[] num = {9,90,99,990,909,5,6,2,4,23,54,721,231,11,12,123};
        String expected = "99999090990721655442323121231211";
        String actual = new Solution().largestNumber(num);
        assertEquals(expected, actual);
    }
}
