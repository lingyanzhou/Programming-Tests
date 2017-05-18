package lzhou.programmingtest.leetcode.test480;

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
    @Parameters(name = "{index}: medianSlidingWindow({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                {new int[]{1,3,-1,-3,5,3,6,7},
                    3,
                    new Double[]{1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000}},
                {new int[]{1,3,-1,-3,5,3,6,7},
                    4,
                    new Double[]{0.00000,1.00000,1.00000,4.00000,5.50000}},
                {new int[]{1,3,-1,-3,5,3,6,7},
                    5,
                    new Double[]{1.00000,3.00000,3.00000,5.00000}},
                {new int[]{1,3,-1,-3,5,3,6,7},
                    1,
                    new Double[]{1.00000,3.00000,-1.00000,-3.00000,5.00000,3.00000,6.00000,7.00000}},
                {new int[]{2147483647,2147483647},
                    2,
                    new Double[]{2147483647.00000}},
           });
    }
    private int[] nums;
    private int k;
    private Double[] expected;

    public SolutionTest(int[] nums, int k, Double[] expected) {
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
        double[] actual = new Solution().medianSlidingWindow(nums, k);
        Double[] actualBoxed = new Double[actual.length];
        for (int i=0; i<actual.length; ++i) {
            actualBoxed[i] = actual[i];
        }
        assertThat(Arrays.asList(actualBoxed), contains(expected));
    }
}
