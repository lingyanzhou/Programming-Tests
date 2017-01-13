package lzhou.programmingtest.leetcode.test107;

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
    public void testSolutionSingle()
    {
        TreeNode root = new TreeNode(6);
        List<List<Integer>> expected = to2DList(new int[][]{{6}});
        Solution sol = new Solution();
        List<List<Integer>> actual = sol.levelOrder(root);
        assert2DArrayListEquals(expected, actual);
    }
    public void testSolutionSingleRight()
    {
        TreeNode root = new TreeNode(6);
        root.right = new  TreeNode(3);
        List<List<Integer>> expected = to2DList(new int[][]{{3},{6}});
        Solution sol = new Solution();
        List<List<Integer>> actual = sol.levelOrder(root);
        assert2DArrayListEquals(expected, actual);
    }
    public void testSolutionSingleLeft()
    {
        TreeNode root = new TreeNode(6);
        root.left = new  TreeNode(1);
        List<List<Integer>> expected = to2DList(new int[][]{{1},{6}});
        Solution sol = new Solution();
        List<List<Integer>> actual = sol.levelOrder(root);
        assert2DArrayListEquals(expected, actual);
    }
    public void testSolutionLeftAndRight()
    {
        TreeNode root = new TreeNode(6);
        root.left = new  TreeNode(1);
        root.right = new  TreeNode(2);
        List<List<Integer>> expected = to2DList(new int[][]{{1,2},{6}});
        Solution sol = new Solution();
        List<List<Integer>> actual = sol.levelOrder(root);
        assert2DArrayListEquals(expected, actual);
    }
    public void testSolutionLargeTree()
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
        List<List<Integer>> expected = to2DList(new int[][]{{3,5},{0,4,7,9},{2,8},{6}});
        Solution sol = new Solution();
        List<List<Integer>> actual = sol.levelOrder(root);
        assert2DArrayListEquals(expected, actual);
    }

    private List<List<Integer>> to2DList(int[][] in) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>(in.length);
        for (int i=0; i<in.length; ++i) {
            List<Integer> list = new ArrayList<Integer>(in[i].length);
            for (int j=0; j<in[i].length; ++j) {
                list.add(in[i][j]);
            }
            ret.add(list);
        }
        return ret;
    }
    
    private void assert2DArrayListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i).size(), actual.get(i).size());
            for (int j=0; j<expected.get(i).size(); ++j) {
                assertEquals(expected.get(i).get(j), actual.get(i).get(j));
            }
        }
    }
}
