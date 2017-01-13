package lzhou.programmingtest.leetcode.test36;

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
    public void testSolution()
    {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        Solution sol = new Solution();
        assertTrue(sol.isValidSudoku(board));
    }

    
    public void testSolution2()
    {
        char[][] board = toBoard(new String[] {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"});
        Solution sol = new Solution();
        assertTrue(sol.isValidSudoku(board));
    }

    private char[][] toBoard(String[] strs) {
        char[][] ret = new char[9][9];
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                ret[i][j] = strs[i].charAt(i);
            }
        }
        return ret;
    }
}
