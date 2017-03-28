package lzhou.programmingtest.leetcode.test538;

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
        TreeNode root = new TreeNode(1);
        TreeNode actual = new Solution().convertBST(root);
        assertThat(actual.val, is(1));
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        TreeNode actual = new Solution().convertBST(root);
        assertThat(actual.val, is(3));
        assertThat(actual.right.val, is(2));
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        TreeNode actual = new Solution().convertBST(root);
        assertThat(actual.val, is(2));
        assertThat(actual.left.val, is(3));
    }

    @Test
    public void test_4() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode actual = new Solution().convertBST(root);
        assertThat(actual.val, is(5));
        assertThat(actual.left.val, is(6));
        assertThat(actual.right.val, is(3));
    }

    @Test
    public void test_5() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        TreeNode actual = new Solution().convertBST(root);
        assertThat(actual.val, is(9));
        assertThat(actual.left.val, is(10));
        assertThat(actual.right.val, is(7));
        assertThat(actual.right.right.val, is(4));
    }
}
