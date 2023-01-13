package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day04/input.txt");
        Scanner sc = new Scanner(input);

        String[] couple;
        int[] firstElf, secondElf;
        int fullOverlaps = 0, partialOverlaps = 0;

        while (sc.hasNextLine()) {
            couple = sc.nextLine().split(",");

            firstElf = mapToIntArray(couple[0].split("-"));
            secondElf = mapToIntArray(couple[1].split("-"));

            if ((firstElf[0] >= secondElf[0] && firstElf[1] <= secondElf[1]) || (secondElf[0] >= firstElf[0] && secondElf[1] <= firstElf[1])) {
                fullOverlaps++;
            }

            if ((firstElf[0] >= secondElf[0] && firstElf[0] <= secondElf[1]) || (secondElf[0] >= firstElf[0] && secondElf[0] <= firstElf[1])) {
                partialOverlaps++;
            }
        }

        System.out.println("Fully overlapped couples: " + fullOverlaps);
        System.out.println("Partially overlapped couples: " + partialOverlaps);
    }

    private static int[] mapToIntArray(String[] array) {
        return Arrays.stream(array)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}