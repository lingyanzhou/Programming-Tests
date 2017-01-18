package lzhou.programmingtest.leetcode.test482;

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
    @Parameters(name = "{index}: licenseKeyFormatting({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"---", 1, ""},
                 {"--a-", 2, "A"},
                 {"1", 1, "1"},
                 {"a1-b", 2, "A-1B"},
                 {"a1C-b", 2, "A1-CB"},
                 {"a-1-C-b", 3, "A-1CB"},
                 {"ab-s-eedSe3D", 3, "A-BSE-EDS-E3D"},
                 {"2-4A0r7-4k", 4, "24A0-R74K"},
                 {"2-4A0r7-4k", 3, "24-A0R-74K"},
           });
    }
    private String S;
    private int K;
    private String expected;

    public SolutionTest(String S, int K, String expected) {
        this.S = S;
        this.K = K;
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
        String actual = new Solution().licenseKeyFormatting(S, K);
        assertThat(actual, is(expected));
    }
}
