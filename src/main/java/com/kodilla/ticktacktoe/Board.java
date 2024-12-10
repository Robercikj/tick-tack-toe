package com.kodilla.ticktacktoe;

import java.util.Arrays;


public class Board {
private char currentPlayer = 'X';

    public Board() {

    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    char[][] board = new char[3][3];


    public Board(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = '-';
            }
        }
    }

    public void showBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void setField(int row, int col, char c) {
        if (board[row][col] == '-') {
            board[row][col] = c;
            switchCurrentPlayer();
        } else {
            throw new IllegalArgumentException("The field is already used");
        }
    }
}
