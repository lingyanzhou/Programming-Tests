package lzhou.programmingtest.leetcode.test394;

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
    @Parameters(name = "{index}: decodeString({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"", ""},
                 {"abc", "abc"},
                 {"3[ab]c", "abababc"},
                 {"3[abc]", "abcabcabc"},
                 {"ab3[c]", "abccc"},
                 {"ab2[2[c]]", "abcccc"},
                 {"a2[2[b]c]", "abbcbbc"},
                 {"2[a3[b]c]", "abbbcabbbc"},
                 {"2[z3[a]z3[b]z3[c]z]", "zaaazbbbzccczzaaazbbbzcccz"},
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
        String actual = new Solution().decodeString(in);
        assertThat(actual, is(expected));
    }
}
