package lzhou.programmingtest.lintcode.test205;

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
    @Parameters(name = "{index}: intervalMinNumber({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1,2,7,8,5},
                     Arrays.asList(new Interval[]{new Interval(1,2),new Interval(0,4),new Interval(2,4)}),
                     Arrays.asList(new Integer[]{2,1,5})},
                 {new int[]{1,2,7,8},
                     Arrays.asList(new Interval[]{new Interval(1,1),new Interval(0,0),new Interval(3,3)}),
                     Arrays.asList(new Integer[]{2,1,8})},
           });
    }
    private int[] A;
    private List<Interval> queries;
    private List<Integer> expected;

    public SolutionTest(int[] A, List<Interval> queries, List<Integer> expected) {
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
        List<Integer> actual = new Solution().intervalMinNumber(A, queries);
        assertListEquals(expected, actual);
    }

    private static void assertListEquals(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
