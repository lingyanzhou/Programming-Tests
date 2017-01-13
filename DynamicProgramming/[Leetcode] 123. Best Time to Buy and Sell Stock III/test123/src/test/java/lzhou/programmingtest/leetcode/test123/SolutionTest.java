package lzhou.programmingtest.leetcode.test123;

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
                 {new int[]{4,4,6,1,1,4,2,5}, 6},
                 {new int[]{1,2,0,4}, 5},
                 {new int[]{1,2,3,4}, 3},
                 {new int[]{1,2,0,1}, 2},
                 {new int[]{0,10,2,3}, 11},
                 {new int[]{0,10,20,21}, 21},
                 {new int[]{0,10,5,6,0,10}, 20},
                 {new int[]{0,6,5,10,0,10}, 20},
                 {new int[]{0,5,2,6,0,1}, 9},
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
