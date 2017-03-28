package lzhou.programmingtest.leetcode.test490;

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
    @Parameters(name = "{index}: hasPath({0},{1},{2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {new int[][]{{0,0}}, new int[]{0,0}, new int[]{0,1}, true},
                 {new int[][]{{0,0,0}}, new int[]{0,0}, new int[]{0,1}, false},
                 {new int[][]{{0,1,0}}, new int[]{0,0}, new int[]{0,2}, false},
                 {new int[][]{{0,0,0}}, new int[]{0,0}, new int[]{0,2}, true},
                 {new int[][]{{0,0,1,0,0},
                              {0,0,0,0,0},
                              {0,0,0,1,0},
                              {1,1,0,1,1},
                              {0,0,0,0,0},},
                     new int[]{0,4},
                     new int[]{4,4}, true},
                 {new int[][]{{0,0,1,0,0},
                              {0,0,0,0,0},
                              {0,0,0,1,0},
                              {1,1,0,1,1},
                              {0,0,0,0,0},},
                     new int[]{0,4},
                     new int[]{3,2}, false},
           });
    }
    private int[][] board;
    private int[] start;
    private int[] destination;
    private boolean expected;

    public SolutionTest(int[][] board, int[] start, int[] destination, boolean expected) {
        this.board = board;
        this.start = start;
        this.destination = destination;
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
        boolean actual = new Solution().hasPath(board, start, destination);
        assertThat(actual, is(expected));
    }
}
