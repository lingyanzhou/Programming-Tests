package lzhou.programmingtest.leetcode.test16;

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
    @Parameters(name = "{index}: threeSumClosest({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{2,7,11,15}, 0, 20},
                 {new int[]{2,7,11,15}, 21, 20},
                 {new int[]{2,7,11,15}, 23, 24},
                 {new int[]{2,7,11,15}, 24, 24},
                 {new int[]{2,7,11,15}, 27, 28},
                 {new int[]{2,7,11,15}, 29, 28},
                 {new int[]{2,7,11,15}, 31, 33},
                 {new int[]{2,7,11,15}, 35, 33},
                 {new int[]{2,7,11,15}, 1, 20},
                 {new int[]{0,2,0,5,1}, 0, 1},
                 {new int[]{0,2,0,5,1}, 1, 1},
                 {new int[]{0,2,0,5,1}, 2, 2},
                 {new int[]{0,2,0,5,1}, 3, 3},
                 {new int[]{0,2,0,5,1}, 4, 5},
                 {new int[]{0,2,0,5,1}, 5, 5},
           });
    }
    private int [] nums;
    private int target;
    private int expected;

    public SolutionTest(int[] nums, int target, int expected) {
        this.nums = nums;
        this.target = target;
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
        int actual = new Solution().threeSumClosest(nums, target);
        assertThat(actual, is(expected));
    }
}
