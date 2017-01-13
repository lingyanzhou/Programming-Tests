package lzhou.programmingtest.leetcode.test37;

import java.util.*;

public class Solution {
    public void solveSudoku(char[][] board) {
        SudokuTable st = new SudokuTable();
        Stack<SudokuCellState> toSolve = new Stack<SudokuCellState>();
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[i].length; ++j) {
                if (board[i][j]!='.') {
                    st.add(i, j, Character.digit(board[i][j], 10));
                } else {
                    toSolve.push(new SudokuCellState(i, j, 0));
                }
            }
        }
        
        Stack<SudokuCellState> solved = new Stack<SudokuCellState>();
        while (!toSolve.isEmpty()) {
            SudokuCellState cell = toSolve.peek();
            boolean canSolve = false;
            for (int i=cell.val+1; i<=9; ++i) {
                if (st.add(cell.row, cell.col, i)) {
                    cell.val=i;
                    canSolve = true;
                    break;
                }
            }
            if (canSolve) {
                toSolve.pop();
                solved.push(cell);
            } else {
                cell.val=0;
                while (solved.peek().val==9) {
                    cell = solved.pop();
                    st.remove(cell.row, cell.col, cell.val);
                    cell.val=0;
                    toSolve.push(cell);
                };
                cell=solved.pop();
                st.remove(cell.row, cell.col, cell.val);
                toSolve.push(cell);
            }
        }
        for (SudokuCellState cell: solved) {
            board[cell.row][cell.col]=Character.forDigit(cell.val, 10);
        }
    }
    
    static class SudokuCellState {
        int row;
        int col;
        int val; 
        SudokuCellState (int _row, int _col, int _val) {
            row=_row;
            col=_col;
            val=_val;
        }
    }
    
    static class SudokuTable{
        int[][] blockTable = null; 
        int[] rowTable = null;
        int[] colTable = null;
        public SudokuTable() {
            blockTable = new int[3][3]; 
            rowTable = new int [9];
            colTable = new int [9];
        }
        
        boolean add(int row, int col, int val) {
            int valBit = (1<<val);
            int blockRow = row/3;
            int blockCol = col/3;
            if ((rowTable[row]&valBit)==0 && (colTable[col]&valBit)==0 && (blockTable[blockRow][blockCol]&valBit)==0) {
                rowTable[row] |= valBit;
                colTable[col] |= valBit;
                blockTable[blockRow][blockCol] |= valBit;
                return true;
            } else {
                return false;
            }
        }
        
        void remove(int row, int col, int val) {
            int valBit = (1<<val);
            int blockRow = row/3;
            int blockCol = col/3;
            rowTable[row] &= ~valBit;
            colTable[col] &= ~valBit;
            blockTable[blockRow][blockCol] &= ~valBit;
        }
    }
}
