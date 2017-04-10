package lzhou.programmingtest.leetcode.test554;

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
    @Parameters(name = "{index}: leastBricks({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(Arrays.asList(2)), 1},
                 {Arrays.asList(Arrays.asList(2), Arrays.asList(2)), 2},
                 {Arrays.asList(Arrays.asList(1,1), Arrays.asList(2)), 1},
                 {Arrays.asList(Arrays.asList(1,1), Arrays.asList(1,1)), 0},
                 {Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(3), Arrays.asList(3)), 2},
                 {Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(2,1), Arrays.asList(3)), 1},
                 {Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(3), Arrays.asList(1,2)), 1},
                 {Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(2,1), Arrays.asList(1,2)), 1},
                 {Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(1,1,1), Arrays.asList(3)), 1},
                 {Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(1,1,1), Arrays.asList(2,1)), 0},
           });
    }
    private List<List<Integer>> in;
    private int expected;

    public SolutionTest(List<List<Integer>> in, int expected) {
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
        int actual = new Solution().leastBricks(in);
        assertThat(actual, is(expected));
    }
}
