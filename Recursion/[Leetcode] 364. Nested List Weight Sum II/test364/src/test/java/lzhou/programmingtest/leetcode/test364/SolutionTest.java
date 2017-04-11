package lzhou.programmingtest.leetcode.test364;

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
    @Parameters(name = "{index}: depthSumInverse({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new NestedIntegerImpl(1), 1},
                 {new NestedIntegerImpl(900), 900},
                 {new NestedIntegerImpl(
                    Arrays.asList(
                        new NestedIntegerImpl(1),
                        new NestedIntegerImpl(
                            Arrays.asList(
                                new NestedIntegerImpl(2),
                                new NestedIntegerImpl(3))))),
                    7},
                    
                 {new NestedIntegerImpl(
                    Arrays.asList(
                        new NestedIntegerImpl(1),
                        new NestedIntegerImpl(
                            Arrays.asList(
                                new NestedIntegerImpl(2),
                                new NestedIntegerImpl(3))),
                        new NestedIntegerImpl(5),
                        new NestedIntegerImpl(9))),
                    35},
                 {new NestedIntegerImpl(
                    Arrays.asList(
                        new NestedIntegerImpl(3),
                        new NestedIntegerImpl(
                            Arrays.asList(
                                new NestedIntegerImpl(
                                    Arrays.asList(
                                        new NestedIntegerImpl(1)
                                        )),
                                new NestedIntegerImpl(2)))
                    )),
                    14},
                // Haven's run the agains the online checker. Not sure what will happen when a list is empty.
                 {new NestedIntegerImpl(
                    Arrays.asList(
                        new NestedIntegerImpl(2),
                        new NestedIntegerImpl(
                            Arrays.asList(
                                new NestedIntegerImpl(
                                    Arrays.asList(
                                        )),
                                new NestedIntegerImpl(1)))
                    )),
                    8},
           });
    }
    private NestedInteger in;
    private int expected;

    public SolutionTest(NestedInteger in, int expected) {
        this.in = in;
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
        int actual = new Solution().depthSumInverse(in);
        assertThat(actual, is(expected));
    }
}
