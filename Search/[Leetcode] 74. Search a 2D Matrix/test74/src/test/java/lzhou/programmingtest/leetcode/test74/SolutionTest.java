package lzhou.programmingtest.leetcode.test74;

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
    @Parameters(name = "{index}: searchMatrix(int[][], {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(new int[][]{{1}}), 1, true},
                 {Arrays.asList(new int[][]{{1}}), 2, false},
                 {Arrays.asList(new int[][]{{1,2}}), 1, true},
                 {Arrays.asList(new int[][]{{1,2}}), 2, true},
                 {Arrays.asList(new int[][]{{1,2}}), 0, false},
                 {Arrays.asList(new int[][]{{1,2}}), 3, false},
                 {Arrays.asList(new int[][]{{1,4}}), 2, false},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 0, false},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 1, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 2, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 3, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 4, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 5, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 6, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 7, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 8, true},
                 {Arrays.asList(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 9, true},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 2, false},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 4, false},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 6, false},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 8, false},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 10, false},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 12, false},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 14, false},
                 {Arrays.asList(new int[][]{{1,3,5},{7,9,11},{13,15,17}}), 16, false},
           });
    }
    private int[][] matrix;
    private int target;
    private boolean expected;

    public SolutionTest(List<int[]> matrix, int target, boolean expected) {
        this.matrix = matrix.toArray(new int[0][]);
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
        boolean actual = new Solution().searchMatrix(matrix, target);
        assertThat(actual, is(expected));
    }
}
