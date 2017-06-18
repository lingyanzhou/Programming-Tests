package lzhou.programmingtest.leetcode.test623;

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
    @Test
    public void test_d1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode expected = new TreeNode(0);
        expected.left = new TreeNode(1);
        expected.left.left = new TreeNode(2);
        expected.left.right = new TreeNode(3);

        TreeNode actual = new Solution().addOneRow(root, 0, 1);
        assertTreeEqual(actual, expected);
    }

    @Test
    public void test_d2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(0);
        expected.right = new TreeNode(0);

        expected.left.left = new TreeNode(2);
        expected.right.right = new TreeNode(3);

        TreeNode actual = new Solution().addOneRow(root, 0, 2);
        assertTreeEqual(actual, expected);
    }

    private static void assertTreeEqual(TreeNode t1, TreeNode t2) {
        if (t1!=null && t2!=null) {
            assertEquals(t1.val, t2.val);
        } else if (t1==null && t2==null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
}
