package lzhou.programmingtest.leetcode.test576;

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
    @Parameters(name = "{index}: findPaths({0},{1},{2},{3},{4})={5}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {1,1,1,0,0,4},
                 {2,2,1,0,0,2},
                 {1,3,1,0,0,3},
                 {1,3,1,0,1,2},
                 {1,3,1,0,2,3},
                 {1,3,2,0,1,8},
                 {3,1,3,1,0,12},
                 {10,10,20,4,3, 651994707},
                 {2,4,50,1,0,281781446},
                 {1,3,40,0,2,5242875},
                 {50,50,50,25,25,276775132},
           });
    }
    private int m;
    private int n;
    private int N;
    private int i;
    private int j;
    private int expected;

    public SolutionTest(int m, int n, int N, int i, int j, int expected) {
        this.m = m;
        this.n = n;
        this.N = N;
        this.i = i;
        this.j = j;
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
        int actual = new Solution().findPaths(m, n, N, i, j);
        assertThat(actual, is(expected));
    }
}
