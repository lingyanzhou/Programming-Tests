package lzhou.programmingtest.leetcode.test188;

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
    @Parameters(name = "{index}: maxProfit({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {10, new int[]{}, 0},
                 {1, new int[]{4,4,6,1,1,4,2,5}, 4},
                 {1, new int[]{1,2,0,4}, 4},
                 {1, new int[]{1,2,3,4}, 3},
                 {1, new int[]{1,2,0,1}, 1},
                 {1, new int[]{0,10,2,3}, 10},
                 {1, new int[]{0,10,20,21}, 21},
                 {1, new int[]{0,10,5,6,0,10}, 10},
                 {1, new int[]{0,6,5,10,0,10}, 10},
                 {1, new int[]{0,5,2,6,0,1}, 6},
                 {2, new int[]{4,4,6,1,1,4,2,5}, 6},
                 {2, new int[]{1,2,0,4}, 5},
                 {2, new int[]{1,2,3,4}, 3},
                 {2, new int[]{1,2,0,1}, 2},
                 {2, new int[]{0,10,2,3}, 11},
                 {2, new int[]{0,10,20,21}, 21},
                 {2, new int[]{0,10,5,6,0,10}, 20},
                 {2, new int[]{0,6,5,10,0,10}, 20},
                 {2, new int[]{0,5,2,6,0,1}, 9},
                 {3, new int[]{4,4,6,1,1,4,2,5}, 8},
                 {3, new int[]{1,2,0,4}, 5},
                 {3, new int[]{1,2,3,4}, 3},
                 {3, new int[]{1,2,0,1}, 2},
                 {3, new int[]{0,10,2,3}, 11},
                 {3, new int[]{0,10,20,21}, 21},
                 {3, new int[]{0,10,5,6,0,10}, 21},
                 {3, new int[]{0,6,5,10,0,10}, 21},
                 {3, new int[]{0,5,2,6,0,1}, 10},
                 {2, new int[]{3,3,5,0,0,3,1,4}, 6},
                 {1000000, new int[]{3,3,5,0,0,3,1,4}, 8},
                 {1000000, new int[]{1,2,1,2}, 2},
                 {1000000, new int[]{1,2,1,2,1}, 2},
                 {1000000, new int[]{1,2,1,2,1,2}, 3},
                 {1000000, new int[]{2,1,2,1,2}, 2},
                 {1000000, new int[]{2,1,2,1,2,1}, 2},
                 {1000000, new int[]{2,1,2,1,2,1,2}, 3},
           });
    }
    private int k;
    private int[] prices;
    private int expected;

    public SolutionTest(int k, int[] prices, int expected) {
        this.k = k;
        this.prices = prices;
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
        int actual = new Solution().maxProfit(k, prices);
        assertThat(actual, is(expected));
    }
}
