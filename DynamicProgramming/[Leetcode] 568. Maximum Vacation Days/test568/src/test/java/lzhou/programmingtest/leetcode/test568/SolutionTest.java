package lzhou.programmingtest.leetcode.test568;

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
    @Parameters(name = "{index}: maxVacationDays({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{0,0},{1,0}}, new int[][]{{1},{2}}, 1},
                 {new int[][]{{0,0},{1,0}}, new int[][]{{3},{2}}, 3},
                 {new int[][]{{0,0},{1,0}}, new int[][]{{1,1},{2,2}}, 2},
                 {new int[][]{{0,1},{0,0}}, new int[][]{{1},{2}}, 2},
                 {new int[][]{{0,1},{0,0}}, new int[][]{{1,1},{1,2}}, 3},
                 {new int[][]{{0,1},{0,0}}, new int[][]{{1,4},{2,1}}, 5},
                 {new int[][]{{0,1},{1,0}}, new int[][]{{1,4},{2,1}}, 6},
                 {new int[][]{{0,1,1},{1,0,1},{1,1,0}}, new int[][]{{1,3,1},{6,0,3},{3,3,3}}, 12},
                 {new int[][]{{0,0,0},{0,0,0},{0,0,0}}, new int[][]{{1,3,1},{6,0,3},{3,3,3}}, 5},
           });
    }
    private int[][] flights;
    private int[][] days;
    private int expected;

    public SolutionTest(int[][] flights, int[][] days, int expected) {
        this.flights = flights;
        this.days = days;
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
        int actual = new Solution().maxVacationDays(flights, days);
        assertThat(actual, is(expected));
    }
}
