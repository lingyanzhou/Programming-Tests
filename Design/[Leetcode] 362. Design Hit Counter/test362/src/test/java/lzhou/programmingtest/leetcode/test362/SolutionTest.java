package lzhou.programmingtest.leetcode.test362;

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
    public void test_1() {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        assertThat(counter.getHits(1), is(1));
        counter.hit(1);
        assertThat(counter.getHits(1), is(2));
    }

    @Test
    public void test_2() {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        assertThat(counter.getHits(1), is(1));
        counter.hit(2);
        assertThat(counter.getHits(2), is(2));
        counter.hit(3);
        assertThat(counter.getHits(3), is(3));
        assertThat(counter.getHits(4), is(3));
        counter.hit(300);
        assertThat(counter.getHits(300), is(4));
        assertThat(counter.getHits(301), is(3));
    }

    @Test
    public void test_3() {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        assertThat(counter.getHits(1), is(1));
        assertThat(counter.getHits(600), is(0));
    }
}
