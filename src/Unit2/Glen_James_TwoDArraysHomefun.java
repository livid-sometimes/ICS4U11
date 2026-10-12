package Unit2;

import java.util.Scanner;
import java.util.Random;

public class Glen_James_TwoDArraysHomefun {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many dice rolls? ");
        int numRolls = s.nextInt();

        System.out.print("Display (1) Raw Data or (2) Percentages: ");
        int mode = s.nextInt();

        int[][] rolls = new int[6][6];
        for (int i = 0; i < numRolls; i++) {
            int d1 = rand.nextInt(6);
            int d2 = rand.nextInt(6);
            rolls[d1][d2]++;
        }

        int[] sums = new int[13];

        System.out.println("\n2D Array Results:");
        System.out.println("     1   2   3   4   5   6");
        for (int r = 0; r < 6; r++) {
            System.out.print((r + 1) + " | ");
            for (int c = 0; c < 6; c++) {
                sums[(r + 1) + (c + 1)] += rolls[r][c];
                if (mode == 1) {
                    System.out.print(rolls[r][c] + "\t");
                } else {
                    double pct = (double) rolls[r][c] / numRolls * 100;
                    System.out.printf("%.1f%%\t", pct);
                }
            }
            System.out.println();
        }

        System.out.println("\nSum Totals (1D Array):");
        for (int i = 2; i <= 12; i++) {
            if (mode == 1) {
                System.out.println("Sum " + i + ": " + sums[i]);
            } else {
                double pct = (double) sums[i] / numRolls * 100;
                System.out.printf("Sum %d: %.1f%%\n", i, pct);
            }
        }

        System.out.println("\n--- BOOLEAN GRID ---");
        boolean[][] grid = new boolean[10][10];

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (rand.nextInt(100) < 35) {
                    grid[r][c] = true;
                }
            }
        }

        System.out.println("\nStandard Grid:");
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (grid[r][c]) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }

        System.out.println("\nPattern Grid:");
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (grid[r][c]) {
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        s.close();
    }
}