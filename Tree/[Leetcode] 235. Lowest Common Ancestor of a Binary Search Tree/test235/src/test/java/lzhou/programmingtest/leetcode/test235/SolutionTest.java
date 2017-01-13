package lzhou.programmingtest.leetcode.test235;

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
    public void testSolution()
    {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode p=root.left.left;
        TreeNode q=root.right.left;
        TreeNode expected = root;
        Solution sol = new Solution();
        TreeNode actual = sol.lowestCommonAncestor(root, p, q);
        assertEquals(expected, actual);
    }
    public void testSolution2()
    {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode p=root.right.left;
        TreeNode q=root.right;
        TreeNode expected = root.right;
        Solution sol = new Solution();
        TreeNode actual = sol.lowestCommonAncestor(root, p, q);
        assertEquals(expected, actual);
    }
}
