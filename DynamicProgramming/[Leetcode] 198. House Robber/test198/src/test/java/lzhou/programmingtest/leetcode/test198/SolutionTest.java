package lzhou.programmingtest.leetcode.test198;

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
    @Parameters(name = "{index}: houseRobber({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{}, 0L},
                 {new int[]{1}, 1L},
                 {new int[]{1,2}, 2L},
                 {new int[]{2,1}, 2L},
                 {new int[]{1,2,3}, 4L},
                 {new int[]{1,3,2}, 3L},
                 {new int[]{3,4,2}, 5L},
                 {new int[]{5,4,2,8}, 13L},
                 {new int[]{3,2,3,1,5,8,9,2,0,3,5,23,24,7,4}, 53L},
                 {new int[]{2147483647, 2147483647, 1, 21}, 2147483668L},
           });
    }
    private int[] A;
    private long expected;

    public SolutionTest(int[] A, long expected) {
        this.A = A;
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
        long actual = new Solution().houseRobber(A);
        assertThat(actual, is(expected));
    }
}
