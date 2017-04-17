package lzhou.programmingtest.leetcode.test545;

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
    	Integer[] expected = new Integer[]{1};
    	TreeNode root = new TreeNode(1);
        List<Integer> actual = new Solution().boundaryOfBinaryTree(root);
        assertThat(actual.toString(), actual, contains(expected));
    }
    
    @Test
    public void test_no_left_boundary() {
    	Integer[] expected = new Integer[]{1,3,4,2};
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);
    	root.right.left = new TreeNode(3);
    	root.right.right = new TreeNode(4);
        List<Integer> actual = new Solution().boundaryOfBinaryTree(root);
        assertThat(actual.toString(), actual, contains(expected));
    }
    
    @Test
    public void test_no_right_boundary() {
    	Integer[] expected = new Integer[]{1,2,3,4};
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(3);
    	root.left.right = new TreeNode(4);
        List<Integer> actual = new Solution().boundaryOfBinaryTree(root);
        assertThat(actual.toString(), actual, contains(expected));
    }
    
    @Test
    public void test_both_boundary_h_1() {
    	Integer[] expected = new Integer[]{1, 2, 3};
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
        List<Integer> actual = new Solution().boundaryOfBinaryTree(root);
        assertThat(actual.toString(), actual, contains(expected));
    }
    
    @Test
    public void test_both_boundary_h_4() {
    	Integer[] expected = new Integer[]{1,2,4,8,9,10,11,7,3};
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	root.left.right.left = new TreeNode(8);
    	root.right.left.left = new TreeNode(9);
    	root.right.right.left = new TreeNode(10);
    	root.right.right.right = new TreeNode(11);
        List<Integer> actual = new Solution().boundaryOfBinaryTree(root);
        assertThat(actual.toString(), actual, contains(expected));
    }
}
