package lzhou.programmingtest.leetcode.test378;

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
    public void test_i0_j0() {
        int[][] matrix={{1,2},{2,3}};
        int k=1;
        int expected = 1;
        int actual= new Solution().kthSmallest(matrix, k);
    }

    @Test
    public void test_i0() {
        int[][] matrix={{1,4},{2,3}};
        int k=4;
        int expected = 4;
        int actual= new Solution().kthSmallest(matrix, k);
    }

    @Test
    public void test_i0_2() {
        int[][] matrix={{1,2},{3,4}};
        int k=2;
        int expected = 2;
        int actual= new Solution().kthSmallest(matrix, k);
    }

    @Test
    public void test_dup() {
        int[][] matrix={{2,5,5},{2,5,6},{2,6,6}};
        int k=3;
        int expected = 2;
        int actual= new Solution().kthSmallest(matrix, k);
    }

    @Test
    public void test_dup2() {
        int[][] matrix={{2,5,5},{2,5,6},{2,6,6}};
        int k=7;
        int expected = 6;
        int actual= new Solution().kthSmallest(matrix, k);
    }

    @Test
    public void test_normal() {
        int[][] matrix={{1,5,9},{10,11,13},{12,13,15}};
        int k=8;
        int expected = 13;
        int actual= new Solution().kthSmallest(matrix, k);
    }

    @Test
    public void test_normal2() {
        int[][] matrix={{1,5,9},{10,11,13},{12,13,15}};
        int k=6;
        int expected = 12;
        int actual= new Solution().kthSmallest(matrix, k);
    }
}
