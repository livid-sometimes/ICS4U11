package Unit2;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * Glen_James_Magic8Ball.java
 * Description: Just like the toy, it gives responses per 'shake' some positive, some negative, some neutral. Asks the user
 * if they want to 'shake' again.
 * Name: James Glen
 * Date: October 6, 2026
 */

// READ THE NOTES IF CONFUSED ABOUT WHY THERE'S COLORS. //
// ANY WAY FIRST "new" CONCEPT ASSIGNMENT FOR ME, THIS WAS FUN TO MAKE! //

public class Glen_James_Magic8Ball {

    /**
     * Pre-Condition: A valid 2d String array being passed through.
     * Post-Condition: The procedure displays a random messages based on the Random object's selection.
     *
     * Description: Creates a message from the pool of topics from the responses parameter and from there takes a random message
     * from the topic.

     * @param responses A 2D array containing the categories and their associated answers
     * @throws InterruptedException Used for the sleep method, causing the pause effect in the System.out
     */


    public static void eightBall(String[][] responses) throws InterruptedException {
        System.out.println("=========================================================");

        // init scanner and random objects.
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        // variables
        int responsesLength = responses.length; // gets the 2d arrays length.
        int randomTopic = r.nextInt(responsesLength); // [0, responsesLength)

        int selectedTopicMessageLength = responses[randomTopic].length;
        int randomMessage = r.nextInt(1, selectedTopicMessageLength);

        // == main sequence == //

        System.out.println("⓼: \"Tell me a question... any question...\"");
        System.out.print(System.getProperty("user.name") + ": ");

        s.nextLine(); // we aren't storing the question, so why bother making a variable.
        System.out.print("=========================================================");
        sleep(500);

        System.out.print("\n⓼: \"");

        for (int i = 0; i < 3; i++) { // make a "..." effect.
            sleep(150);
            System.out.print(".");
        }

        System.out.print("\"");
        sleep(100);

        System.out.println(); // little space.
        sleep(300);

        System.out.println("⓼: \"I feel... " + responses[randomTopic][0] + ".\u001B[0m\""); // NOTE: [0] is always the category.
        sleep(300);

        System.out.println("⓼: \"\u001B[3m" +  responses[randomTopic][randomMessage] + ".\"" + "\u001B[0m");
        sleep(300);

        System.out.println("=========================================================");

    }


    public static void main(String[] args) throws InterruptedException {

        /*
            NOTE: index 0 for each array must be the category of message

            \u001B - starts an ANSI escape sequence.
            -> meaning the 38; means color the fore text, not the background.
            -> 2 means true colors ( like im able to use RGB )
            -> 2 (r), 27 (g), 223 (b) ; color codes. not hex, RGB or color3
            -> m closes the escape sequence.

            \u001B[3m - makes the text italics

            \u001B[0m - stops all previous escape sequence effects. and resets it to the terminals default.
            ( I usually put them at the end of the string )

        */

        /*
            NOTE: why would it be rows instead of columns, each array has a different length of message... causing a
            IndexOutOfBounds Exception! So, I did columns instead to avoid this issue.
         */

        // Messages //
        String[] Positive = {
                "\u001B[38;2;27;223;106mPositive",
                "It is certain",
                "It is decidedly so",
                "Without a doubt",
                "Yes definitely",
                "You may rely on it",
                "As I see it, yes",
                "Most likely",
                "Outlook good",
                "Yes",
                "Signs point to yes"
        };

        String[] Uncertain = {
                "\u001B[38;2;0;128;255mUncertain",
                "Reply hazy, try again",
                "Ask again later",
                "Better not tell you now",
                "Cannot predict now",
                "Concentrate and ask again"
        };

        String[] Negative = {
                "\u001B[38;2;255;51;51mNegative",
                "Don’t count on it",
                "My reply is no",
                "My sources say no",
                "Outlook not so good",
                "Very doubtful"
        };

        String[][] responses = {Positive, Uncertain, Negative}; // create a 2d array based on the messages.

        // variables //
        Scanner mainS = new Scanner(System.in); // creating a scanner here as well. (since the only param for the eight-ball method is only a String[][])
        String option = "";

        boolean isDone = false;

        System.out.println(
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
        System.out.println("=========================================================");

        System.out.println("                                                \n" +
                "\u001B[38;2;0;0;0m                ▄▄            ▄▄          ▄▄ ▄▄ \n" +
                "      ▀▀        ██     ██     ██          ██ ██ \n" +
                "▄█▀█▄ ██  ▄████ ████▄ ▀██▀▀   ████▄  ▀▀█▄ ██ ██ \n" +
                "\u001B[38;2;255;255;255m██▄█▀ ██  ██ ██ ██ ██  ██     ██ ██ ▄█▀██ ██ ██ \n" +
                "\u001B[38;2;0;0;0m▀█▄▄▄ ██▄ ▀████ ██ ██  ██     ████▀ ▀█▄██ ██ ██ \n" +
                "             ██                                 \n" +
                "           ▀▀▀                                 \u001B[0m ");

        System.out.println("=========================================================");

        System.out.println("Bobby the Eighth: \"Welcome to the eight ball.\"");
        sleep(200);

        eightBall(responses); // call the eightBall method

        // then we ask again if they want to prompt.
        while (!isDone) {
            sleep(300);

            System.out.println("Bobby the Eighth: \"Want to shake the eight ball again " + System.getProperty("user.name") + "?\"");
            System.out.println("(make sure to answer with a \"YES\" or \"Y\", any other answer is a no.)".toUpperCase());

            sleep(100);

            System.out.println("=========================================================");
            System.out.print(System.getProperty("user.name") + ": "); // get the systems OS name.

            option = mainS.nextLine();

            if (option.equalsIgnoreCase("YES") || option.equalsIgnoreCase("Y")) {
                eightBall(responses); // then call the method again.
            } else {
                System.out.println("=========================================================");
                System.out.println("Bobby the Eighth: \"See you later then.\"");
                isDone = true;
            }
        }
    }
}