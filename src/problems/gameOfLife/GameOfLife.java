package problems.gameOfLife;

import java.util.Arrays;

/**
 * 289. Game of Life
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors
 * (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur
 * simultaneously.
 * <p>
 * Given the current state of the board, update the board to reflect its next state.
 * <p>
 * Note that you do not need to return anything.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live
 * cells reach the border). How would you address these problems?
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        //expected [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        gameOfLife(board);
        System.out.println(board);
    }

    public static void gameOfLife(int[][] board) {
        final int[][] frozenBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            frozenBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getLiveOrDie(i, j, frozenBoard);
            }
        }
    }

    public static int getLiveOrDie(int row, int col, int[][] frozenBoard) {
        //up, down, left, right, topLeft, topRight, bottomLeft, bottomRight
        final int currentCell = frozenBoard[row][col];
        int nextCell = -1;
        if (currentCell == 0) {
            //die
            nextCell = getLiveCells(row, col, frozenBoard) == 3 ? 1 : 0;
        } else {
            //live
            int liveCells = getLiveCells(row, col, frozenBoard);
            if (liveCells < 2) {
                nextCell = 0;
            } else if (liveCells == 2 || liveCells == 3) {
                nextCell = 1;
            } else {
                nextCell = 0;
            }
        }
        return nextCell;
    }

    public static int getLiveCells(int row, int col, int[][] frozenBoard) {
        int liveCellsCount = 0;
        final int rowMax = frozenBoard.length - 1;
        final int colMax = frozenBoard[0].length - 1;
        if (row != 0 && frozenBoard[row - 1][col] == 1) {
            liveCellsCount++; // up
        }
        if (row != 0 && col != 0 && frozenBoard[row - 1][col - 1] == 1) {
            liveCellsCount++; //upLeft
        }
        if (row != 0 && col != colMax && frozenBoard[row - 1][col + 1] == 1) {
            liveCellsCount++; //upRight
        }
        if (col != 0 && frozenBoard[row][col - 1] == 1) {
            liveCellsCount++; //left
        }
        if (col != colMax && frozenBoard[row][col + 1] == 1) {
            liveCellsCount++; //right
        }
        if (row != rowMax && col != 0 && frozenBoard[row + 1][col - 1] == 1) {
            liveCellsCount++; //bottomLeft
        }
        if (row != rowMax && frozenBoard[row + 1][col] == 1) {
            liveCellsCount++; //bottom
        }
        if (row != rowMax && col != colMax && frozenBoard[row + 1][col + 1] == 1) {
            liveCellsCount++; //bottomRight
        }
        return liveCellsCount;
    }
}
