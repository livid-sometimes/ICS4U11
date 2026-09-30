package Unit1REVIEW;

import java.util.Scanner;


public class Glen_James_WordGuess {
    public static void main(String[] args) {
        String answer = "SPRING";
        int ansLength = 0;
        int counter = 0;
        char input = ' ';
        boolean end = false;
        boolean correct = false;
        String changeWord = "";
        String progress = "";
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the Word Guess game!!\ndo you want to set the word? (Yes or enter anything else if no)\n");
        changeWord = s.nextLine();
        if (changeWord.equalsIgnoreCase("yes")||changeWord.equalsIgnoreCase("Y")) {
            System.out.println("enter word: ");
            answer = s.nextLine();
            answer = answer.toUpperCase();
        }

        ansLength = answer.length();
        for (int i = 0; i < ansLength; i++) {
            progress += "-";
        }

        System.out.println("word guess game");
        System.out.println(progress);


        while (!end){

            counter++;

            input = input(s);

            if (input == '!') {

                correct = wordGuess(s, answer);
                end = true;

            } else {
                progress = charGuess(input, answer,progress, ansLength);
                System.out.println(progress);
            }

            if (progress.equals(answer)) {
                correct = true;
                end = true;

            }
        }//end while

        if (correct) {
            if (counter != 1) {
                System.out.println("congrats, you win! it took you " + counter + " guesses.");
            } else {
                System.out.println("congrats, you win! you got it on the first try!");
            }


        } else {
            System.out.println("Wrong. You lose.");
        }


    }

    public static char input (Scanner s){

        String input = "";
        char validInput = '0';

        System.out.print("Enter a letter (! to guess entire word): ");

        input = s.nextLine();
        input = input.toUpperCase();
        validInput = input.charAt(0);

        return validInput;

    }

    public static String charGuess (char input, String answer, String progress,  int ansLength) {
        for (int i = 0; i < ansLength; i++) {
            if (input == answer.charAt(i)) {
                if (progress.charAt(i) == '-'){
                    progress = progress.substring(0,i) + answer.charAt(i) + progress.substring(i+1);
                }
            }
        }
        return progress;
    }

    public static boolean wordGuess (Scanner s, String answer) {
        String guess = "";
        System.out.println("What is your guess?");
        guess = s.nextLine();
        guess = guess.trim().toUpperCase();
        if (guess.equals(answer)) {
            System.out.println("good guess!");
            return true;
        } else {
            return false;
        }
    }
}
