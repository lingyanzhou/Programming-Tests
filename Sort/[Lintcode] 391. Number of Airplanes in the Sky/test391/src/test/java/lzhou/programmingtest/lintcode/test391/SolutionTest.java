package lzhou.programmingtest.lintcode.test391;

import java.util.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    
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
    public void testSolutionEmpty()
    {
        List<Interval> intervals = toIntervalList(new int[][]{});
        int expected = 0;
        int actual = new Solution().countOfAirplanes(intervals);
        assertEquals( expected, actual);
    }

    @Test
    public void test_same()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{1,4},{3,4}});
        int expected = 2;
        int actual = new Solution().countOfAirplanes(intervals);
        assertEquals( expected, actual);
    }

    @Test
    public void testSolutionNotOrdered()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{-1,0},{2,3},{5,7},{3,4}});
        int expected = 1;
        int actual = new Solution().countOfAirplanes(intervals);
        assertEquals( expected, actual);
    }

    @Test
    public void test_allHeadToTail()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{2,3},{0,1},{-1,0},{3,4},{1,2}});
        int expected = 1;
        int actual = new Solution().countOfAirplanes(intervals);
        assertEquals( expected, actual);
    }

    @Test
    public void test_allsame()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{3,4},{3,4},{3,4}});
        int expected = 3;
        int actual = new Solution().countOfAirplanes(intervals);
        assertEquals( expected, actual);
    }

    @Test
    public void test_FullyCoverOneInterval()
    {
        List<Interval> intervals = toIntervalList(new int[][]{{0,10},{3,4},{5,6}});
        int expected = 2;
        int actual = new Solution().countOfAirplanes(intervals);
        assertEquals( expected, actual);
    }

    private List<Interval> toIntervalList(int[][] in) {
        List<Interval> ret = new ArrayList<Interval>(in.length);
        for (int i=0; i<in.length; ++i) {
            ret.add(new Interval(in[i][0], in[i][1]));
        }
        return ret;
    }
    
    private void assertIntervalListEquals(List<Interval> expected, List<Interval> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals(expected.get(i).start, actual.get(i).start);
            assertEquals(expected.get(i).end, actual.get(i).end);
        }
    }
}
