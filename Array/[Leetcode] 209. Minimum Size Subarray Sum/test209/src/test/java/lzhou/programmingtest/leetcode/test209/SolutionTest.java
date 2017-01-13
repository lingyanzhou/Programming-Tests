package lzhou.programmingtest.leetcode.test209;

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
    @Parameters(name = "{index}: minSubArrayLen({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {2, new int[]{1,0,1,0,1}, 3},
                 {2, new int[]{1,0,1,1,0}, 2},
                 {2, new int[]{1,0,1,2,0}, 1},
                 {3, new int[]{1,0,1,2,0}, 2},
                 {3, new int[]{4,0,1,2,0}, 1},
                 {6, new int[]{4,0,1,2,0}, 4},
                 {7, new int[]{2,3,1,2,4,3}, 2},
                 {55, new int[]{9,1,8,2,7,3,6,4,5,10}, 10},
           });
    }
    private int s;
    private int[] nums;
    private int expected;

    public SolutionTest(int s, int[] nums, int expected) {
        this.s = s;
        this.nums = nums;
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
        int actual = new Solution().minSubArrayLen(s, nums);
        assertThat(actual, is(expected));
    }
}
