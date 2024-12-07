package problems.gameOfLife;

public class GameOfLifeInPlace {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        //expected [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        gameOfLife(board);
        System.out.println(board);
    }

    public static void gameOfLife(int[][] board) {
        final int rowMax = board.length;
        final int colMax = board[0].length;

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                int liveCells = getLiveCells(i, j, board);

                if (board[i][j] == 1) { // live now
                    if (liveCells < 2 || liveCells > 3) {
                        board[i][j] = 2; // live now -> die next
                    }
                } else { // die now
                    if (liveCells == 3) {
                        board[i][j] = 3; // die now -> live next
                    }
                }
            }
        }

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // 1 -> 0
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // 0 -> 1
                }
            }
        }
    }

    public static int getLiveCells(int row, int col, int[][] board) {
        int liveCells = 0;
        final int[] directions = {-1, 0, 1};

        for (int dr : directions) {
            for (int dc : directions) {
                if (dr == 0 && dc == 0) {
                    continue; // current cell
                }
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                    if (board[r][c] == 1 || board[r][c] == 2) {
                        liveCells++;
                    }
                }
            }
        }
        return liveCells;
    }
}
