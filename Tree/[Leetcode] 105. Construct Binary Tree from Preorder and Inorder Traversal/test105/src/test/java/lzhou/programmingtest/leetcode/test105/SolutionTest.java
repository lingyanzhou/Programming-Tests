package lzhou.programmingtest.leetcode.test105;

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
@RunWith(Parameterized.class)
public class SolutionTest {
    @Parameters(name = "{index}: buildTree({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1}, new int[]{1}, new Integer[]{1}, new Integer[]{1}},
                 {new int[]{1,2}, new int[]{1,2}, new Integer[]{1,2}, new Integer[]{1,2}},
                 {new int[]{1,2,3}, new int[]{1,2,3}, new Integer[]{1,2,3}, new Integer[]{1,2,3}},
                 {new int[]{3,2,1}, new int[]{1,2,3}, new Integer[]{3,2,1}, new Integer[]{1,2,3}},
                 {new int[]{5,4,3,2,1}, new int[]{5,4,3,2,1}, new Integer[]{5,4,3,2,1}, new Integer[]{5,4,3,2,1}},
                 {new int[]{0,1,2,3,4,5,6}, new int[]{0,2,1,4,6,5,3}, new Integer[]{0,1,2,3,4,5,6}, new Integer[]{0,2,1,4,6,5,3}},
           });
    }
    private int[] inorder;
    private int[] preorder;
    private Integer[] expectedInorder;
    private Integer[] expectedPreorder;

    public SolutionTest(int[] preorder, int[] inorder, Integer[] expectedPreorder, Integer[] expectedInorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        this.expectedInorder = expectedInorder;
        this.expectedPreorder = expectedPreorder;
    }
    
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
    public void test() {
        TreeNode actual = new Solution().buildTree(preorder, inorder);
        assertThat(inorderTraversal(actual), contains(expectedInorder));
        assertThat(preorderTraversal(actual), contains(expectedPreorder));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root==null) {
            return ret;
        }
        
        if (root.left!=null)
            ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        if (root.right!=null)
            ret.addAll(inorderTraversal(root.right));
        return ret;
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root==null) {
            return ret;
        }
        
        ret.add(root.val);
        if (root.left!=null)
            ret.addAll(preorderTraversal(root.left));
        if (root.right!=null)
            ret.addAll(preorderTraversal(root.right));
        return ret;
    }
}
