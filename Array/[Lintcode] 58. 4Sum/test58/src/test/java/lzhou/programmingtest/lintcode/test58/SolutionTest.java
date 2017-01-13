package lzhou.programmingtest.lintcode.test58;

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
    @Parameters(name = "{index}: fourSum({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{}, 0, new Integer[][]{}},
                 {new int[]{1,4,2,8,-2,1}, 0, new Integer[][]{}},
                 {new int[]{1,0,-1,0,-2,2}, 0, new Integer[][]{{-2,-1,1,2},{-2,0,0,2},{-1,0,0,1}}},
                 {new int[]{1,0,-1,0,-2,2}, 2, new Integer[][]{{-1,0,1,2}}},
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
        List<List<Integer>> actual = new Solution().fourSum(nums, target);
        assertThat(actual, hasSize(expected.length));

        Collections.sort(actual, new Comparator<List<Integer>>(){
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i=0; i<4; ++i) {
                    int tmp = Integer.compare(l1.get(i).intValue(), l2.get(i).intValue());
                    if (tmp!=0) {
                        return tmp;
                    }
                }
                return 0;
            }
        });
        for (int i=0; i<actual.size(); ++i) {
            assertThat(actual.get(i), contains(expected[i]));
        }
    }
}
