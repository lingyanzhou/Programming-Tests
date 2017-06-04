package lzhou.programmingtest.leetcode.test591;

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
    @Parameters(name = "{index}: isValid({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"<DIV>This is the first line <![CDATA[<div>]]></DIV>", true},
                 {"<DIV>This <DIV>is</DIV> the first line <![CDATA[</DIV>]]></DIV>", true},
                 {"<DIV>This </DIV><DIV></DIV>", false},
                 {"<DIV>This <> is not ok </DIV>", false},
                 {"<DIV>This < is not ok </DIV>", false},
                 {"<DIV>>>This >>>> is ok </DIV>", true},
                 {"<DIV>This <emph>is</emph> not ok </DIV>", false},
                 {"<DIV>This <EMPH>is</EMPH> ok </DIV>", true},
           });
    }
    private String in;
    private boolean expected;

    public SolutionTest(String in, boolean expected) {
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
        boolean actual = new Solution().isValid(in);
        assertThat(actual, is(expected));
    }
}
