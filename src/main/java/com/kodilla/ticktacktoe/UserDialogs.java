package com.kodilla.ticktacktoe;

import java.util.Scanner;

public class UserDialogs {

    public static int getBoardSize() {
        Scanner sc = new Scanner(System.in);
        int size =0;

        while(size != 3 && size != 10) {
            System.out.println("Choose size of the board: 3x3 (write 3) or 10x10 (write 10):" );
            try {
                size = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer between 3 and 10");
            }

        }
        return size;
    }

    public static Move getUserMove(int boardSize) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your move (X Y): (X to kolumna) (Y to wiersz)");
            String input = scanner.nextLine();
            String[] coords = input.split(" "); // Dzielimy wejście po spacji
            if (coords.length == 2) {
                try {
                    int col = Integer.parseInt(coords[0].trim()); // Usuwamy nadmiarowe spacje
                    int row = Integer.parseInt(coords[1].trim()); // Usuwamy nadmiarowe spacje
                    if (col >= 0 && col < boardSize && row >= 0 && row < boardSize) {
                        return new Move(col, row);
                    } else {
                        System.out.println("Valid values are in range 0 - " + (boardSize - 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid integers for coordinates.");
                }
            } else {
                System.out.println("Please enter two numbers separated by a space.");
            }
        }
    }




    public static void displayInvalidCoordinatesMessage() {
        System.out.println("Wronf values, possible values are of range 0 - 2 ");
    }
    public static boolean areCoordinatesValid(int row, int col, int boardSize) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            displayInvalidCoordinatesMessage();
            return false;
        }
        return true;
    }



    public static void displayOccupiedFieldMessage() {
        System.out.println("Set empty fields, square is occupied");
    }

    public static void displaySwitchPlayer() {
        System.out.println("switching player .. ");
    }
}
