package lzhou.programmingtest.leetcode.test79;

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
    @Parameters(name = "{index}: exist({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new String[]{}, "", false},
                 {new String[]{""}, "", false},
                 {new String[]{"a"}, "a", true},
                 {new String[]{"ac","cb"}, "ab", false},
                 {new String[]{"ab","cc"}, "ab", true},
                 {new String[]{"ac","bc"}, "ab", true},
                 {new String[]{"ac","bc"}, "aba", false},
                 {new String[]{"ac","ba"}, "aba", true},
                 {new String[]{"ac","ba"}, "acab", true},
                 {new String[]{"ac","ba"}, "acaba", false},
                 {new String[]{"ABCE","SFCS","ADEE"}, "ABCCED", true}
           });
    }
    private char[][] board;
    private String word;
    private boolean expected;

    public SolutionTest(String[] board, String word, boolean expected) {
        this.board = new char[board.length][];
        for (int i=0; i<board.length; ++i) {
            this.board[i] = board[i].toCharArray();
        }
        this.word = word;
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
        boolean actual = new Solution().exist(board, word);
        assertThat(actual, is(expected));
    }
}
