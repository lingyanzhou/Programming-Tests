package lzhou.programmingtest.lintcode.test183;

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
    @Parameters(name = "{index}: woodCut({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(new Integer[]{232,124,456}), 2, 232},
                 {Arrays.asList(new Integer[]{232,124,456}), 3, 228},
                 {Arrays.asList(new Integer[]{232,124,456}), 4, 152},
                 {Arrays.asList(new Integer[]{232,124,456}), 5, 124},
                 {Arrays.asList(new Integer[]{232,124,456,99}), 5, 124},
                 {Arrays.asList(new Integer[]{232,124,456,99}), 9, 91},
                 {Arrays.asList(new Integer[]{2147483644,2147483645,2147483646,2147483647}), 4, 2147483644}
           });
    }
    private int[] L;
    private int k;
    private int expected;

    public SolutionTest(List<Integer> L, int k, int expected) {
        this.L = new int[L.size()];
        for (int i=0; i<L.size(); ++i) {
            this.L[i] = L.get(i);
        }
        this.k = k;
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
        int actual = new Solution().woodCut(L, k);
        assertThat(actual, is(expected));
    }
}
