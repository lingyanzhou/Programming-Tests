package lzhou.programmingtest.leetcode.test236;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;
/**
 * Unit test for simple App.
 */
public class SolutionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SolutionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SolutionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSolution1()
    {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(1);
        TreeNode A=root;
        TreeNode B=root.right;
        TreeNode expected = root;
        Solution sol = new Solution();
        TreeNode actual = sol.lowestCommonAncestor(root, A, B);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode A=root.right.left;
        TreeNode B=root.right;
        TreeNode expected = root.right;
        Solution sol = new Solution();
        TreeNode actual = sol.lowestCommonAncestor(root, A, B);
        assertEquals(expected, actual);
    }
    public void testSolution3()
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode p=root.left.left;
        TreeNode q=root.right.left;
        TreeNode expected = root;
        Solution sol = new Solution();
        TreeNode actual = sol.lowestCommonAncestor(root, p, q);
        assertEquals(expected, actual);
    }
    public void testSolution4()
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode A=root.left.right.left;
        TreeNode B=root.left.right.right;
        TreeNode expected = root.left.right;
        Solution sol = new Solution();
        TreeNode actual = sol.lowestCommonAncestor(root, A, B);
        assertEquals(expected, actual);
    }
}
