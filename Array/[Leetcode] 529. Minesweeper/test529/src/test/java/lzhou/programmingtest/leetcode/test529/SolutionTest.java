package lzhou.programmingtest.leetcode.test529;

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
    @Parameters(name = "{index}: updateBoard({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new char[][]{{'M','E'},{'E','E'}}, new int[]{0,0}, new char[][]{{'X','E'},{'E','E'}}},
                 {new char[][]{{'M','E'},{'E','E'}}, new int[]{1,0}, new char[][]{{'M','E'},{'1','E'}}},
                 {new char[][]{{'M','E'},{'E','E'}}, new int[]{1,1}, new char[][]{{'M','E'},{'E','1'}}},
                 {new char[][]{{'M','E','E'},{'E','E','E'}}, new int[]{1,2}, new char[][]{{'M','1','B'},{'E','1','B'}}},
                 {new char[][]{{'M','M','E'},{'E','E','E'}}, new int[]{1,1}, new char[][]{{'M','M','E'},{'E','2','E'}}},
                 {new char[][]{{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}},
                     new int[]{0,0},
                     new char[][]{{'B', '1', 'E', '1', 'B'},{'B', '1', 'M', '1', 'B'},{'B', '1', '1', '1', 'B'},{'B', 'B', 'B', 'B', 'B'}}},
           });
    }
    private char[][] board;
    private int[] click;
    private char[][] expected;

    public SolutionTest(char[][] board, int[] click, char[][] expected) {
        this.board = board;
        this.click = click;
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
        board = new Solution().updateBoard(board, click);
        assertThat(board.length, is(expected.length));
        for (int i=0; i<board.length; ++i) {
            assertThat(board[i].length, is(expected[i].length));
            for (int j=0; j<board[i].length; ++j) {
                assertThat(board[i][j], is(expected[i][j]));
            }
        }
    }
}
