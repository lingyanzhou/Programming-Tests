package lzhou.programmingtest.leetcode.test89;

import java.util.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

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
        int n=1;
        List<Integer> expected = toList(new int[]{0,1});
        List<Integer> actual = new Solution().grayCode(n);
        assertListEquals(expected, actual);
    }

    @Test
    public void test_2() {
        int n=2;
        List<Integer> expected = toList(new int[]{0,1,3,2});
        List<Integer> actual = new Solution().grayCode(n);
        assertListEquals(expected, actual);
    }

    @Test
    public void test_4() {
        int n=4;
        List<Integer> expected = toList(new int[]{0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8});
        List<Integer> actual = new Solution().grayCode(n);
        assertListEquals(expected, actual);
    }


    private List<Integer> toList(int[] in) {
        List<Integer> ret = new ArrayList<Integer>(in.length);
        for (int i:in) {
            ret.add(i);
        }
        return ret;
    }

    private void assertListEquals(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i=0; i<expected.size(); ++i) {
            assertEquals("Element: "+i, expected.get(i).intValue(), actual.get(i).intValue());
        }
    }
}
