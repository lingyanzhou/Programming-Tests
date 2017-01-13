package lzhou.programmingtest.lintcode.test395;

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
    @Parameters(name = "{index}: firstWillWin({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(new Integer[]{1,2}), true}, {Arrays.asList(new Integer[]{1,2,3}), false},
                 {Arrays.asList(new Integer[]{1,2,4}), false}, {Arrays.asList(new Integer[]{1,2,1}), true},
                 {Arrays.asList(new Integer[]{1,2,1,10}), true}, {Arrays.asList(new Integer[]{1,2,10,10}), false}
           });
    }
    private int[] in;
    private boolean expected;

    public SolutionTest(List<Integer> in, boolean expected) {
        this.in = new int[in.size()];
        for (int i=0; i<in.size(); ++i) {
            this.in[i] = in.get(i);
        }
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
        boolean actual = new Solution().firstWillWin(in);
        assertThat(actual, is(expected));
    }
}
