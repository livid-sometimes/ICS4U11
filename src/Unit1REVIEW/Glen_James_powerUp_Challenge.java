package Unit1REVIEW;

import java.util.*;

/**
 * Unit1REVIEW.Glen_James_powerUp_Challenge.java
 * Description: Delivers positive power-up messages based on user input.
 * Name: James Glen
 * Date: Sep 23, 2026
 */

public class Glen_James_powerUp_Challenge {
    public static void main(String[] args) {

        // variables
        Scanner s = new Scanner(System.in);

        int count = 0;
        int numOption = 0;
        String message = "";

        // introduction

        System.out.println( // we are so back, and i figured out how to do colors! god i love documentations.
                "\u001B[38;2;255;30;30m▄▄▄██▀▀▀▄▄▄       ███▄ ▄███▓▓█████   ██████      ▄████  ██▓    ▓█████  ███▄    █ \n" +
                        "\u001B[38;2;230;20;20m   ▒██  ▒████▄    ▓██▒▀█▀ ██▒▓█   ▀ ▒██    ▒     ██▒ ▀█▒▓██▒    ▓█   ▀  ██ ▀█   █ \n" +
                        "\u001B[38;2;200;10;10m   ░██  ▒██  ▀█▄  ▓██    ▓██░▒███   ░ ▓██▄      ▒██░▄▄▄░▒██░    ▒███   ▓██  ▀█ ██▒\n" +
                        "\u001B[38;2;175;0;0m▓██▄██▓ ░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄   ▒   ██▒   ░▓█  ██▓▒██░    ▒▓█  ▄ ▓██▒  ▐▌██▒\n" +
                        "\u001B[38;2;150;0;0m ▓███▒   ▓█   ▓██▒▒██▒   ░██▒░▒████▒▒██████▒▒   ░▒▓███▀▒░██████▒░▒████▒▒██░   ▓██░\n" +
                        "\u001B[38;2;125;0;0m ▒▓▒▒░   ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░▒ ▒▓▒ ▒ ░    ░▒   ▒ ░ ▒░▓  ░░░ ▒░ ░░ ▒░   ▒ ▒ \n" +
                        "\u001B[38;2;100;0;0m ▒ ░▒░    ▒   ▒▒ ░░  ░      ░ ░ ░  ░░ ░▒  ░ ░     ░   ░ ░ ░ ▒  ░ ░ ░  ░░ ░░   ░ ▒░\n" +
                        "\u001B[38;2;75;0;0m ░ ░ ░    ░   ▒   ░      ░      ░   ░  ░  ░     ░ ░   ░   ░ ░      ░      ░   ░ ░ \n" +
                        "\u001B[38;2;50;0;0m ░   ░        ░  ░       ░      ░  ░      ░           ░     ░  ░   ░  ░         ░ \u001B[0m"
        );



        System.out.println("\n****************************************");
        System.out.println("[POSITIVITY POWER-UP CHALLENGE]");
        System.out.println("****************************************\n");

        System.out.println("Welcome, " + System.getProperty("user.name") + "! Enter a number between 10 and 99 to unlock a positive message.");
        System.out.println("Enter a negative number when you're ready to end your mission.");

        while (numOption >= 0) {
            System.out.println("\n[REMEMBER] enter a negative number to leave!");
            System.out.print("Enter a number: ");

            /*
                Little James note, I wanted to use String Arrays, but I like seeing the same output when I try to do
                The weird cases (ex. the last 2) because I'm not that smart. So, try and catch (because i use them a lot)

                Any who it was quite fun to work on an assignment again!
            */


            try {
                numOption = s.nextInt();

                if (numOption >= 10 && numOption <= 99) {
                    count++;

                    // separates the first digit and last digit.
                    int firstDigit = numOption / 10;
                    int lastDigit = numOption % 10;

                    if (numOption % 5 == 0 && numOption % 10 != 0) {
                        message = "[POWER-UP]: YOUR KINDNESS CAN MAKE DAYS BRIGHTER!";
                    } else if (numOption % 3 == 0 && numOption % 7 == 0) {
                        message = "[POWER-UP]: RECHARGE YOUR SPIRIT AND PASS THE JOY FORWARD!";
                    } else if (numOption == 24 || numOption == 81 || numOption == 87 || numOption == 93 || numOption == 97 || numOption % 11 == 0) {
                        message = "[POWER-UP]: YOU HAVE MASTERED THE GOLDEN RULE!";
                    } else if ((lastDigit % 3 == 0) && (firstDigit == 7 || firstDigit == 8)) {
                        message = "[POWER-UP]: GREAT GRATITUDE COMES GREAT RESPONSIBILITY.";
                    } else if ((firstDigit % 3 != 0) && (lastDigit == 0 || lastDigit == 1)) {
                        message = "[POWER-UP]: YOUR BIG HEART CAN MAKE A 0 INTO A 1!";
                    } else {
                        message = "[POWER-UP]: YOUR SOUL IS PURE, USE THAT TO HELP PEOPLE.";
                    }

                } else if (numOption < 0) {
                    message = "\nMission Complete!";
                } else { // not part of the range positive numbers
                    message = "[WARNING] NUMBER DOESN'T FALL INTO THE RANGE, Enter a number between 10-99.";
                }

            } catch (InputMismatchException e) { // catches non-integer input
                message = "[WARNING] INVALID NUMBER";
                s.nextLine();
            }

            System.out.println(message);
        }


        // ending sequence.
        System.out.println("Positive messages delivered: " + count);
        System.out.println("Thank you for helping spread positivity, " + System.getProperty("user.name") + "!");
    }
}