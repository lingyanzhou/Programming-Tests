package lzhou.programmingtest.lintcode.test367;

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
    @Parameters(name = "{index}: evaluateExpression({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new String[]{"4", "*", "3", "-", "1"}, 11},
                 {new String[]{"4", "*", "3", "+", "1"}, 13},
                 {new String[]{"4", "*", "3", "/", "2"}, 6},
                 {new String[]{"4", "*", "3", "*", "2"}, 24},
                 
                 {new String[]{"13", "/", "3", "-", "1"}, 3},
                 {new String[]{"13", "/", "3", "+", "1"}, 5},
                 {new String[]{"13", "/", "3", "/", "2"}, 2},
                 {new String[]{"13", "/", "3", "*", "2"}, 8},
                 
                 {new String[]{"4", "+", "3", "-", "1"}, 6},
                 {new String[]{"4", "+", "3", "+", "1"}, 8},
                 {new String[]{"4", "+", "3", "/", "2"}, 5},
                 {new String[]{"4", "+", "3", "*", "2"}, 10},
                 {new String[]{"(","4", "+", "3", ")","/", "2"}, 3},
                 {new String[]{"(","4", "+", "3", ")","*", "2"}, 14},
                 
                 {new String[]{"4", "-", "3", "-", "1"}, 0},
                 {new String[]{"4", "-", "3", "+", "1"}, 2},
                 {new String[]{"4", "-", "3", "/", "2"}, 3},
                 {new String[]{"4", "-", "3", "*", "2"}, -2},
                 {new String[]{"(","4", "-", "3", ")","/", "2"}, 0},
                 {new String[]{"(","4", "-", "3", ")","*", "2"}, 2},
                 
                 {new String[]{"(","4", "-", "3", ")","*",
                               "(","4", "+", "3", ")"}, 7},
                 
                 {new String[]{"4", "*", "3", "-", "1"}, 11},
                 {new String[]{"2", "*", "6", "-", "(",
                               "23", "+", "7", ")", "/",
                               "(", "1", "+", "2", ")"}, 2},
           });
    }
    private String[] expression;
    private int expected;

    public SolutionTest(String[] expression, int expected) {
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
        int actual = new Solution().evaluateExpression(expression);
        assertThat(actual, is(expected));
    }
}
