package lzhou.programmingtest.leetcode.test43;

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
    @Parameters(name = "{index}: multiply({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"0","0","0"},
                 {"0","1","0"},
                 {"1","0","0"},
                 {"10","11","110"},
                 {"19","91","1729"},
                 {"999","12345","12332655"},
                 {"999999999","9999999999999999","9999999989999999000000001"},
                 {"999999999","10002020003004000500060000700890001","10002019993001980497056000200830000299109999"},
           });
    }
    private String num1;
    private String num2;
    private String expected;

    public SolutionTest(String num1, String num2, String expected) {
        this.num1 = num1;
        this.num2 = num2;
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
        String actual = new Solution().multiply(num1, num2);
        assertThat(actual, is(expected));
    }
}
