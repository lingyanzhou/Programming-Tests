package lzhou.programmingtest.leetcode.test135;

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
    @Parameters(name = "{index}: candy({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{0}, 1},
                 {new int[]{5,5}, 2},
                 {new int[]{1,2,2}, 4},
                 {new int[]{2,1,2}, 5},
                 {new int[]{2,2,1}, 4},
                 {new int[]{3,2,1}, 6},
                 {new int[]{2,3,2,1}, 7},
                 {new int[]{3,3,2,1}, 7},
                 {new int[]{3,2,2,1}, 6},
                 {new int[]{3,2,2,1,6}, 8},
                 {new int[]{5,5,1,2,5,2,2,1}, 13},
           });
    }
    private int[] ratings;
    private int expected;

    public SolutionTest(int[] ratings, int expected) {
        this.ratings = ratings;
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
        int actual = new Solution().candy(ratings);
        assertThat(actual, is(expected));
    }
}
