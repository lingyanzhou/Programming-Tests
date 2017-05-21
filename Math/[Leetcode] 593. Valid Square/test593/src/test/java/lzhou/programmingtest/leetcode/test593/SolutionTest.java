package lzhou.programmingtest.leetcode.test593;

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
    @Parameters(name = "{index}: validSquare({0},{1},{2},{3})={4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{0,0},new int[]{0,1},new int[]{2,1},new int[]{2,0},false},
                 {new int[]{1,1},new int[]{1,0},new int[]{0,0},new int[]{0,1},true},
                 {new int[]{0,0},new int[]{0,0},new int[]{0,0},new int[]{0,0},false},
                 {new int[]{0,0},new int[]{1,1},new int[]{-1,1},new int[]{0,2},true},
           });
    }
    private int[] p1;
    private int[] p2;
    private int[] p3;
    private int[] p4;
    private boolean expected;

    public SolutionTest(int[] p1, int[] p2, int[] p3, int[] p4, boolean expected) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
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
        boolean actual = new Solution().validSquare(p1,p2,p3,p4);
        assertThat(actual, is(expected));
    }
}
