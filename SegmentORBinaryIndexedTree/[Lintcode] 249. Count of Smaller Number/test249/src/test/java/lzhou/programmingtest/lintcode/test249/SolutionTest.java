package lzhou.programmingtest.lintcode.test249;

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
    @Parameters(name = "{index}: countOfSmallerNumber({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{0}, new int[]{-1,0,1,10}, new Integer[]{0,0,1,1}},
                 {new int[]{-1,-2}, new int[]{-3,-2,-1,0}, new Integer[]{0,0,1,2}},
                 {new int[]{1,2,7,8,5}, new int[]{1,8,5}, new Integer[]{0,4,2}},
                 {new int[]{1,2,7,8,5}, new int[]{1,8,5}, new Integer[]{0,4,2}},
                 {new int[]{}, new int[]{86,59,39}, new Integer[]{0,0,0}},
                 {new int[]{-3,1,2,7,8,5}, new int[]{1,8,5}, new Integer[]{1,5,3}},
           });
    }
    private int[] A;
    private int[] queries;
    private Integer[] expected;

    public SolutionTest(int[] A, int[] queries, Integer[] expected) {
        this.A = A;
        this.queries = queries;
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
        List<Integer> actual = new Solution().countOfSmallerNumber(A, queries);
        assertThat(actual, contains(expected));
    }
}
