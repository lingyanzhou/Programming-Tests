package lzhou.programmingtest.leetcode.test221;

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
    @Parameters(name = "{index}: maximalSquare({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new String[]{"1"}, 1},
                 {new String[]{"0"}, 0},
                 {new String[]{"01", "11"}, 1},
                 {new String[]{"01", "00"}, 1},
                 {new String[]{"10", "00"}, 1},
                 {new String[]{"00", "10"}, 1},
                 {new String[]{"11", "11"}, 4},
                 {new String[]{"00", "00"}, 0},
                 {new String[]{"10100","10111","11111","10010"}, 4},
                 {new String[]{"10111","10111","11111","10010"}, 9},
                 {new String[]{"10110","10111","11111","10111"}, 9},
                 {new String[]{"11110","11111","11111","11111"}, 16},
           });
    }
    private char[][] matrix;
    private int expected;

    public SolutionTest(String[] matrix, int expected) {
        this.matrix = new char[matrix.length][];
        for (int i=0; i<matrix.length; ++i) {
            this.matrix[i] = matrix[i].toCharArray();
        }
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
        int actual = new Solution().maximalSquare(matrix);
        assertThat(actual, is(expected));
    }
}
