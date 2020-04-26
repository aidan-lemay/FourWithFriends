package server.winchecker;

import java.util.*;

/**
 * A class to determine if a player has won on a given connect4 board state
 *
 * @author Andrew Korchowsky
 * @version 4/25/2020
 */
public class Connect4WinChecker {
    //Attributes
    private final int BOARD_WIDTH = 7;
    private final int BOARD_HEIGHT = 6;
    private final int WINNING_LENGTH = 4;

    /**
     * A method to determine whether a piece placed ino a connect4 board forms a continuous
     * line of 4 pieces in a row horizontally, vertically, or diagonally
     */
    public boolean checkWin(char[][] board, int column) {
        char playerColor = getPlayerColor(board, column);
        return (checkColumn(board, column, playerColor) ||
                checkRow(board, column, playerColor) ||
                checkDiagonals(board, column, playerColor));
    }

    /**
     * A method to determine the color of the last player to make a move's piece in a game of connect4 given
     * the board state after that player's move and the column which that player placed their piece into
     *
     * @return a character representing the color of the player's piece (Y or R)
     */
    public char getPlayerColor(char[][] board, int column) {
        int rowNum = getRowNum(board, column);
        return board[column][rowNum];
    }

    /**
     * A method to determine the whether the last player to make a move has connected 4 pieces of the same color in
     * the row that they placed their last piece into given the board state after that player's move, the column which
     * that player placed their piece into, and that player's piece color
     *
     * @return a boolean representing if the player has won
     */
    public boolean checkRow(char[][] board, int column, char playerColor) {
        int rowNum = getRowNum(board, column);
        char[] row = new char[BOARD_WIDTH];
        for (int i = 0; i < BOARD_WIDTH; i++) {
            row[i] = board[i][rowNum];
        }
        return checkLine(row, playerColor);
    }

    /**
     * A method to determine the row of a connect4 board piece in a given column
     *
     * @return the index of the row with the highest piece
     */
    public int getRowNum(char[][] board, int column) {
        int rowNum = 0;
        char nextChar = board[column][rowNum];
        if (nextChar == 'N') {
            throw new IllegalArgumentException("For some reason the column that the player placed their piece into (" + column
                    + ") has no items");
        }
        while (rowNum < (BOARD_HEIGHT - 1) && nextChar != 'N') {
            nextChar = board[column][rowNum + 1];
            rowNum += 1;
        }
        if (nextChar == 'N') {
            return rowNum - 1;
        } else if (rowNum == (BOARD_HEIGHT - 1)) {
            return rowNum;
        } else {
            return rowNum - 1;
        }
    }

    /**
     * A method to determine the whether the last player to make a move has connected 4 pieces of the same color in
     * the column that they placed their last piece into given the board state after that player's move, the column which
     * that player placed their piece into, and that player's piece color
     *
     * @return a boolean representing if the player has won
     */
    public boolean checkColumn(char[][] board, int column, char playerColor) {
        return checkLine(board[column], playerColor);
    }

    /**
     * A method to determine if a given character array has a streak of 4 or more of the given player's color
     */
    public boolean checkLine(char[] line, char playerColor) {
        int streak = 0;
        for (char c : line) {
            if (c == playerColor) {
                streak += 1;
            } else {
                streak = 0;
            }
            if (streak >= WINNING_LENGTH) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method to determine the whether the last player to make a move has connected 4 pieces of the same color in
     * any diagonals intersecting the location that they placed their last piece into given the board state after that
     * player's move, the column which that player placed their piece into, and that player's piece color
     *
     * @return a boolean representing if the player has won
     */
    public boolean checkDiagonals(char[][] board, int column, char playerColor) {
        char[] positiveSlope = getDiagonal(board, column, true);
        char[] negativeSlope = getDiagonal(board, column, false);
        return (checkLine(positiveSlope, playerColor) || checkLine(negativeSlope, playerColor));
    }

    /**
     * Return a character array of all the characters in the diagonal containing the top piece of a given column on a
     * connect4 board, given whether that diagonal has a positive or negative slope
     */
    public char[] getDiagonal(char[][] board, int column, boolean positiveSlope) {
        List<Character> diagonalArrayList = new ArrayList<Character>();
        int[] diagonalStart = getDiagonalStart(board, column, positiveSlope);
        int rowIndex = diagonalStart[1];
        int columnIndex = diagonalStart[0];
        while (columnIndex < BOARD_WIDTH && rowIndex < BOARD_HEIGHT && rowIndex >= 0) {
            diagonalArrayList.add(board[columnIndex][rowIndex]);
            if (positiveSlope) {
                rowIndex += 1;
                columnIndex += 1;
            } else {
                rowIndex -= 1;
                columnIndex += 1;
            }
        }
        char[] diagonal = new char[diagonalArrayList.size()];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = diagonalArrayList.get(i);
        }
        return diagonal;
    }

    /**
     * A method to determine the starting point for a diagonal on a connect4 board given the column whose top piece that
     * diagonal would have to pass through. The starting point will be in the top left if the given boolean positiveSlope
     * is false or bottom left if the given boolean positiveSlope is true.
     *
     * @return an integer array with the first integer being the column number of the diagonal's starting point and the second
     * integer representing the row number of the starting point.
     */
    public int[] getDiagonalStart(char[][] board, int column, boolean positiveSlope) {
        int rowIndex = getRowNum(board, column);
        int columnIndex = column;
        while (columnIndex >= 0 && rowIndex >= 0 && rowIndex < BOARD_HEIGHT) {
            if (positiveSlope) {
                rowIndex -= 1;
                columnIndex -= 1;
            } else {
                rowIndex += 1;
                columnIndex -= 1;
            }
        }
        if (positiveSlope) {
            rowIndex += 1;
            columnIndex += 1;
        } else {
            rowIndex -= 1;
            columnIndex += 1;
        }
        int[] diagonalStart = new int[]{columnIndex, rowIndex};
        return diagonalStart;
    }
}