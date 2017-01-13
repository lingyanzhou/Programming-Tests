package lzhou.programmingtest.leetcode.test50;

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
    public Timeout globalTimeout = Timeout.millis(10);
    
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

    static double EPSILON = 0.001;

    @Test
    public void test_method_pow_of_0_to_0() {
        double x = 0;
        int n = 0;
        double expected= 1;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_pow_of_0() {
        double x = 0;
        int n = 2;
        double expected= 0;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_pow_to_0() {
        double x = 2;
        int n = 0;
        double expected= 1;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_neg_pow() {
        double x = 2;
        int n = -5;
        double expected= 0.03125;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_normal() {
        double x = 2;
        int n = 10;
        double expected= 1024;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_double_x() {
        double x = 8.88023;
        int n = 3;
        double expected= 700.281482;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_double_neg() {
        double x = -8.88023;
        int n = -3;
        double expected= -0.0014279972;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_integer_boundary() {
        double x = 0.000001;
        int n = 2147483647;
        double expected= 0;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_neg_integer_boundary() {
        double x = 1.00000;
        int n = -2147483648;
        double expected= 1;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_close_to_1p() {
        double x = 1.00001;
        int n = 123456;
        double expected= 3.436844;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_close_to_1m() {
        double x = 0.9999999;
        int n = 123456;
        double expected= 0.98773;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_close_to_minus1() {
        double x = -1;
        int n = 6;
        double expected= 1;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
    
    @Test
    public void test_method_close_to_minus1_2() {
        double x = -1;
        int n = 3;
        double expected= -1;
        double actual = new Solution().myPow(x, n);
        assertEquals(expected, actual, EPSILON);
    }
}
