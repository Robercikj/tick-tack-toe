package com.kodilla.ticktacktoe;

import java.util.Scanner;

public class UserDialogs {

    public static Move getUserMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your move (X,Y): ");
            String input = scanner.nextLine();
            if(input.length()== 3){
                String[] coords = input.split(",");
                try { // żeby uytkownik nie mógł wpisac nic innego jak liczba
                    int col = Integer.parseInt(coords[0]);
                    int row = Integer.parseInt(coords[1]);
                    if(col < 3 && row < 3) {
                        return new Move(col, row);
                    } else {
                        System.out.println("valid values are of range 0 - 2 ");
                    }
                } catch (Exception e) {

                }
            }
            System.out.println("Wrong move try again !");
        }

    }
    public static void displayInvalidCoordinatesMessage() {
        System.out.println("Wronf values, possible values are of range 0 - 2 ");
    }
    public static boolean areCoordinatesValid(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            displayInvalidCoordinatesMessage();
            return false;
        }
        return true;
    }

    public static void displayOccupiedFieldMessage() {
        System.out.println("Set empty fiels, square is occupied");
    }

    public static void displaySwitchPlayer() {
        System.out.println("switching player .. ");
    }
}
