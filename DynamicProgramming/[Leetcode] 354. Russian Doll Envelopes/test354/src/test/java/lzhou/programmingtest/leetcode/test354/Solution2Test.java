package lzhou.programmingtest.leetcode.test354;

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
    @Parameters(name = "{index}: maxEnvelopes({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{1,1}, {1,1}},1},
                 {new int[][]{{3,2}, {1,2}},1},
                 {new int[][]{{3,2}, {1,1}},2},
                 {new int[][]{{5,4},{6,4},{6,7},{2,3}}, 3},
                 {new int[][]{{1,1},{2,2},{3,3},{4,5}}, 4},
                 {new int[][]{{1,1},{2,2},{3,3},{4,5},{5,4},{4,2}}, 4},
                 {new int[][]{{1,1},{2,2},{3,3},{4,5},{5,4},{4,2},{6,5}}, 5},
           });
    }
    private int[][] envelopes;
    private int expected;

    public Solution2Test(int[][] envelopes, int expected) {
        this.envelopes = envelopes;
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
        int actual = new Solution2().maxEnvelopes(envelopes);
        assertThat(actual, is(expected));
    }
}
