package lzhou.programmingtest.leetcode.test542;

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
    @Parameters(name = "{index}: updateMatrix({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new Integer[][]{{0}}, new Integer[][]{{0}}},
                 {new Integer[][]{{0,1}}, new Integer[][]{{0,1}}},
                 {new Integer[][]{{0,1,1}}, new Integer[][]{{0,1,2}}},
                 {new Integer[][]{{1,1,1,0,1}}, new Integer[][]{{3,2,1,0,1}}},
                 {new Integer[][]{{1},{1},{1},{0},{1}}, new Integer[][]{{3},{2},{1},{0},{1}}},
                 {new Integer[][]{{0,1,1},{0,1,0},{1,1,1}}, new Integer[][]{{0,1,1},{0,1,0},{1,2,1}}},
           });
    }
    private List<List<Integer>> in;
    private Integer[][] expected;

    public SolutionTest(Integer[][] in, Integer[][] expected) {
        this.in = new ArrayList<List<Integer>>();
        for (int i=0; i<in.length; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j=0; j<in[0].length; ++j) {
                row.add(in[i][j]);
            }
            this.in.add(row);
        }
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
        List<List<Integer>> actual = new Solution().updateMatrix(in);
        for (int i=0; i<expected.length; ++i) {
            for (int j=0; j<expected[0].length; ++j) {
                assertThat(actual.get(i).get(j), is(expected[i][j]));
            }
        }
    }
}
