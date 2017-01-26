package lzhou.programmingtest.leetcode.test391;

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
    @Parameters(name = "{index}: isRectangleCover({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{-1,-1,1,1}}, true},
                 {new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}, true},
                 {new int[][]{{0,0,1,1},{0,1,1,2},{0,2,1,3},{0,3,1,4}}, true},
                 {new int[][]{{-1,-1,1,1}, {-1,-1,2,2}}, false}, //corners overlap
                 {new int[][]{{-1,-1,1,1}, {2,2,3,3}}, false}, //separate rect
                 {new int[][]{{0,0,1,1}, {0,1,1,2},{1,1,2,2}}, false}, //A corner with three rect
                 {new int[][]{{0,0,2,2}, {0,2,1,3},{1,1,3,3},{2,0,3,1}}, false}, //Bounding rect is ok, but has overlapped area
           });
    }
    private int[][] in;
    private boolean expected;

    public SolutionTest(int[][] in, boolean expected) {
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
        boolean actual = new Solution().isRectangleCover(in);
        assertThat(actual, is(expected));
    }
}
