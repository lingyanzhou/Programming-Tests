package lzhou.programmingtest.geeksforgeeks.the_celebrity_problem;

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
    @Parameters(name = "{index}: getId({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{0,0,0},{0,0,0},{0,0,0}}, 3, -1},
                 {new int[][]{{1,0,0},{0,1,0},{0,0,1}}, 3, -1},
                 {new int[][]{{1,1,1},{1,1,1},{1,1,1}}, 3, -1},
                 {new int[][]{{1,1,0},{0,1,0},{0,0,0}}, 3, -1},
                 {new int[][]{{1,1,0},{0,0,0},{0,1,0}}, 3, 1},
                 {new int[][]{{1,1,1},{0,0,1},{0,0,0}}, 3, 2},
           });
    }
    private int n;
    private int[][] matrix;
    private int expected;

    public SolutionTest(int[][] matrix, int n, int expected) {
        this.matrix = matrix;
        this.n = n;
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
        int actual = new Solution().getId(matrix, n);
        assertThat(actual, is(expected));
    }
}
