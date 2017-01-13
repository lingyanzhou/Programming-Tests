package lzhou.programmingtest.leetcode.test282;

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
    @Parameters(name = "{index}: addOperators({0},{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {"1", 0, new String[]{}},
                 {"1", 1, new String[]{"1"}},
                 {"12", 1, new String[]{}},
                 {"12", -1, new String[]{"1-2"}},
                 {"12", 2, new String[]{"1*2"}},
                 {"12", 3, new String[]{"1+2"}},
                 {"12", 10, new String[]{}},
                 {"12", 12, new String[]{"12"}},
                 {"12", 13, new String[]{}},
                 {"123", -4, new String[]{"1-2-3"}},
                 {"123", -1, new String[]{"1*2-3"}},
                 {"123", 0, new String[]{"1+2-3"}},
                 {"123", -5, new String[]{"1-2*3"}},
                 {"123", 6, new String[]{"1+2+3","1*2*3"}},
                 {"123", -22, new String[]{"1-23"}},
                 {"123", 23, new String[]{"1*23"}},
                 {"123", 24, new String[]{"1+23"}},
                 {"123", 9, new String[]{"12-3"}},
                 {"123", 15, new String[]{"12+3"}},
                 {"123", 36, new String[]{"12*3"}},
                 {"123", 123, new String[]{"123"}},
                 {"123", 6, new String[]{"1+2+3", "1*2*3"}},
                 {"232", 8, new String[]{"2*3+2", "2+3*2"}},
                 {"105", 5, new String[]{"1*0+5","10-5"}},
                 {"00", 0, new String[]{"0+0", "0-0", "0*0"}},
                 {"200", 0, new String[]{"2*0+0","2*0-0","20*0","2*0*0"}},
                 {"3456237490", 9191, new String[]{}},
                 {"3456237490", 345623749, new String[]{"345623749+0","345623749-0"}},
           });
    }
    private String num;
    private int target;
    private String[] expected;

    public SolutionTest(String num, int target, String[] expected) {
        this.num = num;
        this.target = target;
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
        List<String> actual = new Solution().addOperators(num, target);
        assertThat(actual, containsInAnyOrder(expected));
    }
}
