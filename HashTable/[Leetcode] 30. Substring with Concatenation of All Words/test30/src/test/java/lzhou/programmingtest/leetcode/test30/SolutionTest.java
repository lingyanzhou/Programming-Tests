package lzhou.programmingtest.leetcode.test30;

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
    @Parameters(name = "{index}: findSubstring({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"Leetcode", new String[]{"Leet","code"}, new Integer[]{0}},
                 {"barfoothefoobarman", new String[]{"foo","bar"}, new Integer[]{0, 9}},
                 {"barfoobarthefoofoobarbarman", new String[]{"foo","bar"}, new Integer[]{0,3,15}},
                 {"aaaaaaaaaaaaaaaaaaaaaaa",new String[]{"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"}, new Integer[]{}},
                 {"aaa", new String[]{"a","a"}, new Integer[]{0,1}},
           });
    }
    private String s;
    private String[] words;
    private Integer[] expected;

    public SolutionTest(String s, String[] words, Integer[] expected) {
        this.s = s;
        this.words = words;
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
        List<Integer> actual = new Solution().findSubstring(s, words);
        if (expected.length>0) {
            assertThat(actual, contains(expected));
        } else {
            assertThat(actual, hasSize(0));
        }
    }
}
