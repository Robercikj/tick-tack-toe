package com.kodilla.ticktacktoe;

import java.util.Scanner;

public class Game {
    private Board board;
    private char whoseMove = 'X';

    public Game() {
        board = new Board();

    }

    public void startGame() {
        boolean gameGoing = true;

        board.showBoard();
        while (gameGoing) {
            Move move;
            if (whoseMove == 'X') {
                move = UserDialogs.getUserMove();

            } else {
                move = AI.getComputerMove();
            }

            if (!UserDialogs.areCoordinatesValid(move.getRow(), move.getCol())) {
                continue;
            }


            boolean result = board.setField(move.getRow(), move.getCol(), whoseMove);

            if (!result) {
                UserDialogs.displayOccupiedFieldMessage();
                continue;
            }

            if(checkWin(whoseMove)) {
                System.out.println("Gracz : " + whoseMove + " wygrał ");
                gameGoing = false;
            } else if(board.isBoardFull()) {
                System.out.println("Remis");
                gameGoing = false;
            } else {
                switchPlayer();
                board.showBoard();
                UserDialogs.displaySwitchPlayer();
            }
        }
    }
    public boolean checkWin(char player) {
        // w poziomie
        for (int row = 0; row < 3; row++) {
            if (board.getField(row, 0) == player && board.getField(row, 1) == player && board.getField(row, 2) == player) {
                return true;
            }
        }

        // w pionie
        for (int col = 0; col < 3; col++) {
            if (board.getField(0, col) == player && board.getField(1, col) == player && board.getField(2, col) == player) {
                return true;
            }
        }

        // po skosie
        if (board.getField(0, 0) == player && board.getField(1, 1) == player && board.getField(2, 2) == player) {
            return true;
        }

        if (board.getField(0, 2) == player && board.getField(1, 1) == player && board.getField(2, 0) == player) {
            return true;
        }

        return false;
    }
    private void switchPlayer() {
        whoseMove = (whoseMove == 'X' ? 'O' : 'X');
    }


}
