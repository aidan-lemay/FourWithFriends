package server.winchecker.test;

import org.junit.jupiter.api.Test;
import server.winchecker.Connect4WinChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * My Friend Aaron helped me with the methods to convert text to connect4 boards
 */

import static org.junit.jupiter.api.Assertions.*;

class Connect4WinCheckerTest {

    private static final String baseDirectory = "C:\\Users\\awhk7\\Desktop\\Java Stuff II\\Group Project\\FourWithFriends\\server\\winchecker\\test\\";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }
    private static List<String> getFileLines(String path) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            List<String> lines = new ArrayList<>();
            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());
            }
            myReader.close();
            return lines;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    private static char[][] getBoard(List<String> lines) {
        char[][] board = new char[7][6];
        for (int rowNum = 0; rowNum < lines.size(); rowNum++) {
            for (int colNum = 0; colNum < lines.get(0).length(); colNum++) {
                board[colNum][5 - rowNum] = lines.get(rowNum).charAt(colNum);
            }
        }
        return board;
    }
    @Test
    public void testGetPlayerColor(){
        char[][] board = getBoard(getFileLines(baseDirectory + "TestBoard.txt"));
        assertEquals('Y', new Connect4WinChecker().getPlayerColor(board, 6));
        assertEquals('R', new Connect4WinChecker().getPlayerColor(board, 0));
        assertEquals('Y', new Connect4WinChecker().getPlayerColor(board, 4));
        assertEquals('R', new Connect4WinChecker().getPlayerColor(board, 5));
    }
    @Test
    public void testCheckRow(){
        char[][] board = getBoard(getFileLines(baseDirectory + "TestBoard1.txt"));
        assertEquals(true, new Connect4WinChecker().checkRow(board, 3, 'R'));
        assertEquals(false, new Connect4WinChecker().checkRow(board, 6, 'Y'));
        assertEquals(true, new Connect4WinChecker().checkRow(board, 0, 'R'));
        assertEquals(true, new Connect4WinChecker().checkRow(board, 2, 'R'));
        board = getBoard(getFileLines(baseDirectory + "TestBoard5.txt"));
        assertEquals(false, new Connect4WinChecker().checkRow(board, 2, 'Y'));
        assertEquals(false, new Connect4WinChecker().checkRow(board, 6, 'R'));
    }
    @Test
    public void testCheckColumn(){
        char[][] board = getBoard(getFileLines(baseDirectory + "TestBoard.txt"));
        assertEquals(false, new Connect4WinChecker().checkColumn(board, 6, 'Y'));
        assertEquals(false, new Connect4WinChecker().checkColumn(board, 0, 'R'));
        assertEquals(false, new Connect4WinChecker().checkColumn(board, 2, 'R'));
        board = getBoard(getFileLines(baseDirectory + "TestBoard6.txt"));
        assertEquals(true, new Connect4WinChecker().checkColumn(board, 6, 'Y'));
    }

    @Test
    public void testCheckDiagonals(){
        char[][] board = getBoard(getFileLines(baseDirectory + "TestBoard4.txt"));
        assertEquals(true, new Connect4WinChecker().checkDiagonals(board, 3, 'R'));
        assertEquals(true, new Connect4WinChecker().checkDiagonals(board, 2, 'R'));
        board = getBoard(getFileLines(baseDirectory + "TestBoard3.txt"));
        assertEquals(true, new Connect4WinChecker().checkDiagonals(board, 3, 'Y'));
        assertEquals(true, new Connect4WinChecker().checkDiagonals(board, 6, 'Y'));
        board = getBoard(getFileLines(baseDirectory + "TestBoard.txt"));
        assertEquals(false, new Connect4WinChecker().checkDiagonals(board, 1, 'R'));
        assertEquals(false, new Connect4WinChecker().checkDiagonals(board, 5, 'R'));
    }

    @Test
    public void testConnect4WinChecker(){
        char[][] board = getBoard(getFileLines(baseDirectory + "TestBoard.txt"));
        assertEquals(false, new Connect4WinChecker().checkWin(board, 3));
        board = getBoard(getFileLines(baseDirectory + "TestBoard1.txt"));
        assertEquals(true, new Connect4WinChecker().checkWin(board, 0));
        board = getBoard(getFileLines(baseDirectory + "TestBoard2.txt"));
        assertEquals(false, new Connect4WinChecker().checkWin(board, 6));
        board = getBoard(getFileLines(baseDirectory + "TestBoard3.txt"));
        assertEquals(true, new Connect4WinChecker().checkWin(board, 3));
        try {
            new Connect4WinChecker().checkWin(board, 0);
            fail();
        }
        catch(IllegalArgumentException iae){
            assertEquals("For some reason the column that the player placed their piece into (0) has no items",
                    iae.getMessage());
        }
        board = getBoard(getFileLines(baseDirectory + "TestBoard4.txt"));
        assertEquals(true, new Connect4WinChecker().checkWin(board, 3));
        board = getBoard(getFileLines(baseDirectory + "TestBoard5.txt"));
        assertEquals(false, new Connect4WinChecker().checkWin(board, 1));
        board = getBoard(getFileLines(baseDirectory + "TestBoard6.txt"));
        assertEquals(true, new Connect4WinChecker().checkWin(board, 6));
        assertEquals(false, new Connect4WinChecker().checkWin(board, 5));
        assertEquals(false, new Connect4WinChecker().checkWin(board, 2));
    }
}