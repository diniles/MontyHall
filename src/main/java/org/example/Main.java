package org.example;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numTrials = 1000;
        Map<Integer, String> results = new HashMap<>();

        for (int i = 1; i <= numTrials; i++) {
            boolean win = simulateMontyHall();
            results.put(i, win ? "Win" : "Loss");
        }

        int wins = 0;
        int losses = 0;

        for (String result : results.values()) {
            if (result.equals("Win")) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.println("Statistics in " + numTrials + " trials:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }

    private static boolean simulateMontyHall() {
        boolean[] doors = {false, false, false};

        int carPosition = new Random().nextInt(3);
        doors[carPosition] = true;

        int playerChoice = new Random().nextInt(3);

        int revealedDoor;
        do {
            revealedDoor = new Random().nextInt(3);
        } while (revealedDoor == playerChoice || doors[revealedDoor]);

        int newChoice;
        do {
            newChoice = new Random().nextInt(3);
        } while (newChoice == playerChoice || newChoice == revealedDoor);

        return doors[newChoice];
    }
}