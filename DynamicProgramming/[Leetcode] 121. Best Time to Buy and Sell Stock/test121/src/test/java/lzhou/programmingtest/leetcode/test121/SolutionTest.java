package lzhou.programmingtest.leetcode.test121;

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
    @Parameters(name = "{index}: maxProfit({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{}, 0},
                 {new int[]{1}, 0},
                 {new int[]{3,2,1}, 0},
                 {new int[]{3,1,2}, 1},
                 {new int[]{7, 6, 4, 3, 1}, 0},
                 {new int[]{7, 1, 5, 3, 6, 4}, 5},
                 {new int[]{9,2,4,1,3,2,3,1,2,3,1,2,4,9,4,6,5,7,7,4,2,7,2,4,6,3,8,5,8,2,7}, 8},
           });
    }
    private int[] prices;
    private int expected;

    public SolutionTest(int[] prices, int expected) {
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
        int actual = new Solution().maxProfit(prices);
        assertThat(actual, is(expected));
    }
}
