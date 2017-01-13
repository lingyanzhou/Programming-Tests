package lzhou.programmingtest.leetcode.test239;

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
    @Parameters(name = "{index}: maxSlidingWindow({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{}, 0, new int[]{}},
                 {new int[]{1}, 1, new int[]{1}},
                 {new int[]{1,5,2,3,1,0,4}, 1, new int[]{1,5,2,3,1,0,4}},
                 {new int[]{1,3,-1,-3,5,3,6,7}, 2, new int[]{3,3,-1,5,5,6,7}},
                 {new int[]{1,3,-1,-3,5,3,6,7}, 3, new int[]{3,3,5,5,6,7}},
           });
    }
    private int[] nums;
    private int k;
    private int[] expected;

    public SolutionTest(int[] nums, int k, int[] expected) {
        this.nums = nums;
        this.k = k;
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
        int[] actual = new Solution().maxSlidingWindow(nums, k);
        assertArrayEquals(expected, actual);
    }
}
