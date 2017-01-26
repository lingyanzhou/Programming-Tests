package lzhou.programmingtest.leetcode.test379;

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
    	PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(true));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(true));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(2));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        phoneDirectory.release(1);
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        phoneDirectory.release(3);
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.get(), is(-1));
    }

    @Test
    public void test_2() {
    	PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(true));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(true));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(2));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        phoneDirectory.release(3);
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        phoneDirectory.release(1);
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.get(), is(-1));
    }

    @Test
    public void test_3() {
    	PhoneDirectory phoneDirectory = new PhoneDirectory(4);
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(true));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.check(4), is(true));
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(true));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.check(4), is(true));
        assertThat(phoneDirectory.get(), is(2));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.check(4), is(true));
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.check(4), is(true));
        assertThat(phoneDirectory.get(), is(4));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.check(4), is(false));
        phoneDirectory.release(3);
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.check(4), is(false));
        phoneDirectory.release(4);
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.check(4), is(true));
        phoneDirectory.release(1);
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(true));
        assertThat(phoneDirectory.check(4), is(true));
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.check(4), is(true));
        assertThat(phoneDirectory.get(), is(4));
        assertThat(phoneDirectory.check(1), is(true));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.check(4), is(false));
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.check(4), is(false));
        assertThat(phoneDirectory.get(), is(-1));
    }

    @Test
    public void test_4() {
    	PhoneDirectory phoneDirectory = new PhoneDirectory(4);
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.get(), is(2));
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.get(), is(4));
        assertThat(phoneDirectory.get(), is(-1));
        phoneDirectory.release(3);
        assertThat(phoneDirectory.get(), is(3));
        phoneDirectory.release(3);
        phoneDirectory.release(4);
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.get(), is(4));
        phoneDirectory.release(4);
        phoneDirectory.release(3);
        assertThat(phoneDirectory.get(), is(4));
        phoneDirectory.release(1);
        assertThat(phoneDirectory.get(), is(3));
        assertThat(phoneDirectory.get(), is(1));
        assertThat(phoneDirectory.check(1), is(false));
        assertThat(phoneDirectory.check(2), is(false));
        assertThat(phoneDirectory.check(3), is(false));
        assertThat(phoneDirectory.check(4), is(false));
    }
}
