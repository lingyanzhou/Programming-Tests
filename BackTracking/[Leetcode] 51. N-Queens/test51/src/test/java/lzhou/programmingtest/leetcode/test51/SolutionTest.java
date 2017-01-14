package lzhou.programmingtest.leetcode.test51;

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
    @Parameters(name = "{index}: solveNQueens({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {1, new String[][]{{"Q"}}},
                 {2, new String[][]{}},
                 {3, new String[][]{}},
                 {4, new String[][]{{".Q..","...Q","Q...","..Q."},{"..Q.","Q...","...Q",".Q.."}}},
           });
    }
    private int n;
    private String[][] expected;

    public SolutionTest(int n, String[][] expected) {
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
        List<List<String>> actual = new Solution().solveNQueens(n);
        assertThat(actual,  hasSize(expected.length));
        for (int i=0; i<actual.size(); ++i) {
            assertThat(actual.get(i),  hasSize(expected[i].length));
            for (int j=0; j<actual.get(i).size(); ++j) {
                assertThat(actual.get(i).get(j), is(expected[i][j]));
            }
        }
    }
}
