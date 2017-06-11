package lzhou.programmingtest.leetcode.test604;

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
public class StringIteratorTest {
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
    public void test_empty() {
        StringIterator si = new StringIterator("");
        assertEquals(si.hasNext(), false);
        assertEquals(si.next(), ' ');
    }

    @Test
    public void test_simple() {
        StringIterator si = new StringIterator("L1");
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'L');
        assertEquals(si.hasNext(), false);
        assertEquals(si.next(), ' ');
    }

    @Test
    public void test_long() {
        StringIterator si = new StringIterator("L1e2t1C1o1d1e1");
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'L');
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'e');
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'e');
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 't');
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'C');
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'o');
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'd');
        assertEquals(si.hasNext(), true);
        assertEquals(si.next(), 'e');
        assertEquals(si.hasNext(), false);
        assertEquals(si.next(), ' ');
    }

    @Test
    public void test_moreThan10() {
        StringIterator si = new StringIterator("L11");
        for (int i=0; i<11; ++i) {
          assertEquals(si.hasNext(), true);
          assertEquals(si.next(), 'L');
        }
        assertEquals(si.hasNext(), false);
        assertEquals(si.next(), ' ');
    }
}
