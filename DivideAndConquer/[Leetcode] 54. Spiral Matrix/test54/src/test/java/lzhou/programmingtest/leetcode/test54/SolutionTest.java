package lzhou.programmingtest.leetcode.test54;

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
    @Parameters(name = "{index}: spiralOrder({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{1}}, new Integer[]{1}},
                 {new int[][]{{1,2}}, new Integer[]{1,2}},
                 {new int[][]{{1},{2}}, new Integer[]{1,2}},
                 {new int[][]{{1,2},{3,4}}, new Integer[]{1,2,4,3}},
                 {new int[][]{{1,2,3},{4,5,6}}, new Integer[]{1,2,3,6,5,4}},
                 {new int[][]{{1,2},{3,4},{5,6}}, new Integer[]{1,2,4,6,5,3}},
                 {new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}}, new Integer[]{1,2,3,6,9,12,11,10,7,4,5,8}},
                 {new int[][]{{1,2,3,4},{4,5,6,7},{7,8,9,9},{10,11,12,12}}, new Integer[]{1,2,3,4,7,9,12,12,11,10,7,4,5,6,9,8}},
           });
    }
    private int[][] matrix;
    private Integer[] expected;

    public SolutionTest(int[][] matrix, Integer[] expected) {
        this.matrix = matrix;
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
        List<Integer> actual = new Solution().spiralOrder(matrix);
        assertThat( actual, contains(expected));
    }
}
