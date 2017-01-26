package lzhou.programmingtest.leetcode.test87;

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
    @Parameters(name = "{index}: isScramble({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"a","a", true},
                 {"ab","aa", false},
                 {"ab","ab", true},
                 {"ab","ba", true},
                 {"bac","cab", true},
                 {"bac","acb", true},
                 {"bac","abc", true},
                 {"bac","bca", true},
                 {"ebac","cabe", true},
                 {"bace","ceab", true},
                 {"great","rgeat", true},
                 {"great","ratge", false},
           });
    }
    private String s1;
    private String s2;
    private boolean expected;

    public SolutionTest(String s1, String s2, boolean expected) {
        this.s1 = s1;
        this.s2 = s2;
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
        boolean actual = new Solution().isScramble(s1, s2);
        assertThat(actual, is(expected));
    }
}
