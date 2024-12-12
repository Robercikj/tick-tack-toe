package com.kodilla.ticktacktoe;

import java.util.Random;

public class AI {
    public static Move getComputerMove() {
        Random random = new Random();
        return new Move(random.nextInt(3), random.nextInt(3) );
    }
}
