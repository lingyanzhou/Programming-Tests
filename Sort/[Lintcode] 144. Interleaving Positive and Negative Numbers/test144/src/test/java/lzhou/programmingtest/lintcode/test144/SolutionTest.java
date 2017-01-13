package lzhou.programmingtest.lintcode.test144;

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
    @Parameters(name = "{index}: rerange({0})")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1}},
                 {new int[]{-1}},
                 {new int[]{1,-1}},
                 {new int[]{-1,1}},
                 {new int[]{-1,3,-5}},
                 {new int[]{1,-3,5}},
                 {new int[]{9,-2,3,-4}},
                 {new int[]{9,-2,-3,4}},
                 {new int[]{-1,1,1}},
                 {new int[]{-1,-1,1,1,1}},
                 {new int[]{-1,-1,-1,1,1,1,1}},
                 {new int[]{-1,-1,-1,-1,1,1,1,1,1}},
                 {new int[]{-1,-1,-1,-1,-1,1,1,1,1,1,1}},
                 {new int[]{-1,-1,1}},
                 {new int[]{-1,-1,-1,1,1}},
                 {new int[]{-1,-1,-1,-1,1,1,1}},
                 {new int[]{-1,-1,-1,-1,-1,1,1,1,1}},
                 {new int[]{-1,-1,-1,-1,-1,-1,1,1,1,1,1}},
           });
    }
    private int[] A;

    public SolutionTest(int[] A) {
        this.A = A;
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
        new Solution().rerange(A);
        assertIsInterleavingPnN(A);
    }

    private void assertIsInterleavingPnN(int[] A) {
        if (A.length==0) {
            return;
        }
        boolean prevNeg = A[0]<0;
        for (int i=1; i<A.length; ++i) {
            if (prevNeg && A[i]<0) {
                fail(Arrays.toString(A));
            } else if (!prevNeg && A[i]>0) {
                fail(Arrays.toString(A));
            }
            prevNeg = !prevNeg;
        }
    }
}
