package lzhou.programmingtest.leetcode.test12;

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
    public Timeout globalTimeout = Timeout.millis(10);
    
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
    public void test_all() {
        int[] ns = {3999,5,13,26,58,103,148,199,502,888,2013,2340,3000,3300,3503};
        String[] expecteds = {"MMMCMXCIX","V","XIII","XXVI","LVIII","CIII","CXLVIII","CXCIX","DII","DCCCLXXXVIII","MMXIII","MMCCCXL","MMM","MMMCCC","MMMDIII"};
        for (int i=0; i<ns.length; ++i) {
            int n=ns[i];
            String expected = expecteds[i];
            String actual = new Solution().intToRoman(n);
            assertEquals(expected, actual);
        }
    }
}
