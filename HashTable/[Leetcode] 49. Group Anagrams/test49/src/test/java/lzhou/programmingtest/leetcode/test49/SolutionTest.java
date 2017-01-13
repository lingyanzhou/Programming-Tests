package lzhou.programmingtest.leetcode.test49;

import java.util.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    
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
    public void test_method_1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[][] expected = {{"tan","nat"},{"bat"},{"eat","tea","ate"}};
        List<List<String>> actual = new Solution().groupAnagrams(strs);
        assertThat(actual, hasSize(3));
        assertThat(actual.get(0), anyOf(containsInAnyOrder(expected[0]), containsInAnyOrder(expected[1]), containsInAnyOrder(expected[2])));
        assertThat(actual.get(1), anyOf(containsInAnyOrder(expected[0]), containsInAnyOrder(expected[1]), containsInAnyOrder(expected[2])));
        assertThat(actual.get(2), anyOf(containsInAnyOrder(expected[0]), containsInAnyOrder(expected[1]), containsInAnyOrder(expected[2])));
    }
}
