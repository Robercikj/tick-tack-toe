package com.kodilla.ticktacktoe;

import java.util.Random;

public class AI {
    public static Move getComputerMove(int boardSize) {
        Random random = new Random();
        return new Move(random.nextInt(boardSize), random.nextInt(boardSize));
    }
}
