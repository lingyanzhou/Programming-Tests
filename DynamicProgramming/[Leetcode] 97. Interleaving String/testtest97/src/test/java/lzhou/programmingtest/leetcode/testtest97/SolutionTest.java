package lzhou.programmingtest.leetcode.testtest97;

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
    @Parameters(name = "{index}: metisInterleavehod({0},{1},{2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"","","1", false},
                 {"","1","1", true},
                 {"1","","1", true},
                 {"1","1","11", true},
                 {"1","2","11", false},
                 {"1","2","21", true},
                 {"1","2","12", true},
                 {"22","1","212", true},
                 {"22","13","1223", true},
                 {"22","13","1232", true},
                 {"22","13","1322", true},
                 {"22","13","2213", true},
                 {"22","13","2123", true},
                 {"aabcc", "dbbca", "aadbbcbcac", true},
                 {"aabcc", "dbbca", "aadbbbaccc", false},
                 {"111221122112211", "11112222", "11111221111221212221212", true},
                 {"111221122112211", "11112222", "11211121111221212221212", false},
           });
    }
    private String s1;
    private String s2;
    private String s3;
    private boolean expected;

    public SolutionTest(String s1, String s2, String s3, boolean expected) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
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
        boolean actual = new Solution().isInterleave(s1, s2, s3);
        assertThat(actual, is(expected));
    }
}
