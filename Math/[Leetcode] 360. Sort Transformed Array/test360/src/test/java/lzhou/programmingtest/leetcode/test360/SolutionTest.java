package lzhou.programmingtest.leetcode.test360;

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
    @Parameters(name = "{index}: sortTransformedArray({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{-4, -2, 2, 4}, 1, 3, 5, new Integer[]{3, 9, 15, 33}},
                 {new int[]{-4, -2, 2, 4}, 1, 2, 1, new Integer[]{1, 9, 9, 25}},
                 {new int[]{-4,-1,0,1}, 1, 2, 1, new Integer[]{0,1,4,9}},
                 {new int[]{-4,-3,-2,-1}, 1, 2, 1, new Integer[]{0,1,4,9}},
                 {new int[]{-4,-3,-2,-1,0,1}, 1, 2, 1, new Integer[]{0,1,1,4,4,9}},
                 {new int[]{0,1,2,3,4,5,6,7}, -1, 6, 0, new Integer[]{-7,0,0,5,5,8,8,9}},
                 {new int[]{-10,-5,0,1,2,3,4,5,6,7,100}, -2, 5, 50, new Integer[]{-19450,-200,-25,-13,8,25,38,47,50,52, 53}},
                 {new int[]{-10,-5,0,1,2,3,4,5,6,7,100}, 0, 10, 0, new Integer[]{-100, -50, 0,10,20,30,40,50,60,70,1000}},
                 {new int[]{-10,-5,0,1,2,3,4,5,6,7,100}, 0, 3, -9, new Integer[]{-39,-24,-9,-6,-3,0,3,6, 9, 12, 291}},
                 {new int[]{-10,-5,0,1,2,3,4,5,6,7,100}, 0, -1, 0, new Integer[]{-100,-7,-6,-5,-4,-3,-2,-1,0,5,10}},
           });
    }
    private int[] nums;
    private int a;
    private int b;
    private int c;
    private Integer[] expected;

    public SolutionTest(int[] nums, int a, int b, int c, Integer[] expected) {
        this.nums = nums;
        this.a = a;
        this.b = b;
        this.c = c;
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
        List<Integer> actual = new Solution().sortTransformedArray(nums, a, b, c);
        assertThat(actual.toString(), actual, contains(expected));
    }
}
