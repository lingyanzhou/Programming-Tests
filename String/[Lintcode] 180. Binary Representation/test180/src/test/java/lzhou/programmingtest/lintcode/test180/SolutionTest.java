package lzhou.programmingtest.lintcode.test180;

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
    @Parameters(name = "{index}: binaryRepresentation({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"0", "0"},
                 {"1", "1"},
                 {"123123123123123123", "110110101011010111101010000000001011000111111001110110011"},
                 {"0.5", "0.1"},
                 {"3.72", "ERROR"},
                 {"0.123123", "ERROR"},
                 {"99999999999.123123", "ERROR"},
                 {"99999999999.25", "1011101001000011101101110011111111111.01"},
                 {"120.00000000023283064365386962890625", "1111000.00000000000000000000000000000001"},
                 {"0.000000000116415321826934814453125", "ERROR"},
           });
    }
    private String in;
    private String expected;

    public SolutionTest(String in, String expected) {
        this.in = in;
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
        String actual = new Solution().binaryRepresentation(in);
        assertThat(actual, is(expected));
    }
}
