package lzhou.programmingtest.leetcode.test78;

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
    @Parameters(name = "{index}: subsets({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1}, new Integer[][]{{},{1}}},
                 {new int[]{1,2}, new Integer[][]{{},{2},{1},{1,2}}},
                 {new int[]{1,2,3}, new Integer[][]{{},{3},{2},{2,3},{1},{1,3},{1,2},{1,2,3}}},
           });
    }
    private int[] nums;
    private Integer[][] expected;

    public SolutionTest(int[] nums, Integer[][] expected) {
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
        List<List<Integer>> actual = new Solution().subsets(nums);
        assertThat(actual, hasSize(expected.length));
        for (int i=0; i<actual.size(); ++i) {
            if (expected[i].length!=0) {
                assertThat(actual.get(i), contains(expected[i]));
            } else {
                assertThat(actual.get(i), hasSize(0));
            }
        }
    }
}
