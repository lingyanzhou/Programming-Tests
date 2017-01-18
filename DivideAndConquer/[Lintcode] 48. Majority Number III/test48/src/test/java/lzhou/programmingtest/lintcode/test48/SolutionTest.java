package lzhou.programmingtest.lintcode.test48;

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
    @Parameters(name = "{index}: majorityNumber({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                {new int[]{3,1,2,3,2,3,3,4,4,4}, 3, 3},
                {new int[]{3,1,2,3,2,3,3,9,8,2,4,4,4,4,4,4,9,12,13,14}, 5, 4},
           });
    }
    private int[] nums;
    private int k;
    private int expected;

    public SolutionTest(int[] nums, int k, int expected) {
        this.nums = nums;
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
    public void majorityNumber() {
        int actual = new Solution().majorityNumber(nums, k);
        assertThat(actual, is(expected));
    }
}
