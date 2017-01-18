package lzhou.programmingtest.leetcode.test139;

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
    @Parameters(name = "{index}: wordBreak({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"a", Arrays.asList(new String[]{"a"}), true},
                 {"aa", Arrays.asList(new String[]{"a"}), true},
                 {"ab", Arrays.asList(new String[]{"a"}), false},
                 {"lintcode", Arrays.asList(new String[]{"lint", "code"}), true},
                 {"niconiconi", Arrays.asList(new String[]{"nico", "ni"}), true},
                 {"niconiconi", Arrays.asList(new String[]{"ni","co"}), true},
                 {"niconiconi", Arrays.asList(new String[]{"nico"}), false},
           });
    }
    private String s;
    private List<String> dict;
    private boolean expected;

    public SolutionTest(String s, List<String> dict, boolean expected) {
        this.s = s;
        this.dict = dict;
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
        boolean actual = new Solution().wordBreak(s, dict);
        assertThat(actual, is(expected));
    }
}
