package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day01/input.txt");
        Scanner sc = new Scanner(input);

        String line;
        int currentElf = 0;

        int maxElf = 0;
        int[] topThree = new int[3];

        while (sc.hasNextLine()) {
            line = sc.nextLine();

            if (!line.isEmpty()) {
                currentElf += Integer.parseInt(line);
                continue;
            }

            if (currentElf > maxElf) {
                maxElf = currentElf;
                swap(topThree, 0, 1);
                swap(topThree, 0, 2);
                topThree[0] = currentElf;
            } else if (currentElf > topThree[1]) {
                swap(topThree, 1, 2);
                topThree[1] = currentElf;
            } else if (currentElf > topThree[2]) {
                topThree[2] = currentElf;
            }

            currentElf = 0;
        }

        System.out.println("Part 1: " + maxElf);
        System.out.println("Part 2: " + sum(topThree));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}