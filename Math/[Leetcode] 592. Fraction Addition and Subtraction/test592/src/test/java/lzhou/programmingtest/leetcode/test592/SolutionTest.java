package lzhou.programmingtest.leetcode.test592;

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
    @Parameters(name = "{index}: fractionAddition({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"1/2","1/2"},
                 {"-1/2","-1/2"},
                 {"-2/4","-1/2"},
                 {"1/3-1/3","0/1"},
                 {"-1/3+1/3","0/1"},
                 {"-1/3-1/3","-2/3"},
                 {"-1/3-2/3","-1/1"},
                 {"1/3+5/3","2/1"},
                 {"1/2+5/3","13/6"},
                 {"1/2-5/3","-7/6"},
                 {"-1/2+5/3","7/6"},
                 {"-1/2-5/3","-13/6"},
                 {"-1/2-5/3+1/7","-85/42"},
                 {"-1/20+4/5","3/4"},
           });
    }
    private String expression;
    private String expected;

    public SolutionTest(String expression, String expected) {
        this.expression = expression;
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
        String actual = new Solution().fractionAddition(expression);
        assertThat(actual, is(expected));
    }
}
