package lzhou.programmingtest.leetcode.test460;

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
    public void test_0() {
        LFUCache cache = new LFUCache(0);
        cache.put(0,0);
        assertThat(cache.get(0), is(-1));
        cache.put(1,0);
        assertThat(cache.get(1), is(-1));
        cache.put(2,0);
        assertThat(cache.get(2), is(-1));
    }

    @Test
    public void test_1() {
        LFUCache cache = new LFUCache(3);
        //get(1),set(5,50),get(1),get(2),get(3),get(4),get(5)]
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);
        assertThat(cache.get(1), is(10));
        cache.put(4,40);
        assertThat(cache.get(4), is(40));
        assertThat(cache.get(3), is(30));
        assertThat(cache.get(2), is(-1));
        assertThat(cache.get(1), is(10));
        cache.put(5,50);
        assertThat(cache.get(1), is(10));
        assertThat(cache.get(2), is(-1));
        assertThat(cache.get(3), is(30));
        assertThat(cache.get(4), is(-1));
        assertThat(cache.get(5), is(50));
    }
}
