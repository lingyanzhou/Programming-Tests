package lzhou.programmingtest.lintcode.test143;

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
    @Parameters(name = "{index}: sortColors2({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(new Integer[]{1}), 1, Arrays.asList(new Integer[]{1})},
                 {Arrays.asList(new Integer[]{2,1}), 2, Arrays.asList(new Integer[]{1,2})},
                 {Arrays.asList(new Integer[]{2,1,1,2,1,2}), 2, Arrays.asList(new Integer[]{1,1,1,2,2,2})},
                 {Arrays.asList(new Integer[]{3, 2, 2, 1, 4}), 4, Arrays.asList(new Integer[]{1,2,2,3,4})},
           });
    }
    private int[] colors;
    private int k;
    private int[] expected;

    public SolutionTest(List<Integer> colors, int k, List<Integer> expected) {
        this.colors = new int[colors.size()];
        for (int i=0; i<colors.size(); ++i) {
            this.colors[i] = colors.get(i);
        }
        this.k = k;
        this.expected = new int[expected.size()];
        for (int i=0; i<expected.size(); ++i) {
            this.expected[i] = expected.get(i);
        }
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
        new Solution().sortColors2(colors, k);
        assertArrayEquals(colors, expected);
    }
}
