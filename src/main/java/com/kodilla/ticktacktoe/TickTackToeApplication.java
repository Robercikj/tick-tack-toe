package com.kodilla.ticktacktoe;


import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class TickTackToeApplication {
    public static void main(String[] args) {
        int size = UserDialogs.getBoardSize();
        Game game = new Game(size);
        game.startGame();


    }


}
