package lzhou.programmingtest.leetcode.test10;

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
    @Parameters(name = "{index}: isMatch({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"a", "a", true},
                 {"aa", "a", false},
                 {"a", "a*", true},
                 {"ab", "a*", false},
                 {"aa", "a.", true},
                 {"aaa", "a*", true},
                 {"aba", "a.a", true},
                 {"b", "a*b", true},
                 {"ab", "a*b", true},
                 {"aab", "a*b", true},
                 {"aabb", "a*b*", true},
                 {"aabb", "a*bb*", true},
                 {"aabb", "a*bb*b", true},
                 {"aabb", "a*bb*b.", false},
                 {"aabb", "c*a*bb*b", true},
                 {"aabb", "a*bb*b.*", true},
                 {"", "a*b*b*b*.*", true},
                 {"abc", ".*", true},
                 {"abc", "a*z*b*d*c*", true},
           });
    }
    private String s;
    private String p;
    private boolean expected;

    public SolutionTest(String s, String p, boolean expected) {
        this.s = s;
        this.p = p;
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
        boolean actual = new Solution().isMatch(s, p);
        assertThat(actual, is(expected));
    }
}
