package lzhou.programmingtest.leetcode.test373;

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
    @Parameters(name = "{index}: kSmallestPairs({0},{1},{2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1,2}, new int[]{3,4}, 2, new Integer[]{4,5}},
                 {new int[]{1,2}, new int[]{3,4}, 1, new Integer[]{4}},
                 {new int[]{1,1,2}, new int[]{1,2,3}, 4, new Integer[]{2,2,3,3}},
                 {new int[]{1,1,2}, new int[]{1,2,3}, 1, new Integer[]{2}},
                 {new int[]{1,1,2}, new int[]{1,2,3}, 6, new Integer[]{2,2,3,3,3,4}},
                 {new int[]{1,1,2,2}, new int[]{1,1,2,3,3}, 4, new Integer[]{2,2,2,2}},
                 {new int[]{1,1,2,2}, new int[]{1,1,2,3,3}, 12, new Integer[]{2,2,2,2,3,3,3,3,3,3,4,4}},
           });
    }
    private int[] nums1;
    private int[] nums2;
    private int k;
    private Integer[] expected;

    public SolutionTest(int[] nums1, int[] nums2, int k, Integer[] expected) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.k=k;
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
        List<int[]> actual = new Solution().kSmallestPairs(nums1, nums2, k);
        List<Integer> pairwiseSum = new ArrayList<Integer>();
        for (int[] a: actual) {
            pairwiseSum.add(a[0]+a[1]);
        }
        assertThat(actual.toString(), pairwiseSum, contains(expected));
    }
}
