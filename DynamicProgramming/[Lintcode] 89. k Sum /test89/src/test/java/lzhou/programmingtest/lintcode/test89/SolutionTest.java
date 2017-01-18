package lzhou.programmingtest.lintcode.test89;

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
    @Parameters(name = "{index}: kSum({0}, {1}, {2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1}, 1, 0, 0},
                 {new int[]{1}, 1, 1, 1},
                 {new int[]{1}, 2, 1, 0},
                 {new int[]{1,2}, 1, 2, 1},
                 {new int[]{1,2}, 2, 1, 0},
                 {new int[]{1,2}, 2, 3, 1},
                 {new int[]{1,2,3,4}, 2, 5, 2},
                 {new int[]{1,2,3,4}, 2, 4, 1},
                 {new int[]{1,2,3,4}, 2, 7, 1},
                 {new int[]{1,2,3,4}, 2, 8, 0},
                 {new int[]{1,4,6,8,10,13,15,17,18,21,23,26,27,28,29,30,32,35,36}, 9, 133, 231},
           });
    }
    private int[] A;
    private int k;
    private int target;
    private int expected;

    public SolutionTest(int[] A, int k, int target, int expected) {
        this.A = A;
        this.k = k;
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
        int actual = new Solution().kSum(A, k, target);
        assertThat(actual, is(expected));
    }
}
