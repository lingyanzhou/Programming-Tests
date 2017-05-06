package lzhou.algorithm.suffixtrie;

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
public class SuffixTrieIsSuffixTest {
    @Parameters(name = "{index}: SuffixTrie.of({0}).isSuffix({1}) -> {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {"", "",true},
                 {"a", "a",true},
                 {"a", "",true},
                 {"a", "b",false},
                 {"a", "ba",false},
                 {"a", "ab",false},
                 {"a", "aa",false},
                 {"ab", "a",false},
                 {"ab", "",true},
                 {"ab", "b",true},
                 {"ab", "ab",true},
                 {"ab", "ba",false},
                 {"ab", "aab",false},
                 {"aba", "",true},
                 {"aba", "a",true},
                 {"aba", "ba",true},
                 {"aba", "aba",true},
                 {"aba", "bab",false},
                 {"aba", "baa",false},
                 {"aba", "aa",false},
                 {"abaa", "aa",true},
                 {"abaa", "a",true},
                 {"abaa", "baa",true},
                 {"abaa", "aba",false},
                 {"abaa", "ba",false},
                 {"abaa", "abaa",true},
           });
    }
    private String s;
    private String t;
    private boolean expected;

    public SuffixTrieIsSuffixTest(String s, String t, boolean expected) {
        this.s = s;
        this.t = t;
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
        boolean actual = SuffixTrie.of(s).isSuffix(t);
        assertThat(actual, is(expected));
    }
}
