package lzhou.programmingtest.leetcode.test565;

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
    @Parameters(name = "{index}: arrayNesting({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
              {new int[]{1,5,3,4,0,6,2,8,7}, 7},
              {new int[]{2,3,1,4,0}, 5},
              {new int[]{0,1,2,3}, 1},
              {new int[]{1,0,3,4,2}, 3},
              {new int[]{3,4,1,2,0}, 5},
              {new int[]{2, 0, 6, 9, 3, 8, 1, 5, 7, 10, 4}, 4},
              {new int[]{1, 0, 5, 4, 2, 3}, 4},
           });
    }
    private int[] nums;
    private int expected;

    public SolutionTest(int[] nums, int expected) {
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
        int actual = new Solution().arrayNesting(nums);
        assertThat(actual, is(expected));
    }
}
