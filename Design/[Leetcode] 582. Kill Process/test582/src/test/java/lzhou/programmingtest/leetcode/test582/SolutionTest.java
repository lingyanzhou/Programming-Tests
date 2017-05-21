package lzhou.programmingtest.leetcode.test582;

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
    @Parameters(name = "{index}: killProcess({0},{1},{2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(0), Arrays.asList(0), 0, new Integer[]{0}},
                 {Arrays.asList(2,3), Arrays.asList(0,0), 3, new Integer[]{3}},
                 {Arrays.asList(2,3), Arrays.asList(3,0), 3, new Integer[]{3,2}},
                 {Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 5, new Integer[]{5,10}},
                 {Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 3, new Integer[]{1,3,5,10}},
                 {Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 1, new Integer[]{1}},
                 {Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 10, new Integer[]{10}},
           });
    }
    private List<Integer> pid;
    private List<Integer> ppid;
    private int kill;
    private Integer[] expected;

    public SolutionTest(List<Integer> pid, List<Integer> ppid, int kill, Integer[] expected) {
        this.pid = pid;
        this.ppid = ppid;
        this.kill = kill;
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
        List<Integer> actual = new Solution().killProcess(pid, ppid, kill);
        assertThat(actual, containsInAnyOrder(expected));
    }
}
