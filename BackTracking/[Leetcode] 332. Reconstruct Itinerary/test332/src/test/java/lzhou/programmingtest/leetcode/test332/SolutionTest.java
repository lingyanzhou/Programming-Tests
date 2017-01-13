package lzhou.programmingtest.leetcode.test332;

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
    @Parameters(name = "{index}: findItinerary({0})={1} ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new String[][]{}, new String[]{"JFK"}},
                 {new String[][]{{"JFK", "A"},{"JFK", "B"},{"A", "JFK"}}, new String[]{"JFK", "A", "JFK", "B"}},
                 {new String[][]{{"JFK", "A"},{"JFK", "A"},{"A", "JFK"}}, new String[]{"JFK", "A", "JFK", "A"}},
                 {new String[][]{{"JFK", "A"},{"A", "B"},{"B", "JFK"},{"JFK", "B"},{"B", "A"},{"A", "JFK"}},
                     new String[]{"JFK", "A", "B", "A", "JFK", "B", "JFK"}},
                 {new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}},
                    new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}},
                 {new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}},
                    new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}},
                 {new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}},
                     new String[]{"JFK","ATL","JFK","SFO","ATL","SFO"}},
           });
    }
    private String[][] tickets;
    private String[] expected;

    public SolutionTest(String[][] tickets, String[] expected) {
        this.tickets = tickets;
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
        List<String> actual = new Solution().findItinerary(tickets); 
        assertThat(actual, contains(expected));
    }
}
