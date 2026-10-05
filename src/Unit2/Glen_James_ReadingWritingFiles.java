package Unit2;

import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class Glen_James_ReadingWritingFiles {

    public static void main(String[] args) throws IOException {
        // Question One w/ all modifiers

        try {
            FileWriter fileWriter = new FileWriter("file01.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Scanner scanner = new Scanner(System.in);

            printWriter.println(scanner.nextLine());
            printWriter.close();

        } catch (IOException e) {
            System.out.println("error happened");
        }

        System.out.println("QUESTION TWO");

        // Question 2
        try {
            FileWriter fileWriter = new FileWriter("file02.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            int tempNum = 0;
            Random r = new Random();

            for (int i = 0; i < 5; i++) {
                tempNum = r.nextInt(5) + 1;

                printWriter.println(tempNum);
                System.out.println(tempNum);

            }

            printWriter.close();

        } catch (IOException e) {

        }



    }
}
