package lzhou.programmingtest.lintcode.test77;

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
    @Parameters(name = "{index}: longestCommonSubsequence({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"", "", 0}, {"a", "", 0}, {"", "a", 0},
                 {"bcd", "agt", 0}, {"erwerwe", "cvzx", 0}, {"wdbghi", "okmart", 0},
                 {"a", "a", 1}, {"ab", "a", 1}, {"abc", "adbec", 3},
                 {"ABCD", "EDCA", 1}, {"ABCD", "EACB", 2},
                 {"AGGTAB", "GXTXAYB", 4}, {"ABCDGH", "AEDFHR", 3}, {"aaca", "acaac", 3}
           });
    }
    private String A;
    private String B;
    private int expected;

    public SolutionTest(String A, String B, int expected) {
        this.A = A;
        this.B = B;
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
        int actual = new Solution().longestCommonSubsequence(A, B);
        assertThat(actual, is(expected));
    }
}
