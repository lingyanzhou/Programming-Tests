package lzhou.programmingtest.lintcode.test91;

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
    @Parameters(name = "{index}: MinAdjustmentCost({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1}, 1, 0},
                 {new int[]{1,2}, 1, 0},
                 {new int[]{1,2}, 0, 1},
                 {new int[]{1,2,100}, 0, 99},
                 {new int[]{100,1,2}, 0, 99},
                 {new int[]{100,1,100}, 1, 98},
                 {new int[]{1,100,1}, 2, 97},
                 {new int[]{1,4,2,3}, 1, 2},
                 {new int[]{3,8,90,5,1,78}, 5, 152},
           });
    }
    private int[] A;
    private int target;
    private int expected;

    public SolutionTest(int[] A, int target, int expected) {
        this.A = A;
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
        int actual = new Solution().MinAdjustmentCost(A, target);
        assertThat(actual, is(expected));
    }
}
