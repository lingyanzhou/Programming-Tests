package lzhou.programmingtest.lintcode.test42;

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
    @Parameters(name = "{index}: maxTwoSubArrays({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            {new int[]{81, -1}, 80},
            {new int[]{-80, -8}, -88},
            {new int[]{38, -60}, -22},
            {new int[]{39, -47, -8}, 31},
            {new int[]{-77, -1, 4}, 3},
            {new int[]{-33, -9, 5}, -4},
            {new int[]{-42, 0, 73, 24}, 97},
            {new int[]{-40, -35, 32, 65}, 97},
            {new int[]{26, -8, -9, 76}, 102},
            {new int[]{-7, -24, 72, -42, -66}, 65},
            {new int[]{59, 26, -97, -66, -21}, 85},
            {new int[]{87, -70, 71, 69, -57}, 227},
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
        int actual = new Solution().maxTwoSubArrays(nums);
        assertThat(actual, is(expected));
    }
}
