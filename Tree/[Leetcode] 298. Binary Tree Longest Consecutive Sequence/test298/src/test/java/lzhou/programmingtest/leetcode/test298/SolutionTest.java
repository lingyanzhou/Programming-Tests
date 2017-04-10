package lzhou.programmingtest.leetcode.test298;

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
    public void test_root_only() {
        TreeNode root = new TreeNode(0);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(1));
    }

    @Test
    public void test_conseq_1() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(1));
    }

    @Test
    public void test_root_l_len_2() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(2));
    }

    @Test
    public void test_root_lr_len_3() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(1);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(3));
    }

    @Test
    public void test_root_rlr_len_4() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(3);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(4));
    }

    @Test
    public void test_nonroot_rlr_len_3() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(3));
    }

    @Test
    public void test_dup_len_3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(3);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.left.left = new TreeNode(2);
        root.right.left.right.left.left.right = new TreeNode(3);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(3));
    }

    @Test
    public void test_reverse() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(2);
        root.right.left.right.left = new TreeNode(1);
        int actual = new Solution().longestConsecutive(root);
        assertThat(actual, is(1));
    }
}
