package lzhou.programmingtest.leetcode.test11;

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
    @Parameters(name = "{index}: maxArea({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(new Integer[]{2}), 0},
                 {Arrays.asList(new Integer[]{1,3}), 1},
                 {Arrays.asList(new Integer[]{1,3,2}), 2},
                 {Arrays.asList(new Integer[]{3,2,1}), 2},
                 {Arrays.asList(new Integer[]{3,1,2}), 4},
                 {Arrays.asList(new Integer[]{4,5,3,1,2}), 8},
                 {Arrays.asList(new Integer[]{1,1,1,1}), 3},
                 {Arrays.asList(new Integer[]{1,5,1,1}), 3},
                 {Arrays.asList(new Integer[]{1,1,5,2}), 3},
                 {Arrays.asList(new Integer[]{9, 5, 8, 10, 7, 10, 0, 1, 3, 4}), 45},
           });
    }
    private int[] heights;
    private int expected;

    public SolutionTest(List<Integer> heights, int expected) {
        this.heights = new int[heights.size()];
        for (int i=0; i<heights.size(); ++i) {
            this.heights[i] = heights.get(i);
        }
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
        int actual = new Solution().maxArea(heights);
        assertThat(actual, is(expected));
    }
}
