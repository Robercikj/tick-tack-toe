package com.kodilla.ticktacktoe;

import java.util.Arrays;


public class Board {

    char[][] board = new char[3][3];


    public Board() {
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

    public boolean setField(int row, int col, char c) {
        if (board[row][col] == '-') {
            board[row][col] = c;
            return true;
        } else {
            return false;
        }
    }
}
