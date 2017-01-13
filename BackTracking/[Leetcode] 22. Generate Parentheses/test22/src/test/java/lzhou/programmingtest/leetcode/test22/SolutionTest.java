package lzhou.programmingtest.leetcode.test22;

import java.util.*;
import org.junit.*;
import org.junit.rules.*;
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
    public void test_n1() {
        int n = 1;
        String[] expected = {"()"};
        List<String> actual = new Solution().generateParenthesis(n);
        assertThat(actual, hasSize(1));
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void test_n5() {
        int n = 3;
        String[] expected = {"((()))",
                            "(()())",
                            "(())()",
                            "()(())",
                            "()()()"};
        List<String> actual = new Solution().generateParenthesis(n);
        assertThat(actual, hasSize(5));
        assertThat(actual, containsInAnyOrder(expected));
    }
}
