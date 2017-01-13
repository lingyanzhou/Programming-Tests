package lzhou.programmingtest.lintcode.test508;

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
    @Parameters(name = "{index}: method({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{}},
                 {new int[]{1}},
                 {new int[]{2,1}},
                 {new int[]{1,2}},
                 {new int[]{3,2,1}},
                 {new int[]{2,3,1,1}},
                 {new int[]{2,3,1,3}},
                 {new int[]{4,2,1,3}},
                 {new int[]{2,3,1,1,3}},
                 {new int[]{2,3,3,1,3}},
                 {new int[]{5,1,2,3,4}},
                 {new int[]{5,1,2,6,3,4}},
                 {new int[]{5,1,2,6,3,7,4}},
                 {new int[]{5,1,2,6,3,7,8,4}},
           });
    }
    private int[] nums;

    public SolutionTest(int[] nums) {
        this.nums = nums;
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
        new Solution().wiggleSort(nums);
        assertIsWiggle(nums);
    }
    
    private void assertIsWiggle(int[] A) {
        if (A.length==0) {
            return;
        }
        
        boolean larger = true;
        for (int i=1; i<A.length; ++i) {
            if (larger && A[i]<A[i-1]) {
                fail(Arrays.toString(A));
            } else if (!larger && A[i]>A[i-1]) {
                fail(Arrays.toString(A));
            }
            larger = !larger;
        }
    }
}
