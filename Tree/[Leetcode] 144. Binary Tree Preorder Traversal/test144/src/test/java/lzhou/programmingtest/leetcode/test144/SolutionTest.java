package lzhou.programmingtest.leetcode.test144;

import java.util.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        List<Integer> expected = toArrayList(new int[]{0,1,2});
        List<Integer> actual = new Solution().preorderTraversal(root);
        assertArrayListEquals( expected, actual );
    }
    
    public void testSolution2()
    {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        List<Integer> expected = toArrayList(new int[]{0,1,2,3,4});
        List<Integer> actual = new Solution().preorderTraversal(root);
        assertArrayListEquals( expected, actual );
    }
    
    public void testSolution3()
    {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        List<Integer> expected = toArrayList(new int[]{0,1,2,4,5,6});
        List<Integer> actual = new Solution().preorderTraversal(root);
        assertArrayListEquals( expected, actual );
    }
    

    private List<Integer> toArrayList(int[] in) {
        List<Integer> ret = new ArrayList<Integer>(in.length);
        for (int i=0; i<in.length; ++i) {
            ret.add(in[i]);
        }
        return ret;
    }
    
    private void assertArrayListEquals(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
