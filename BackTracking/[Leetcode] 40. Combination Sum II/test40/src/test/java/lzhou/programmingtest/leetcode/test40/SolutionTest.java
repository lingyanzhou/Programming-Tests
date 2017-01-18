package lzhou.programmingtest.leetcode.test40;

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
    @Parameters(name = "{index}: combinationSum2({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{2, 3, 6, 7}, 7, new Integer[][]{{7}}},
                 {new int[]{2, 1}, 2, new Integer[][]{{2}}},
                 {new int[]{2, 1, 1}, 2, new Integer[][]{{1,1},{2}}},
                 {new int[]{1,5,6}, 6, new Integer[][]{{1,5},{6}}},
                 {new int[]{1,1,5,5,6}, 6, new Integer[][]{{1,5},{6}}},
                 {new int[]{1,1,4,5,5,6}, 6, new Integer[][]{{1,1,4},{1,5},{6}}},
                 {new int[]{1,5,6,2,3,4}, 6, new Integer[][]{{1,2,3},{1,5},{2,4},{6}}},
                 {new int[]{10, 1, 2, 7, 6, 1, 5}, 8, new Integer[][]{{1,1,6},{1,2,5},{1,7},{2,6,}}},
           });
    }
    private int[] nums;
    private int target;
    private Integer[][] expected;

    public SolutionTest(int[] nums, int target, Integer[][] expected) {
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
        List<List<Integer>> actual = new Solution().combinationSum2(nums, target);
        for (int i=0; i<actual.size(); ++i) {
            assertThat(actual.get(i), contains(expected[i]));
        }
    }
}
