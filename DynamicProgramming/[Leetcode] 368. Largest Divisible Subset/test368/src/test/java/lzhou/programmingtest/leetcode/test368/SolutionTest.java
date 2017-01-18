package lzhou.programmingtest.leetcode.test368;

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
    @Parameters(name = "{index}: largestDivisibleSubset({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{}, new Integer[]{}},
                 {new int[]{1,}, new Integer[]{1}},
                 {new int[]{1,2,}, new Integer[]{1,2}},
                 {new int[]{4,1,2}, new Integer[]{1,2,4}},
                 {new int[]{1,3,2}, new Integer[]{1,2}}, //1,3 is also ok
                 {new int[]{1,2,4,3,8,9}, new Integer[]{1,2,4,8}},
                 {new int[]{1,2,4,3,9,18}, new Integer[]{1,3,9,18}},
           });
    }
    private int[] nums;
    private Integer[] expected;

    public SolutionTest(int[] nums, Integer[] expected) {
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
        List<Integer> actual = new Solution().largestDivisibleSubset(nums);
        if (expected.length==0) {
            assertThat(actual, hasSize(0));
        } else {
            assertThat(actual, contains(expected));
        }
    }
}
