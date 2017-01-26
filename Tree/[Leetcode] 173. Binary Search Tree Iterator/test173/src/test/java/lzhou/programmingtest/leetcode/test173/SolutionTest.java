package lzhou.programmingtest.leetcode.test173;

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
    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-10);
        root.left.right = new TreeNode(-5);
        root.left.right.left = new TreeNode(-8);
        root.left.right.right = new TreeNode(-3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        
        BSTIterator iter = new BSTIterator(root);
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(-10));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(-8));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(-5));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(-3));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(4));
        assertThat(iter.hasNext(), is(false));
    }
}
