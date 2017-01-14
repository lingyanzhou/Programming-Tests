package lzhou.programmingtest.lintcode.test129;

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
    @Parameters(name = "{index}: rehashing({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[][]{{},{21,9},{14},{}}, new int[][]{{},{9},{},{},{},{21},{14},{}}},
                 {new int[][]{{},{},{29,5}}, new int[][]{{},{},{},{},{},{29,5}}},
           });
    }
    private ListNode[] hashTable;
    private ListNode[] expected;

    public SolutionTest(int[][] hashTable, int[][] expected) {
        this.hashTable = toListNode(hashTable);
        this.expected = toListNode(expected);
    }

    private static ListNode[] toListNode(int[][] in) {
        ListNode[] ret = new ListNode[in.length];
        for (int i=0; i<ret.length; ++i) {
            ret[i] = new ListNode(0);
            ListNode cur = ret[i];
            for (int n: in[i]) {
                cur.next = new ListNode(n);
                cur = cur.next;
            }
            ret[i]=ret[i].next;
        }
        return ret;
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
        ListNode[] actual = new Solution().rehashing(hashTable);
        assertHashTableEquals(expected, actual);
    }

    private static void assertHashTableEquals(ListNode[] expected, ListNode[] actual) {
        assertThat(actual.length, is(expected.length));
        for (int i=0; i<actual.length; ++i) {
            ListNode e = expected[i];
            ListNode a = actual[i];
            while (e!=null && a!=null) {
                assertThat(a.val, is(e.val));
                a = a.next;
                e = e.next;
            }
            assertThat(e, nullValue());
            assertThat(a, nullValue());
        }
    }
}
