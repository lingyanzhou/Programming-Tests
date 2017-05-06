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
public class SuffixTrieLongestRepeatTest {
    @Parameters(name = "{index}: SuffixTrie.of({0}).longestRepeat() -> {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {"", 0},
                 {"a", 0},
                 {"aa", 1},
                 {"aba", 1},
                 {"aaa", 2},
                 {"aabba", 1},
                 {"aaaa", 3},
                 {"aabaa", 2},
                 {"aabaab", 3},
                 {"aabaca", 1},
                 {"bababa", 4},
                 {"abcde", 0},
           });
    }
    private String s;
    private int expected;

    public SuffixTrieLongestRepeatTest(String s,  int expected) {
        this.s = s;
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
        int actual = SuffixTrie.of(s).longestRepeat();
        assertThat(actual, is(expected));
    }
}
