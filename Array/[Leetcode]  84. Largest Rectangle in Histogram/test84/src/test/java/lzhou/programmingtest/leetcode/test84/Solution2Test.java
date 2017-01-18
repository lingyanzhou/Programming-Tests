package lzhou.programmingtest.leetcode.test84;

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
public class Solution2Test {
    @Parameters(name = "{index}: largestRectangleArea({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                {new int[]{1}, 1},
                {new int[]{1,1}, 2},
                {new int[]{1,2}, 2},
                {new int[]{0,9}, 9},
                {new int[]{2,1}, 2},
                {new int[]{2,1,2}, 3},
                {new int[]{2,0,3,0,1,1,1,1,0,1}, 4},
                {new int[]{4,2,0,3,2,5}, 6},
                {new int[]{2,1,5,6,2,3}, 10},
                {new int[]{7, 10, 4, 3, 5, 13, 2, 10}, 18},
                {new int[]{7, 10, 4, 3, 5, 13, 2, 10, 7, 7, 8, 7, 7, 12, 11, 3, 3, 13, 7, 9}, 56},
                {new int[]{7, 10, 4, 3, 5, 13, 2, 10, 7, 7, 8, 7, 7, 12, 11, 3, 3, 13, 7, 9, 11, 1, 1, 6, 0, 5, 10, 12, 0, 3, 1, 8, 3, 2, 12, 10, 9, 2, 6, 2, 10, 3, 9, 13, 4, 12, 1, 11, 12, 13, 12, 10, 9, 6, 0, 9, 10, 1, 10, 6, 0, 1, 9, 2, 12, 10, 11, 9, 13, 0, 7, 5, 9, 12, 10, 7, 2, 4, 10, 7, 12, 7, 10, 5, 2, 6, 1, 4, 0, 13, 3, 3, 1, 0, 3, 2, 8, 5, 8, 12}, 56},
           });
    }
    private int[] heights;
    private int expected;

    public Solution2Test(int[] heights, int expected) {
        this.heights = heights;
        this.expected = expected;
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
        int actual = new Solution2().largestRectangleArea(heights);
        assertThat(actual, is(expected));
    }
}
