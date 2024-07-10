import org.example.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    @Test
    public void testIsCellEmptyPositive() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0), "Zelle (0, 0) sollte leer sein");
        assertTrue(board.isCellEmpty(1, 1), "Zelle (1, 1) sollte leer sein");
    }

    @Test
    public void testIsCellEmptyNegative() {
        Board board = new Board();
        board.cells[0][0] = 'X';
        assertFalse(board.isCellEmpty(0, 0), "Zelle (0, 0) sollte nicht leer sein");
        board.cells[2][2] = 'O';
        assertFalse(board.isCellEmpty(2, 2), "Zelle (2, 2) sollte nicht leer sein");
    }

    @Test
    public void testIsFullPositive() {
        Board board = new Board();
        assertFalse(board.isFull(), "Board sollte nicht voll sein");

        fillBoard(board, 'X');
        assertTrue(board.isFull(), "Board sollte voll sein");
    }

    @Test
    public void testIsFullNegative() {
        Board board = new Board();
        assertFalse(board.isFull(), "Board sollte nicht voll sein");

        board.cells[0][0] = 'X';
        board.cells[0][1] = 'X';
        assertFalse(board.isFull(), "Board sollte nicht voll sein");
    }
    @Test
    public void testFillBoard() {
        Board board = new Board();
        fillBoard(board, 'X');

        // Überprüfen, ob alle Zellen mit 'X' gefüllt sind
        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                assertEquals('X', board.cells[i][j], "Die Zelle (" + i + ", " + j + ") sollte mit 'X' gefüllt sein");
            }
        }
    }

    private void fillBoard(Board board, char symbol) {
        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                board.cells[i][j] = symbol;
            }
        }
    }

    @Test
    public void testPlace() {
        Board board = new Board();

        board.place(0, 0, 'X');
        assertEquals('X', board.cells[0][0], "Der Marker wurde nicht korrekt platziert");
    }
    @Test
    public void testClear() {
        Board board = new Board();
        fillBoard(board, 'X');

        // entleert
        board.clear();

        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                assertTrue(board.isCellEmpty(i, j), "Die Zelle (" + i + ", " + j + ") sollte leer sein nach dem Löschen");
            }
        }

    } @Test
    public void testCheckWinPositive() {
        Board board = new Board();
        board.clear();

        // 3 x 'X' in einer Reihe
        board.cells[0][0] = 'X';
        board.cells[0][1] = 'X';
        board.cells[0][2] = 'X';
        assertTrue(board.checkWin('X'), "Spieler 'X' sollte gewinnen");
    }

    @Test
    public void testCheckWinNegative() {
        Board board = new Board();
        board.clear();

        // Reihe wahllos
        board.cells[0][0] = 'X';
        board.cells[1][1] = 'O';
        board.cells[2][2] = 'X';
        assertFalse(board.checkWin('X'), "Spieler 'X' sollte nicht gewinnen");
    }
    @Test
    public void testCheckRowPositive() {
        Board board = new Board();
        board.clear();

        // Reihe mit 3 x 'X'
        board.cells[1][0] = 'X';
        board.cells[1][1] = 'X';
        board.cells[1][2] = 'X';
        assertTrue(board.checkRow(1, 'X'), "Zeile 1 sollte mit 'X' gefüllt sein");
    }

    @Test
    public void testCheckRowNegative() {
        Board board = new Board();
        board.clear();

        // Reihe mit 'X' and 'O'
        board.cells[2][0] = 'X';
        board.cells[2][1] = 'O';
        board.cells[2][2] = 'X';
        assertFalse(board.checkRow(2, 'X'), "Zeile 2 sollte nicht mit 'X' gefüllt sein");
    }
    @Test
    public void testCheckColumnPositive() {
        Board board = new Board();
        board.clear();

        // Set a column with 'O'
        board.cells[0][2] = 'O';
        board.cells[1][2] = 'O';
        board.cells[2][2] = 'O';
        assertTrue(board.checkColumn(2, 'O'), "Spalte 2 sollte mit 'O' gefüllt sein");
    }

    @Test
    public void testCheckColumn_Negative() {
        Board board = new Board();
        board.clear();

        // Spalte mit 'X' and 'O'
        board.cells[0][1] = 'X';
        board.cells[1][1] = 'O';
        board.cells[2][1] = 'X';
        assertFalse(board.checkColumn(1, 'X'), "Spalte 1 sollte nicht mit 'X' gefüllt sein");
    }

    @Test
    public void testCheckDiagonals_Positive() {
        Board board = new Board();
        board.clear();

        // Diagonale mit 'X'en
        board.cells[0][0] = 'X';
        board.cells[1][1] = 'X';
        board.cells[2][2] = 'X';
        assertTrue(board.checkDiagonals('X'), "Diagonale sollte mit 'X' gefüllt sein");
    }

    @Test
    public void testCheckDiagonals_Negative() {
        Board board = new Board();
        board.clear();

        // Diagonale wahllos
        board.cells[0][2] = 'O';
        board.cells[1][1] = 'X';
        board.cells[2][0] = 'O';
        assertFalse(board.checkDiagonals('O'), "Diagonale sollte nicht mit 'O' gefüllt sein");
    }


}

