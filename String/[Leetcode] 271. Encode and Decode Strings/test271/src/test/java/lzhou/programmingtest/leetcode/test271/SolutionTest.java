package lzhou.programmingtest.leetcode.test271;

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
    @Parameters(name = "{index}: {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new String[]{"1"}},
                 {new String[]{"1","2"}},
                 {new String[]{"1","2","\n"}},
                 {new String[]{"1","a\0a","a\0a"}},
                 {new String[]{"1","a\0","\0a"}},
                 {new String[]{"\0","\0","\0"}},
                 {new String[]{"\\a\\a","\0","\0"}},
                 {new String[]{"\\a\\a","\\","\\"}},
                 {new String[]{"\\a\\a\0","\0\\\\","\\\\"}},
                 {new String[]{"\\a\\\\\0","\0\\\\","\\\\"}},
           });
    }
    private List<String> strs;
    private String[] expected;

    public SolutionTest(String[] strs) {
        this.strs = Arrays.asList(strs);
        this.expected = strs;
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
        String data = new Codec().encode(strs);
        List<String> actual = new Codec().decode(data);
        assertThat(actual, hasSize(expected.length));
        for (int i=0; i<actual.size(); ++i) {
            assertThat(actual.get(i), is(expected[i]));
        }
    }
}
