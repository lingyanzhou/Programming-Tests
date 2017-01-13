package lzhou.programmingtest.leetcode.test435;

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
    @Parameters(name = "{index}: eraseOverlapIntervals({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{1,2},{2,3}}, 0},
                 {new int[][]{{1,2},{2,3},{3,4},{1,3}}, 1},
                 {new int[][]{{1,2},{1,2},{1,2}}, 2},
                 {new int[][]{{0,4},{1,2},{2,3}}, 1},
                 {new int[][]{{-100,-87},{-99,-44},{-98,-19},{-97,-33},{-96,-60},{-95,-17},{-94,-44},{-93,-9},{-92,-63},{-91,-76},{-90,-44},{-89,-18},{-88,10},{-87,-39},{-86,7},{-85,-76},{-84,-51},{-83,-48},{-82,-36},{-81,-63},{-80,-71},{-79,-4},{-78,-63},{-77,-14},{-76,-10},{-75,-36},{-74,31},{-73,11},{-72,-50},{-71,-30},{-70,33},{-69,-37},{-68,-50},{-67,6},{-66,-50},{-65,-26},{-64,21},{-63,-8},{-62,23},{-61,-34},{-60,13},{-59,19},{-58,41},{-57,-15},{-56,35},{-55,-4},{-54,-20},{-53,44},{-52,48},{-51,12},{-50,-43},{-49,10},{-48,-34},{-47,3},{-46,28},{-45,51},{-44,-14},{-43,59},{-42,-6},{-41,-32},{-40,-12},{-39,33},{-38,17},{-37,-7},{-36,-29},{-35,24},{-34,49},{-33,-19},{-32,2},{-31,8},{-30,74},{-29,58},{-28,13},{-27,-8},{-26,45},{-25,-5},{-24,45},{-23,19},{-22,9},{-21,54},{-20,1},{-19,81},{-18,17},{-17,-10},{-16,7},{-15,86},{-14,-3},{-13,-3},{-12,45},{-11,93},{-10,84},{-9,20},{-8,3},{-7,81},{-6,52},{-5,67},{-4,18},{-3,40},{-2,42},{-1,49},{0,7},{1,104},{2,79},{3,37},{4,47},{5,69},{6,89},{7,110},{8,108},{9,19},{10,25},{11,48},{12,63},{13,94},{14,55},{15,119},{16,64},{17,122},{18,92},{19,37},{20,86},{21,84},{22,122},{23,37},{24,125},{25,99},{26,45},{27,63},{28,40},{29,97},{30,78},{31,102},{32,120},{33,91},{34,107},{35,62},{36,137},{37,55},{38,115},{39,46},{40,136},{41,78},{42,86},{43,106},{44,66},{45,141},{46,92},{47,132},{48,89},{49,61}}, 139},
           });
    }
    private Interval[] intervals;
    private int expected;

    public SolutionTest(int[][] intervals, int expected) {
        this.intervals = new Interval[intervals.length];
        for (int i=0; i<intervals.length; ++i) {
            this.intervals[i] = new Interval(intervals[i][0], intervals[i][1]);
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
        int actual = new Solution().eraseOverlapIntervals(intervals);
        assertThat(actual, is(expected));
    }
}
