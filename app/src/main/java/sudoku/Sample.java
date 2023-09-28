package sudoku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

class Sample {

    private static final Logger _logger = Logger.getAnonymousLogger();
    private static final int MAX_VARIANTS = 3;

    public static boolean isSafe(char[][] board, int row, int col, int number) {
        // column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
        }

        // row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == (char) (number + '0')) {
                return false;
            }
        }
        return true;
    }

    public static boolean helper(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        if (col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if (board[row][col] != '.') {
            if (helper(board, nrow, ncol)) {
                return true;
            }
        } else {
            Random random = new Random(Instant.now().toEpochMilli());

            // fill the place
            for (int i = 1; i <= board.length; i++) {
                var randomNum = getNextRandom(board, i, row, col, random, board.length);

                if (randomNum != 0) {
                    board[row][col] = (char) (randomNum + '0');
                    if (helper(board, nrow, ncol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }

        return false;
    }

    private static int getNextRandom(final char[][] board, int fallback, final int row, final int col,
            final Random random, int randomLength) {
        int retry = 3;
        while (retry != 0) {
            int randomNum = random.nextInt(randomLength + 1);
            if (randomNum != 0 && isSafe(board, row, col, randomNum))
                return randomNum;
            --retry;
        }
        if (isSafe(board, row, col, fallback)) {
            return fallback;
        }
        return 0;
    }

    public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private static void fillDots(char[][] board, int rows, int cols) {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                board[i][j] = '.';
            }
        }
    }

    private static void print(char[][] board, int rows, int cols) {

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                buffer.append(board[i][j] + "\t");
            }
            buffer.append("\n");
        }

        _logger.info("\n" + buffer);
    }

    private static InputStream getInputStream(String[] args) throws FileNotFoundException {

        InputStream in;
        if (args.length != 0) {
            in = new FileInputStream(args[0]);
        } else {
            in = System.in;
        }
        return in;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(getInputStream(args));
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        char[][] board = new char[rows][cols];

        int variants = MAX_VARIANTS;
        while (variants != 0) {
            fillDots(board, rows, cols);
            solveSudoku(board);
            print(board, rows, cols);
            --variants;
        }
    }
}