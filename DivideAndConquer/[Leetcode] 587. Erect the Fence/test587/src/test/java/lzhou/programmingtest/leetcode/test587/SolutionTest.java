package lzhou.programmingtest.leetcode.test587;

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
    @Parameters(name = "{index}: outerTrees({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new Point[]{new Point(0,0), new Point(0,4), new Point(0,2)},
                    new Point[]{new Point(0,0), new Point(0,4), new Point(0,2)}},
                 {new Point[]{new Point(0,0), new Point(4,0), new Point(2,0)},
                    new Point[]{new Point(0,0), new Point(4,0), new Point(2,0)}},
                 {new Point[]{new Point(0,0), new Point(4,0), new Point(4,4), new Point(0,4)},
                    new Point[]{new Point(0,0), new Point(4,0), new Point(4,4), new Point(0,4)}},
                 {new Point[]{new Point(1,1), new Point(2,2), new Point(3,3), new Point(0,2), new Point(2,4), new Point(4,2)},
                    new Point[]{new Point(1,1), new Point(0,2), new Point(2,4), new Point(4,2), new Point(3,3)}},
           });
    }
    private Point[] points;
    private Point[] expected;

    public SolutionTest(Point[] points, Point[] expected) {
        this.points = points;
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
        List<Point> actual = new Solution().outerTrees(points);
        assertThat(actual, containsInAnyOrder(expected));
    }
}
