package lzhou.programmingtest.leetcode.test29;

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
    public void test_divide_0() {
        int dd = 0;
        int ds = -2;
        int expected = 0;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }

    @Test
    public void test_divide_by_0() {
        int dd = 3;
        int ds = 0;
        int expected = Integer.MAX_VALUE;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_max_max() {
        int dd = Integer.MAX_VALUE;
        int ds = Integer.MAX_VALUE;
        int expected = 1;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_min_min() {
        int dd = Integer.MIN_VALUE;
        int ds = Integer.MIN_VALUE;
        int expected = 1;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_min_1() {
        int dd = Integer.MIN_VALUE;
        int ds = 1;
        int expected = Integer.MIN_VALUE;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_max_1() {
        int dd = Integer.MAX_VALUE;
        int ds = 1;
        int expected = Integer.MAX_VALUE;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_min_n1() {
        int dd = Integer.MIN_VALUE;
        int ds = -1;
        int expected = Integer.MAX_VALUE;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_max_n1() {
        int dd = Integer.MAX_VALUE;
        int ds = -1;
        int expected = -Integer.MAX_VALUE;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_to_0_1() {
        int dd = 3;
        int ds = 4;
        int expected = 0;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_to_0_2() {
        int dd = -2312;
        int ds = 12214124;
        int expected = 0;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_perfect() {
        int dd = -6;
        int ds = 3;
        int expected = -2;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_floor() {
        int dd = -11;
        int ds = Integer.MIN_VALUE;
        int expected = 0;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_p_n() {
        int dd = 11;
        int ds = -2;
        int expected = -5;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_n_p() {
        int dd = -121;
        int ds = 11;
        int expected = -11;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_divide_n_n() {
        int dd = -192838;
        int ds = -1188;
        int expected = 162;
        int actual = new Solution().divide(dd, ds);
        assertEquals(expected, actual);
    }
}
