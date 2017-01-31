package lzhou.programmingtest.leetcode.test351;

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
    @Parameters(name = "{index}: numberOfPatterns({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1,1,9},
                {2,2,56},
                {1,2,65},
                {3,3,320},
                {4,4,1624},
                {5,5,7152},
                {6,6,26016},
                {7,7,72912},
                {8,8,140704},
                {9,9,140704},
                {1,9,389497},
           });
    }
    private int m;
    private int n;
    private int expected;

    public SolutionTest(int m, int n, int expected) {
        this.m = m;
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
        int actual = new Solution().numberOfPatterns(m, n);
        assertThat(actual, is(expected));
    }
}
