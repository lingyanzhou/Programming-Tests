package lzhou.programmingtest.leetcode.test286;

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
    final static int INF = Integer.MAX_VALUE;
    @Parameters(name = "{index}: wallsAndGates({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{INF, -1, 0, INF}},
                     new int[][]{{INF, -1, 0, 1}}},
                 {new int[][]{{INF, -1, 0, INF},
                              {0, -1, INF, INF}},
                     new int[][]{{1, -1, 0, 1},
                              {0, -1, 1, 2}}},
                 {new int[][]{{0, INF, INF, 0}},
                     new int[][]{{0, 1, 1, 0}}},
                 {new int[][]{{INF, -1, 0, INF},
                              {INF, INF, INF, -1},
                              {INF, -1, INF, -1},
                              {0, -1, INF, INF}},
                     new int[][]{{3, -1, 0, 1},
                              {2, 2, 1, -1},
                              {1, -1, 2, -1},
                              {0, -1, 3, 4}}},
           });
    }
    private int[][] rooms;
    private int[][] expected;

    public SolutionTest(int[][] rooms, int[][] expected) {
        this.rooms = rooms;
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
        new Solution().wallsAndGates(rooms);

        int n=rooms.length;
        for (int i=0; i<n; ++i) {
            assertArrayEquals(expected, rooms);
        }
    }
}
