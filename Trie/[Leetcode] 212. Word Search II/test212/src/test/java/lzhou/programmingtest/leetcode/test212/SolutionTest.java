package lzhou.programmingtest.leetcode.test212;

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
    @Parameters(name = "{index}: findWords({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new String[]{"abce","sfcs","adee"}, new String[]{"abcb","ninechapter","lintcode"}, new String[]{}}, //Test they don't look behind
                 {new String[]{"doaf","aaai","dcan"}, new String[]{"doa","dad","dgdg","can","again"}, new String[]{"can","dad","doa"}}, //Test no duplicates
                 {new String[]{"oaan","etae","ihkr","iflv"}, new String[]{"oath","pea","eat","rain"}, new String[]{"oath","eat"}},
           });
    }
    private char[][] board;
    private String[] words;
    private String[] expected;

    public SolutionTest(String[] board, String[] words, String[] expected) {
        this.board = new char[board.length][];
        for (int i=0; i<board.length; ++i) {
            this.board[i] = board[i].toCharArray();
        }
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
        List<String> actual = new Solution().findWords(board, words);
        assertThat(actual, containsInAnyOrder(expected));
    }
}
