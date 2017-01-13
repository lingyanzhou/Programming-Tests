package lzhou.programmingtest.leetcode.test15;

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
    @Parameters(name = "{index}: threeSum({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{-1, 0, 1}, new Integer[][]{{-1, 0, 1}}},
                 {new int[]{-1, 0, 4,-3}, new Integer[][]{{-3, -1, 4}}},
                 {new int[]{-1, 0, 1, 2, -1, -4}, new Integer[][]{{-1, 0, 1}, {-1, -1, 2}}},
                 {new int[]{-1,0,1,2,-1,1,2,-4}, new Integer[][]{{-4,2,2},{-1, 0, 1}, {-1, -1, 2}}},
                 {new int[]{-4,-1,-1,0,1,1,2,2}, new Integer[][]{{-4,2,2},{-1, 0, 1}, {-1, -1, 2}}},
           });
    }
    private int[] nums;
    private List<List<Integer>> expected;

    public SolutionTest(int[] nums, Integer[][] expected) {
        this.nums = nums;
        this.expected = new ArrayList<List<Integer>>();
        for (int i=0; i<expected.length; ++i) {
            this.expected.add(Arrays.asList(expected[i]));
        }
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
        List<List<Integer> > actual = new Solution().threeSum(nums);
        assertThat(actual, hasSize(expected.size()));
        sortList3Integer(actual);
        sortList3Integer(expected);
        for (int i=0; i<actual.size(); ++i) {
            assertThat(actual.get(i), containsInAnyOrder(expected.get(i).toArray(new Integer[0])));
        }
    }

    private static void sortList3Integer(List<List<Integer>> list) {
        Collections.sort(list, new Comparator<List<Integer>>() {
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i=0; i<3; ++i) {
                    int ret = Integer.compare(l1.get(i), l2.get(i));
                    if (ret!=0) {
                        return ret;
                    }
                }
                return 0;
            }
        });
    }
}
