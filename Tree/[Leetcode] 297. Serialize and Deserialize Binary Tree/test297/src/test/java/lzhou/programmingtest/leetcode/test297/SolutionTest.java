package lzhou.programmingtest.leetcode.test297;

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
    @Parameters(name = "{index}: serialize(deserialize({0}))={0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {""},
                 {"1,"},
                 {"1,2,3,"},
                 {"1,#,3,"},
                 {"1,3,"},
                 {"-1,0,1,"},
                 {"1,2,3,#,#,4,5,"},
                 {"1,2,3,#,#,4,5,0,1,#,2,99,30,#,-30,-100,#,#,2,#,2,"},
           });
    }
    private String data;

    public SolutionTest(String data) {
        this.data = data;
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
        Codec codec = new Codec();
        String actual = codec.serialize(codec.deserialize(data));
        assertThat(actual, is(data));
    }
}
