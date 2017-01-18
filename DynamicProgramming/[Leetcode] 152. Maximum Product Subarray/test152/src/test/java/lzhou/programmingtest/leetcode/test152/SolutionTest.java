package lzhou.programmingtest.leetcode.test152;

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
    @Parameters(name = "{index}: maxProduct({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{2}, 2},
                 {new int[]{-2}, -2},
                 {new int[]{-2, -4}, 8},
                 {new int[]{2,-2}, 2},
                 {new int[]{-2,0,-4}, 0},
                 {new int[]{2,0,4}, 4},
                 {new int[]{2,3}, 6},
                 {new int[]{2,-1, 3}, 3},
                 {new int[]{2,-1, 3,-4}, 24},
                 {new int[]{2,-1, 3,0,-4}, 3},
                 {new int[]{0,-5,2,-1}, 10},
                 {new int[]{2,3,-2,4}, 6},
           });
    }
    private int[] in;
    private int expected;

    public SolutionTest(int[] in, int expected) {
        this.in = in;
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
        int actual = new Solution().maxProduct(in);
        assertThat(actual, is(expected));
    }
}
