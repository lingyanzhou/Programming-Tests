package lzhou.programmingtest.leetcode.test348;

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
        TicTacToe tictactoe = new TicTacToe(3);
        assertThat(tictactoe.move(0,0,1), is(0));
        assertThat(tictactoe.move(0,1,2), is(0));
        assertThat(tictactoe.move(1,0,1), is(0));
        assertThat(tictactoe.move(0,2,2), is(0));
        assertThat(tictactoe.move(2,0,1), is(1));
    }

    @Test
    public void test_2() {
        TicTacToe tictactoe = new TicTacToe(3);
        assertThat(tictactoe.move(0,0,1), is(0));
        assertThat(tictactoe.move(0,1,2), is(0));
        assertThat(tictactoe.move(1,1,1), is(0));
        assertThat(tictactoe.move(0,2,2), is(0));
        assertThat(tictactoe.move(2,2,1), is(1));
    }

    @Test
    public void test_3() {
        TicTacToe tictactoe = new TicTacToe(3);
        assertThat(tictactoe.move(0,2,1), is(0));
        assertThat(tictactoe.move(0,1,2), is(0));
        assertThat(tictactoe.move(1,1,1), is(0));
        assertThat(tictactoe.move(1,2,2), is(0));
        assertThat(tictactoe.move(2,0,1), is(1));
    }

    @Test
    public void test_4() {
        TicTacToe tictactoe = new TicTacToe(3);
        assertThat(tictactoe.move(0,0,1), is(0));
        assertThat(tictactoe.move(0,1,2), is(0));
        assertThat(tictactoe.move(0,2,1), is(0));
        assertThat(tictactoe.move(1,1,2), is(0));
        assertThat(tictactoe.move(2,0,1), is(0));
        assertThat(tictactoe.move(2,1,2), is(2));
    }

    @Test
    public void test_5() {
        TicTacToe tictactoe = new TicTacToe(3);
        assertThat(tictactoe.move(0,0,1), is(0));
        assertThat(tictactoe.move(0,1,2), is(0));
        assertThat(tictactoe.move(0,2,1), is(0));
        assertThat(tictactoe.move(1,1,2), is(0));
        assertThat(tictactoe.move(2,0,1), is(0));
        assertThat(tictactoe.move(1,0,2), is(0));
        assertThat(tictactoe.move(2,1,1), is(0));
        assertThat(tictactoe.move(2,2,2), is(0));
        assertThat(tictactoe.move(1,2,1), is(0));
    }
}
