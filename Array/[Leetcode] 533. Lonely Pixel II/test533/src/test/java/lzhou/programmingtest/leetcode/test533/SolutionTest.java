package lzhou.programmingtest.leetcode.test533;

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
    @Parameters(name = "{index}: findBlackPixel({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 //{new String[]{"B"}, 1, 1},
                 {new String[]{"WB","BW"}, 1, 2},
                 //{new String[]{"WB","BB"}, 2, 0},
                 //{new String[]{"WB","WB"}, 1, 0},
                 //{new String[]{"WB","WB"}, 2, 0},
                 //{new String[]{"WBWB","WBWB","BWBW"}, 2, 4},
                 //{new String[]{"WBWBWB","WBWBWB","BBWWBW","WBWBWB"}, 3, 6},
                 //{new String[]{"WBWBWB","WBWBWB","BBWBBB","WBWBWB"}, 3, 0},
           });
    }
    private char[][] board;
    private int n;
    private int expected;

    public SolutionTest(String[] board, int n, int expected) {
        this.board = Arrays.stream(board).map(s->s.toCharArray()).toArray(size->new char[size][]);
        this.n = n;
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
        int actual = new Solution().findBlackPixel(board, n);
        assertThat(actual, is(expected));
    }
}
