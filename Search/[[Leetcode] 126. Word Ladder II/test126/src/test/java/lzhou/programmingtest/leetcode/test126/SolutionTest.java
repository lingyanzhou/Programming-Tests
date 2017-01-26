package lzhou.programmingtest.leetcode.test126;

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
    @Parameters(name = "{index}: findLadders({0},{1},{2})")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"aaa", "bbb", new HashSet<String>(Arrays.asList(new String[]{"aaa","aab","abb","bbb"})), 1, 4},
                 {"aaa", "bbb", new HashSet<String>(Arrays.asList(new String[]{"aaa","aab","abb","bbb","aba"})), 2, 4},
                 {"aaa", "bbb", new HashSet<String>(Arrays.asList(new String[]{"aaa","aab","abb","bbb","baa","bba"})), 2, 4},
                 {"aaa", "bbb", new HashSet<String>(Arrays.asList(new String[]{"aaa","aab","abb","bbb","aba","baa","bba"})), 4, 4},
                 {"hit", "cog", new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"})), 2, 5},
           });
    }
    private String start;
    private String end;
    private Set<String> dict;
    private int expectedPathCount;
    private int expectedPathLen;

    public SolutionTest(String start, String end, Set<String> dict, int expectedPathCount, int expectedPathLen) {
        this.start = start;
        this.end = end;
        this.dict = dict;
        this.expectedPathCount = expectedPathCount;
        this.expectedPathLen = expectedPathLen;
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
        List<List<String>> actual = new Solution().findLadders(start, end, dict);
        assertThat(actual, hasSize(expectedPathCount));
        for(List<String> l :actual) {
            assertThat(l, hasSize(expectedPathLen));
        }
    }
}
