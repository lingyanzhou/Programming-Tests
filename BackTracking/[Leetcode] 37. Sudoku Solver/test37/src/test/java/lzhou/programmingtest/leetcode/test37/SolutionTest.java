package lzhou.programmingtest.leetcode.test37;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SolutionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SolutionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SolutionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        char[][] in={
            {'.', '.', '9', '7', '4', '8','.', '.', '.'},
            {'7', '.', '.', '.', '.', '.','.', '.', '.'},
            {'.', '2', '.', '1', '.', '9','.', '.', '.'},
            {'.', '.', '7', '.', '.', '.','2', '4', '.'},
            {'.', '6', '4', '.', '1', '.','5', '9', '.'},
            {'.', '9', '8', '.', '.', '.','3', '.', '.'},
            {'.', '.', '.', '8', '.', '3','.', '2', '.'},
            {'.', '.', '.', '.', '.', '.','.', '.', '6'},
            {'.', '.', '.', '2', '7','5', '9', '.', '.'}};
        char[][] out={
            {'5', '1', '9', '7', '4', '8','6', '3', '2'},
            {'7', '8', '3', '6', '5', '2','4', '1', '9'},
            {'4', '2', '6', '1', '3', '9','8', '7', '5'},
            {'3', '5', '7', '9', '8', '6','2', '4', '1'},
            {'2', '6', '4', '3', '1', '7','5', '9', '8'},
            {'1', '9', '8', '5', '2', '4','3', '6', '7'},
            {'9', '7', '5', '8', '6', '3','1', '2', '4'},
            {'8', '3', '2', '4', '9', '1','7', '5', '6'},
            {'6', '4', '1', '2', '7','5', '9', '8', '3'}};
        Solution sol = new Solution();
        sol.solveSudoku(in);
        assert2DArrayEquls(out, in);
    }
    public void testApp2()
    {
        char[][] in={
            {'5', '3', '.', '.', '7', '.','.', '.', '.'},
            {'6', '.', '.', '1', '9', '5','.', '.', '.'},
            {'.', '9', '8', '.', '.', '.','.', '6', '.'},
            {'8', '.', '.', '.', '6', '.','.', '.', '3'},
            {'4', '.', '.', '8', '.', '3','.', '.', '1'},
            {'7', '.', '.', '.', '2', '.','.', '.', '6'},
            {'.', '6', '.', '.', '.', '.','2', '8', '.'},
            {'.', '.', '.', '4', '1', '9','.', '.', '5'},
            {'.', '.', '.', '.', '8', '.','.', '7', '9'}};
        char[][] out={
            {'5', '3', '4', '6', '7', '8','9', '1', '2'},
            {'6', '7', '2', '1', '9', '5','3', '4', '8'},
            {'1', '9', '8', '3', '4', '2','5', '6', '7'},
            {'8', '5', '9', '7', '6', '1','4', '2', '3'},
            {'4', '2', '6', '8', '5', '3','7', '9', '1'},
            {'7', '1', '3', '9', '2', '4','8', '5', '6'},
            {'9', '6', '1', '5', '3', '7','2', '8', '4'},
            {'2', '8', '7', '4', '1', '9','6', '3', '5'},
            {'3', '4', '5', '2', '8', '6','1', '7', '9'}};
        Solution sol = new Solution();
        sol.solveSudoku(in);
        assert2DArrayEquls(out, in);
    }

    private void assert2DArrayEquls(char[][] o1, char[][] o2) {
        assertEquals(o1.length, o2.length);
        for (int i=0; i<o1.length; ++i) {
            assertEquals(o1[i].length, o2[i].length);
            for (int j=0; j<o1[i].length; ++j) {
                assertEquals(o1[i][j], o2[i][j]);
            }
        }
        
    }
}
