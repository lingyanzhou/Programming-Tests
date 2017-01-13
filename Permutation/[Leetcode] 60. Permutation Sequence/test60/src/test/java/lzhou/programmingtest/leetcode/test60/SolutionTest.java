package lzhou.programmingtest.leetcode.test60;

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
    public void test_n1_k1() {
        int n=1;
        int k=1;
        String expected = "1";
        String actual = new Solution().getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test_k1() {
        int n=3;
        int k=1;
        String expected = "123";
        String actual = new Solution().getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test_last_k_2() {
        int n=4;
        int k=24;
        String expected = "4321";
        String actual = new Solution().getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test_large_k() {
        int n=9;
        int k=15120;
        String expected = "149876532";
        String actual = new Solution().getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test_large_k_2() {
        int n=8;
        int k=40000;
        String expected = "87425361";
        String actual = new Solution().getPermutation(n, k);
        assertEquals(expected, actual);
    }
}
