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
            boolean result = board.setField(move.getRow(), move.getCol(), whoseMove);
            if(result) {
                switchPlayer();
                board.showBoard();
                UserDialogs.displaySwitchPlayer();
            }
        }
    }

    private void switchPlayer() {
        whoseMove = (whoseMove == 'X' ? 'O' : 'X');
    }
}
