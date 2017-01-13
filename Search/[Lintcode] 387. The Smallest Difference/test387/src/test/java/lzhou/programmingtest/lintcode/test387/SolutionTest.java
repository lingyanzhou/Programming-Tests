package lzhou.programmingtest.lintcode.test387;

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
    public void test_interlaced() {
        int[] A= {3,6,7,4};
        int[] B= {5,8,9,2};
        int expected = 1;
        int actual = new Solution().smallestDifference(A, B);
        assertEquals(expected, actual);
    }

    @Test
    public void test_B_across_A() {
        int[] A= {3,4,6,7};
        int[] B= {-10,20,22};
        int expected = 13;
        int actual = new Solution().smallestDifference(A, B);
        assertEquals(expected, actual);
    }

    @Test
    public void test_same() {
        int[] A= {10,9,2,3,6};
        int[] B= {9,2,6,3,10};
        int expected = 0;
        int actual = new Solution().smallestDifference(A, B);
        assertEquals(expected, actual);
    }

    @Test
    public void test_diff0() {
        int[] A= {10,32,69,9,0,-10};
        int[] B= {9,100,30,-9};
        int expected = 0;
        int actual = new Solution().smallestDifference(A, B);
        assertEquals(expected, actual);
    }

    @Test
    public void test_a_across_b() {
        int[] A= {10,-10};
        int[] B= {6,5,2,3};
        int expected = 4;
        int actual = new Solution().smallestDifference(A, B);
        assertEquals(expected, actual);
    }

    @Test
    public void test_a_before_b() {
        int[] A= {10,-10};
        int[] B= {300,500,200,100};
        int expected = 90;
        int actual = new Solution().smallestDifference(A, B);
        assertEquals(expected, actual);
    }
}
