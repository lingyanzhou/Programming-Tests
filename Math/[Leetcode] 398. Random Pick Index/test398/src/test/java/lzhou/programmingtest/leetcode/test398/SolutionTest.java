package lzhou.programmingtest.leetcode.test398;

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

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import org.mockito.InOrder;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
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
        Solution sol = new Solution(new int[]{1,2,4,3,1,2,1,3});
        Random rng = mock(Random.class);
        when(rng.nextInt(anyInt())).thenAnswer((invoc)-> Math.abs(invoc.<Integer>getArgument(0)-1));
        sol.setRng(rng);
        assertThat(sol.pick(1), is(0));
        InOrder inOrder = inOrder(rng);
        verify(rng, never()).nextInt(0);
        inOrder.verify(rng, times(1)).nextInt(1);
        inOrder.verify(rng, times(1)).nextInt(2);
        inOrder.verify(rng, times(1)).nextInt(3);
        verify(rng, never()).nextInt(4);
    }

    @Test
    public void test_2() {
        Solution sol = new Solution(new int[]{1,2,4,3,1,2,1,3});
        Random rng = mock(Random.class);
        when(rng.nextInt(anyInt())).thenAnswer((invoc)-> Math.abs(invoc.<Integer>getArgument(0)-2));
        sol.setRng(rng);
        assertThat(sol.pick(2), is(5));
        InOrder inOrder = inOrder(rng);
        verify(rng, never()).nextInt(0);
        inOrder.verify(rng, times(1)).nextInt(1);
        inOrder.verify(rng, times(1)).nextInt(2);
        verify(rng, never()).nextInt(3);
    }
    
    @Test
    public void test_3() {
        Solution sol = new Solution(new int[]{1,2,4,3,1,2,1,3});
        Random rng = mock(Random.class);
        when(rng.nextInt(anyInt())).thenAnswer((invoc)-> Math.abs(invoc.<Integer>getArgument(0)-1));
        sol.setRng(rng);
        assertThat(sol.pick(4), is(2));
        InOrder inOrder = inOrder(rng);
        verify(rng, never()).nextInt(0);
        inOrder.verify(rng, times(1)).nextInt(1);
        verify(rng, never()).nextInt(2);
    }
}
