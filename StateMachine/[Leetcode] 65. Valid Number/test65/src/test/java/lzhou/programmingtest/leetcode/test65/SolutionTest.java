package lzhou.programmingtest.leetcode.test65;

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
    @Parameters(name = "{index}: isNumber({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                {"3", true},
                {".3", true},
                {"3.  ", true},
                {".", false},
                {"  3.2", true},
                {" 0.23 " , true},
                {"3  a", false},
                {"3  .1 2", false},
                {"3.12e1", true},
                {"3.12e", false},
                {"3.12e1.1", false},
                {"3.e1", true},
                {".e1", false},
                {".12e1", true},
                {"-3.12e1", true},
                {" -3.12e1", true},
                {"- 3.12e1", false},
                {"  -3.  ", true},
                {"--1", false},
                {"1..23123", false},
                {"1.2.3", false},
                {"1.E1", false},
                {"1.ee1", false},
                {" -1231233323123.1213123123", true},
                {" -123e123123123123        ", true},
                {" 23123.12312e-123 ", true},
                {" -23123.12312e-123 ", true},
           });
    }
    private String s;
    private boolean expected;

    public SolutionTest(String s, boolean expected) {
        this.s = s;
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
        boolean actual = new Solution().isNumber(s);
        assertThat(actual, is(expected));
    }
}
