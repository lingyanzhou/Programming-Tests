package lzhou.programmingtest.leetcode.test573;

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
    @Parameters(name = "{index}: minDistance({0}, {1}, {2}, {3}, {4})={5}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {5,
                    7,
                    new int[]{2,2},
                    new int[]{4,4},
                    new int[][]{{3,0}, {2,5}},
                    12},
                 {10,
                    10,
                    new int[]{4,5},
                    new int[]{1,2},
                    new int[][]{{3,0}, {2,5}, {5,1}},
                    24},
                 {10,
                    10,
                    new int[]{4,9},
                    new int[]{1,2},
                    new int[][]{{3,0}, {2,5}, {5,1},{9,1},{3,8},{7,2}},
                    94},
           });
    }
    private int height;
    private int width;
    private int[] tree;
    private int[] squirrel;
    private int[][] nuts;
    private int expected;

    public SolutionTest(int height, int width, int[] tree, int[] squirrel, int[][] nuts, int expected) {
        this.height = height;
        this.width = width;
        this.tree = tree;
        this.squirrel = squirrel;
        this.nuts = nuts;
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
        int actual = new Solution().minDistance(height, width, tree, squirrel, nuts);
        assertThat(actual, is(expected));
    }
}
