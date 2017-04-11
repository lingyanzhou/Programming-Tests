package lzhou.programmingtest.leetcode.test444;

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
    @Parameters(name = "{index}: sequenceReconstruction({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1,2}, new int[][]{{1,2}}, true},
                 {new int[]{2,1}, new int[][]{{2,1}}, true},
                 {new int[]{2,1}, new int[][]{{1,2}}, false},
                 {new int[]{1,3}, new int[][]{{1,2}}, false},
                 {new int[]{1,2,3}, new int[][]{{1,2},{1,3}}, false},
                 {new int[]{1,3,2}, new int[][]{{1,2},{1,3}}, false},
                 {new int[]{1,2,3}, new int[][]{{1,2},{2,3}}, true},
                 {new int[]{1,3,2}, new int[][]{{1,2},{2,3}}, false},
                 {new int[]{3,1,2}, new int[][]{{1,2},{3,1}}, true},
                 {new int[]{3,1,2}, new int[][]{{1,2},{3,1},{3,2}}, true},
                 {new int[]{1,2,3,4}, new int[][]{{1,2},{2,4},{3,4}}, false},
                 {new int[]{1,2,3,4}, new int[][]{{1,2},{1,4},{3,4}}, false},
                 {new int[]{1,2,3,4}, new int[][]{{1,2},{1,3},{1,4}}, false},
                 {new int[]{1,2,3,4}, new int[][]{{1,2},{2,3},{3,4}}, true},
                 {new int[]{1,2,3,4}, new int[][]{{1,3},{2,3},{3,4}}, false},
                 {new int[]{4,1,5,2,6,3}, new int[][]{{5,2,6,3},{4,1,5,2}}, true},
           });
    }
    
    private int[] original;
    private int[][] precedences;
    private boolean expected;

    public SolutionTest(int[] original, int[][] precedences, Boolean expected) {
        this.original = original;
        this.precedences = precedences;
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
        boolean actual = new Solution().sequenceReconstruction(original, precedences);
        assertThat(actual, is(expected));
    }
}
