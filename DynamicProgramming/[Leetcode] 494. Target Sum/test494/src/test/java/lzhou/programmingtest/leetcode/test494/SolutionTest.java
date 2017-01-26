package lzhou.programmingtest.leetcode.test494;

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
    @Parameters(name = "{index}: findTargetSumWays({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1}, 1, 1},
                 {new int[]{1}, -1, 1},
                 {new int[]{1}, 0, 0},
                 {new int[]{1,1}, 3, 0},
                 {new int[]{1,1}, 2, 1},
                 {new int[]{1,1}, 1, 0},
                 {new int[]{1,1}, 0, 2},
                 {new int[]{1,1}, -1, 0},
                 {new int[]{1,1}, -2, 1},
                 {new int[]{1,1}, -3, 0},
                 {new int[]{1,1,1,1,1}, 3, 5},
                 {new int[]{8,-2,3,5,-3,1,2}, 0, 6},
           });
    }
    private int[] nums;
    private int S;
    private int expected;

    public SolutionTest(int[] nums, int S, int expected) {
        this.nums = nums;
        this.S = S;
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
        int actual = new Solution().findTargetSumWays(nums, S);
        assertThat(actual, is(expected));
    }
}
