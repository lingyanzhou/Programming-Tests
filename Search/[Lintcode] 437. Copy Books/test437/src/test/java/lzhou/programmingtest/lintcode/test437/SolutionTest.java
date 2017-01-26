package lzhou.programmingtest.lintcode.test437;

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
    @Parameters(name = "{index}: copyBooks({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{2,1,3}, 1, 6},
                 {new int[]{2,1,3}, 5, 3},
                 {new int[]{3,2,4}, 2, 5},
                 {new int[]{1,5,2,3,1,5,8,3,5,8,1}, 4, 13},
                 {new int[]{9,3,1,2,12,12,9,10,2,1,1,1}, 6, 14},
                 {new int[]{9,3,1,2,32,12,9,10,2,1,1,1}, 6, 32},
           });
    }
    private int[] pages;
    private int k;
    private int expected;

    public SolutionTest(int[] pages, int k, int expected) {
        this.pages = pages;
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
        int actual = new Solution().copyBooks(pages, k);
        assertThat(actual, is(expected));
    }
}
