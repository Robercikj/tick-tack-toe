package com.kodilla.ticktacktoe;

import java.util.Arrays;
public class Board {
    private int size;
    private char[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = '-';
            }
        }
    }
    public int getSize() {
        return size;
    }
    public void showBoard() {
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(board[i]));

        }
    }
    public char getField(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return board[row][col];
        } else {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates");
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
    public boolean isBoardFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
