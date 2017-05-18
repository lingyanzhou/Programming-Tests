package lzhou.programmingtest.leetcode.test456;

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
    @Parameters(name = "{index}: find132pattern({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 {new int[]{1,2,3,4}, false},
                 {new int[]{1,2,4,4}, false},
                 {new int[]{4,3,2,1}, false},
                 {new int[]{4,4,2,1}, false},
                 {new int[]{1,4,2,1}, true},
                 {new int[]{1,2,3,2}, true},
           });
    }
    private int[] in;
    private boolean expected;

    public SolutionTest(int[] in, boolean expected) {
        this.in = in;
        this.expected = expected;
    }

    @Test
    public void test() {
        boolean actual = new Solution().find132pattern(in);
        assertThat(actual, is(expected));
    }
}
