package lzhou.programmingtest.leetcode.test124;

import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.rules.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

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
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-5);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(2);
        root.left.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(-4);
        root.left.right.right = new TreeNode(2);
        int actual = new Solution().maxPathSum(root);
        assertThat(actual, is(12));
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(-20);
        root.left.right = new TreeNode(-31);
        root.left.right.left = new TreeNode(-24);
        root.left.right.right = new TreeNode(-5);
        root.left.right.right.left = new TreeNode(-6);
        root.left.right.right.right = new TreeNode(-7);
        root.left.right.right.left.left = new TreeNode(-8);
        root.left.right.right.left.right = new TreeNode(-9);
        int actual = new Solution().maxPathSum(root);
        assertThat(actual, is(-5));
    }
}
