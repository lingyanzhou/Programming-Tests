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
public class SuffixTrieOccurrencesTest {
    @Parameters(name = "{index}: SuffixTrie.of({0}).occurrences({1}) -> {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {"", "",1},
                 {"a", "a",1},
                 {"ab", "a",1},
                 {"ab", "b",1},
                 {"ab", "ab",1},
                 {"ab", "aba",0},
                 {"ab", "ba",0},
                 {"ababba", "a",3},
                 {"ababba", "aba",1},
                 {"ababba", "abba",1},
                 {"ababba", "ba",2},
                 {"ababba", "ab",2},
                 {"ababba", "bb",1},
                 {"ababba", "abab",1},
                 {"ababba", "ababb",1},
                 {"ababba", "ababba",1},
                 {"ababba", "aa",0},
                 {"ababba", "bbb",0},
                 {"ababba", "b",3},
                 {"ababba", "bb",1},
           });
    }
    private String s;
    private String t;
    private int expected;

    public SuffixTrieOccurrencesTest(String s, String t, int expected) {
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
        int actual = SuffixTrie.of(s).occurrences(t);
        assertThat(actual, is(expected));
    }
}
