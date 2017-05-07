package lzhou.programmingtest.leetcode.test572;

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
    public void test_no_match() {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
        TreeNode t = new TreeNode(11);
        t.left = new TreeNode(2);
        boolean actual = new Solution().isSubtree(s, t);
        assertThat(actual, is(false));
    }

    @Test
    public void test_partial_match() {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(5);
        boolean actual = new Solution().isSubtree(s, t);
        assertThat(actual, is(false));
    }

    @Test
    public void test_simple_match_l() {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(4);
        boolean actual = new Solution().isSubtree(s, t);
        assertThat(actual, is(true));
    }

    @Test
    public void test_simple_match_r() {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.right.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
        TreeNode t = new TreeNode(3);
        t.right = new TreeNode(3);
        boolean actual = new Solution().isSubtree(s, t);
        assertThat(actual, is(true));
    }

    @Test
    public void test_partial_match_then_full_match() {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.right.right = new TreeNode(1);
        s.right.right.left = new TreeNode(2);
        s.right.right.right = new TreeNode(4);
        s.left.left = new TreeNode(4);
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(4);
        boolean actual = new Solution().isSubtree(s, t);
        assertThat(actual, is(true));
    }
}
