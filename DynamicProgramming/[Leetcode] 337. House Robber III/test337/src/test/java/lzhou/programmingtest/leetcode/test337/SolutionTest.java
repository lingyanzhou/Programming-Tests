package lzhou.programmingtest.leetcode.test337;

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
    public Timeout globalTimeout = Timeout.millis(5);
    
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
    public void test_null() {
        TreeNode root = null;
        int expected = 0;
        int actual = new Solution().rob(root);
        assertEquals(expected, actual);
    }

    @Test
    public void test_root_only() {
        TreeNode root = new TreeNode(1);
        int expected = 1;
        int actual = new Solution().rob(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_skip_root() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        int expected = 6;
        int actual = new Solution().rob(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_noskip_root() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        int expected = 7;
        int actual = new Solution().rob(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_noskip_2() {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(100);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(100);
        int expected = 300;
        int actual = new Solution().rob(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_skip_3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(100);
        root.left.left = new TreeNode(100);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(100);
        int expected = 300;
        int actual = new Solution().rob(root);
        assertEquals(expected, actual);
    }
}
