package com.kodilla.ticktacktoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    private Game game;
    private Board board;

    @BeforeEach
    public void setup() {
        game = new Game();
        board = new Board();
    }

    // Zwycięstwo O w wierszach
    @Test
    public void OWinHorizontalTest() {
        board.setField(0, 0, 'O');
        board.setField(0, 1, 'O');
        board.setField(0, 2, 'O');
        assertFalse(game.checkWin('O'));
    }

    // Zwycięstwo O w kolumnach
    @Test
    public void OWinVerticalTest() {
        board.setField(0, 0, 'O');
        board.setField(1, 0, 'O');
        board.setField(2, 0, 'O');
        assertFalse(game.checkWin('O'));
    }

    // Zwycięstwo O po przekątnych
    @Test
    public void OWinDiagonalTest() {
        board.setField(0, 0, 'O');
        board.setField(1, 1, 'O');
        board.setField(2, 2, 'O');
        assertFalse(game.checkWin('O'));
    }

    // Zwycięstwo X w wierszach
    @Test
    public void XWinHorizontalTest() {
        board.setField(2, 0, 'X');
        board.setField(2, 1, 'X');
        board.setField(2, 2, 'X');
        assertFalse(game.checkWin('X'));
    }

    // Zwycięstwo X w kolumnach
    @Test
    public void XWinVerticalTest() {
        board.setField(0, 2, 'X');
        board.setField(1, 2, 'X');
        board.setField(2, 2, 'X');
        assertFalse(game.checkWin('X'));
    }

    // Zwycięstwo X po przekątnych
    @Test
    public void XWinDiagonalTest() {
        board.setField(0, 2, 'X');
        board.setField(1, 1, 'X');
        board.setField(2, 0, 'X');
        assertFalse(game.checkWin('X'));
    }

    // Sprawdzenie remisu
    @Test
    public void DrawTest() {
        // Wypełniamy planszę do końca, bez zwycięzcy
        board.setField(0, 0, 'X');
        board.setField(0, 1, 'O');
        board.setField(0, 2, 'X');
        board.setField(1, 0, 'O');
        board.setField(1, 1, 'X');
        board.setField(1, 2, 'O');
        board.setField(2, 0, 'X');
        board.setField(2, 1, 'X');
        board.setField(2, 2, 'O');

        assertTrue(board.isBoardFull());
        assertFalse(game.checkWin('X'));
        assertFalse(game.checkWin('O'));
    }

    // Testy dla błędnych ruchów
    @Test
    public void InvalidMoveOutOfBoundsTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            board.setField(3, 3, 'X'); // Poza zakresem planszy
        });
    }

    @Test
    public void InvalidMoveOnOccupiedFieldTest() {
        board.setField(1, 1, 'X');
        assertFalse(board.setField(1, 1, 'O')); // Pole zajęte
    }

    @Test
    public void InvalidMoveOnOccupiedField2Test() {
        board.setField(0, 0, 'X');
        assertFalse(board.setField(0, 0, 'O')); // Pole zajęte
    }
}
