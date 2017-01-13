package lzhou.programmingtest.lintcode.test399;

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
    @Parameters(name = "{index}: sortNutsAndBolts()")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {Arrays.asList(new String[]{"a","bb", "dddd", "ccc"}), Arrays.asList(new String[]{"hhhh","ee", "fff", "g"}), new ByLengthNBCompare()},
                 {Arrays.asList(new String[]{"a","bb", "cccc", "ddd"}), Arrays.asList(new String[]{"cccc","bb", "ddd", "a"}), new StringNBCompare()},
                 {Arrays.asList(new String[]{"a","bb", "dddd", "ccc"}), Arrays.asList(new String[]{"BB","A", "CCC", "DDDD"}), new StringIgnoreCaseNBCompare()},
           });
    }
    
    private String[] nuts;
    private String[] bolts;
    private NBCompare comparator;

    public SolutionTest(List<String> nuts, List<String> bolts, NBCompare comparator) {
        this.nuts = nuts.toArray(new String[0]);
        this.bolts = bolts.toArray(new String[0]);
        this.comparator = comparator;
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
        new Solution().sortNutsAndBolts(nuts, bolts, comparator);
        assetNutsAndBoltsMatches(nuts, bolts, comparator);
    }

    
    private void assetNutsAndBoltsMatches(String[] nuts, String[] bolts, NBCompare comparator) {
        assertThat(nuts, arrayWithSize(bolts.length));
        for (int i=0; i<nuts.length; ++i) {
            assertThat(comparator.cmp(nuts[i], bolts[i]), is(0));
        }
    }
}
