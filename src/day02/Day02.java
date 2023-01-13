package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day02/input.txt");
        Scanner sc = new Scanner(input);

        int score = 0;

        while (sc.hasNextLine()) {
            char opponentChoice = sc.next().charAt(0);
            char myChoice = sc.next().charAt(0);

            if (myChoice == 'X') {
                score += 0;

                if (opponentChoice == 'A') {
                    score += 3;
                } else if (opponentChoice == 'B') {
                    score += 1;
                } else {
                    score += 2;
                }
            } else if (myChoice == 'Y') {
                score += 3;

                if (opponentChoice == 'A') {
                    score += 1;
                } else if (opponentChoice == 'B') {
                    score += 2;
                } else {
                    score += 3;
                }
            } else {
                score += 6;

                if (opponentChoice == 'A') {
                    score += 2;
                } else if (opponentChoice == 'B') {
                    score += 3;
                } else {
                    score += 1;
                }
            }
        }

        System.out.println("Part 2: " + score);
    }
}