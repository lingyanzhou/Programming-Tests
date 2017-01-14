package lzhou.programmingtest.leetcode.test138;

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
    public void test() {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random=head.next.next; //To 2 nodes later
        head.next.next.random=head; // To 2 nodes previous
        head.next.next.next.next.random=head.next.next.next.next; //To itself
        RandomListNode cpy = new Solution().copyRandomList(head);
        while (cpy!=null && head!=null) {
            assertThat(cpy.label, is(head.label));
            assertThat(cpy, not(sameInstance(head)));
            if (head.random!=null) {
                assertThat(cpy.random, notNullValue());
                assertThat(cpy.random.label, is(head.random.label));
                assertThat(cpy.random, not(sameInstance(head.random)));
            } else {
                assertThat(cpy.random, nullValue());
            }
            cpy = cpy.next;
            head = head.next;
        }
    }
}
