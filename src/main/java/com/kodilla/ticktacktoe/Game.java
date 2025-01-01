package com.kodilla.ticktacktoe;

import java.util.Scanner;

public class Game {
    private Board board;
    private char whoseMove = 'X';


    public Game(int size) {
      board = new Board(size);

    }
    private int getUserSizeBoard() {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        return size;
    }

    public void startGame() {
        boolean gameGoing = true;

        board.showBoard();
        while (gameGoing) {
            Move move;
            if (whoseMove == 'X') {
                System.out.println(board.getSize());
                move = UserDialogs.getUserMove(board.getSize());

            } else {
                move = AI.getComputerMove(board.getSize());
            }

            if (!UserDialogs.areCoordinatesValid(move.getRow(), move.getCol(), board.getSize())) {
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
        int size = board.getSize();
        int winCondition = (size == 3) ? 3 : 5;
        // w poziomie
        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= size - winCondition; col++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board.getField(row, col +k) != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {  return true; }
            }
        }

        // w pionie
        for (int col = 0; col < size; col++) {
            for (int row = 0; row <= size - winCondition; row++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board.getField(row + k, col) != player) {
                        win = false;
                        break;
                    }
                }
                if (win) { return true; }
            }
        }


        // po skosie
        for (int row = 0; row <= size - winCondition; row++) {
            for (int col = 0; col <= size - winCondition; col++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board.getField(row + k, col + k) != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        for (int row = 0; row <= size - winCondition; row++) {
            for (int col = winCondition - 1; col < size; col++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board.getField(row + k, col - k) != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        return false;
    }

    private void switchPlayer() {
        whoseMove = (whoseMove == 'X' ? 'O' : 'X');
    }


}
