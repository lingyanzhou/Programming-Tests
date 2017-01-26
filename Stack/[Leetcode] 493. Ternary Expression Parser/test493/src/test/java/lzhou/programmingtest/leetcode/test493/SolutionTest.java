package lzhou.programmingtest.leetcode.test493;

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
    @Parameters(name = "{index}: parseTernary({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {"T", "T"}, //0
                 {"F", "F"},
                 {"1", "1"},
                 {"T?1:2", "1"},
                 {"F?1:2", "2"},
                 {"T?F:T", "F"},//5
                 {"F?F:T", "T"},
                 {"T?T?1:2:3", "1"},
                 {"T?F?1:2:3", "2"},
                 {"F?T?1:2:3", "3"},
                 {"F?F?1:2:3", "3"},//10
                 {"T?1:T?2:3", "1"},
                 {"T?1:F?2:3", "1"},
                 {"F?1:T?2:3", "2"},
                 {"F?1:F?2:3", "3"},
                 {"T?T?1:2:T?3:4", "1"},//15
                 {"T?T?1:2:F?3:4", "1"},
                 {"T?F?1:2:T?3:4", "2"},
                 {"T?F?1:2:F?3:4", "2"},
                 {"F?T?1:2:T?3:4", "3"},
                 {"F?T?1:2:F?3:4", "4"},//20
                 {"F?F?1:2:T?3:4", "3"},
                 {"F?F?1:2:F?3:4", "4"},
           });
    }
    private String in;
    private String expected;

    public SolutionTest(String in, String expected) {
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
        String actual = new Solution().parseTernary(in);
        assertThat(actual, is(expected));
    }
}
