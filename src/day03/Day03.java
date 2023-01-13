package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day03 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day03/input.txt");

        System.out.println("Part 1: " + firstPart(input));
        System.out.println("Part 2: " + secondPart(input));
    }

    private static int firstPart(File input) throws FileNotFoundException {
        Scanner sc = new Scanner(input);

        char[] items;
        int prioritiesSum = 0;
        boolean stop;

        while (sc.hasNextLine()) {
            items = sc.nextLine().toCharArray();
            stop = false;

            for (int i = 0; i < items.length / 2 && !stop; i++) {
                for (int j = items.length / 2; j < items.length && !stop; j++) {
                    if (items[i] != items[j]) {
                        continue;
                    }

                    prioritiesSum += getItemPriority(items[i]);
                    stop = true;
                }
            }
        }

        sc.close();

        return prioritiesSum;
    }

    private static int secondPart(File input) throws FileNotFoundException {
        Scanner sc = new Scanner(input);

        char[] firstRucksack, secondRucksack, thirdRucksack;

        int prioritiesSum = 0;

        while (sc.hasNextLine()) {
            firstRucksack = sc.nextLine().toCharArray();
            secondRucksack = sc.nextLine().toCharArray();
            thirdRucksack = sc.nextLine().toCharArray();

            boolean stop = false;

            for (int i = 0; i < firstRucksack.length && !stop; i++) {
                for (int j = 0; j < secondRucksack.length && !stop; j++) {
                    if (firstRucksack[i] != secondRucksack[j]) {
                        continue;
                    }

                    for (int k = 0; k < thirdRucksack.length && !stop; k++) {
                        if (firstRucksack[i] != thirdRucksack[k]) {
                            continue;
                        }

                        prioritiesSum += getItemPriority(firstRucksack[i]);
                        stop = true;
                    }
                }
            }
        }

        sc.close();

        return prioritiesSum;
    }
    
    private static int getItemPriority(char item) {
        return Character.isUpperCase(item) ? item - 38 : item - 96;
    }
}