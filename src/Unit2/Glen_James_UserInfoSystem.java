package Unit2;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Glen_James_UserInfoSystem {

    // VIEWING / EDITING USERS //

    public static void editEmails(ArrayList<String[][]> data){

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        System.out.println(
                "\u001b[38;2;20;90;220m███████╗██████╗ ██╗████████╗    ███████╗███╗   ███╗ █████╗ ██╗██╗     ███████╗\n" +
                        "\u001b[38;2;50;130;240m██╔════╝██╔══██╗██║╚══██╔══╝    ██╔════╝████╗ ████║██╔══██╗██║██║     ██╔════╝\n" +
                        "\u001b[38;2;80;170;255m█████╗  ██║  ██║██║   ██║       █████╗  ██╔████╔██║███████║██║██║     ███████╗\n" +
                        "\u001b[38;2;110;200;255m██╔══╝  ██║  ██║██║   ██║       ██╔══╝  ██║╚██╔╝██║██╔══██║██║██║     ╚════██║\n" +
                        "\u001b[38;2;150;225;255m███████╗██████╔╝██║   ██║       ███████╗██║ ╚═╝ ██║██║  ██║██║███████╗███████║\n" +
                        "\u001b[38;2;200;245;255m╚══════╝╚═════╝ ╚═╝   ╚═╝       ╚══════╝╚═╝     ╚═╝╚═╝  ╚═╝╚═╝╚══════╝╚══════╝\n" +
                        "\u001b[38;2;255;255;255m                                                                       \u001b[0m"
        );

        int count = 0;

        FileReader frInfo = null;
        Scanner sInfo = null;

        Scanner userScanner = new Scanner(System.in);

        String[][] userInfo = data.get(0);
        String[][] userData = data.get(1);

        String enterUser = "";
        String enterPassword = "";
        String newEmail = "";

        int option = 0;

        try {
            frInfo = new FileReader("userInfo.txt");
        } catch (IOException e) {
            System.out.println("READING FILE ERROR, are you sure this file has been written?");
            return;
        }

        sInfo = new Scanner(frInfo);

        while (sInfo.hasNextLine()) {
            count++;
            System.out.println(count + ". " + sInfo.nextLine());
        }

        // Reset the Scanner and FileReader //
        try {
            frInfo.close();
            frInfo = new FileReader("userInfo.txt");
        } catch (IOException e) {
            System.out.println("READING FILE ERROR, are you sure this file has been written?");
            return;
        }

        sInfo.close();
        sInfo = new Scanner(frInfo);

        try {
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
            System.out.println("Who are you editing: ");

            option = userScanner.nextInt();

            System.out.println("ENTER USERNAME: ");
            enterUser = userScanner.nextLine();

            System.out.println("ENTER PASSWORD: ");
            enterPassword = userScanner.nextLine();

            if (userData[option - 1][0].equals(enterUser) && userData[option - 1][1].equals(enterPassword)) {
                System.out.println("Enter the new email address: ");

                // jump to that line //
                for (int i = 0; i < count; i++) {
                    if (!sInfo.hasNextLine()) { i = count; }
                    sInfo.nextLine();
                }

                System.out.println(sInfo.nextLine());

            } else {
                System.out.println("INVALID USERNAME or PASSWORD");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter a number.");
        } catch (ArrayIndexOutOfBoundsException f) {
            System.out.println("An error occurred while editing the email.");
        }

    }


    public static void displayUsers() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        System.out.println(
                "\u001b[38;2;128;0;128m                                                                     \n" +
                        "\u001b[38;2;144;32;112m                                                                     \n" +
                        "\u001b[38;2;160;64;96m                                   █▄                                 \n" +
                        "\u001b[38;2;176;96;80m             ▄    ▄         ▄     ▄██▄                     ▄        \n" +
                        "\u001b[38;2;191;128;64m ▄███▀ ██ ██ ████▄████▄▄█▀█▄ ████▄ ██    ██ ██ ▄██▀█ ▄█▀█▄ ████▄▄██▀█\n" +
                        "\u001b[38;2;207;160;48m ██    ██ ██ ██   ██   ██▄█▀ ██ ██ ██    ██ ██ ▀███▄ ██▄█▀ ██   ▀███▄\n" +
                        "\u001b[38;2;223;191;32m▄▀███▄▄▀██▀█▄█▀  ▄█▀  ▄▀█▄▄▄▄██ ▀█▄██   ▄▀██▀██▄▄██▀▄▀█▄▄▄▄█▀  █▄▄██▀\n" +
                        "\u001b[38;2;239;223;16m                                                                     \n" +
                        "\u001b[38;2;255;255;0m                                                                     \u001b[0m"
        );

        FileReader frInfo = null;
        Scanner sInfo = null;

        Scanner userScanner = new Scanner(System.in);

        try {
            frInfo = new FileReader("userInfo.txt");
        } catch (IOException e) {
            System.out.println("READING FILE ERROR, are you sure this file has been written?");
            return;
        }

        sInfo = new Scanner(frInfo);

        while (sInfo.hasNextLine()) {
            System.out.println(sInfo.nextLine());
        }

        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Press any key to exit");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
        userScanner.nextLine();
    }

    public static ArrayList<String[][]> addEmail() {
        int lineCount = 0;

        FileReader frInfo = null;
        FileReader frData = null;

        Scanner sInfo = null;
        Scanner sData = null;

        ArrayList<String[][]> data = new ArrayList<>();

        boolean isDoneAdding = false;

        try {
            frInfo = new FileReader("userInfo.txt");
            frData = new FileReader("userData.txt");
        } catch (IOException e) {
            System.out.println("READING FILE ERROR, are you sure this file has been written?");
            return null;
        }

        // create new scanners just for the files
        sInfo = new Scanner(frInfo);
        sData = new Scanner(frData);

        while (sInfo.hasNextLine()) { // checks how many users are there.
            sInfo.nextLine();
            lineCount++;
        }

        try {
            frInfo.close();
            frInfo = new FileReader("userInfo.txt"); // create a new one because the reader was at the last line
        } catch (IOException e) {
            System.out.println("READING FILE ERROR, are you sure this file has been written?");
            return null;
        }

        sInfo.close();

        String[][] userInfo = new String[lineCount][3];
        String[][] userData = new String[lineCount][3];

        sInfo = new Scanner(frInfo);

        // write the data into the 2d array
        for (int i = 0; i < userInfo.length; i++) {
            String infoLine = sInfo.nextLine();
            String dataLine = sData.nextLine();

            // userInfo
            // [0] -> Name
            // [1] -> B-Date
            // [2] -> Email

            // userData
            // [0] -> Username
            // [1] -> Password

            // find where the comma takes place
            int infoLineFirstComma = infoLine.indexOf(","); // for the first separation
            int infoLineSecondComma = infoLine.indexOf(",", infoLineFirstComma + 1); // for the second separation

            int commaData = dataLine.indexOf(","); // returns an index based on the String

            userInfo[i][0] = infoLine.substring(0, infoLineFirstComma);
            userInfo[i][1] = infoLine.substring(infoLineFirstComma + 2, infoLineSecondComma); // removes the space from the formatting
            userInfo[i][2] = userInfo[i][2] = infoLine.substring(infoLineSecondComma + 2);

            userData[i][0] = dataLine.substring(0, commaData);
            userData[i][1] = dataLine.substring(commaData + 2); // removes the space from the formatting
        }

        System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Profile Created!");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

        // add them to the data array list //

        /*
            data.get(0) -> userInfo
            data.get(1) -> userData
        */

        data.add(userInfo);
        data.add(userData);

        return data;
    }

    public static String createPassword(String login) {
        Scanner s = new Scanner(System.in);

        String password = "";
        String[] userLoginCredits = new String[2];

        boolean hasCapital = false;
        boolean hasLowerCase = false;
        boolean hasNumbers = false;
        boolean hasSymbols = false;

        boolean isValidPassword = false;

        while (!isValidPassword) {
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
            System.out.println("CREATE A PASSWORD: ");
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
            password = s.nextLine();

            if (password.length() < 12) {
                System.out.println("Password is too short.");
                continue;
            }

            for (int i = 0; i < password.length(); i++) {

                if (Character.isLowerCase(password.charAt(i))) {
                    hasLowerCase = true;
                } else if (Character.isUpperCase(password.charAt(i))) {
                    hasCapital = true;
                } else if (Character.isDigit(password.charAt(i))) {
                    hasNumbers = true;
                } else if (!Character.isLetterOrDigit(password.charAt(i))) {
                    hasSymbols = true;
                }
            }

            if (hasLowerCase && hasCapital && hasNumbers && hasSymbols) {
                isValidPassword = true;
            } else {
                // RESET IT //
                hasLowerCase = false;
                hasNumbers = false;
                hasSymbols = false;
                hasCapital = false;

                System.out.println();
                System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
                System.out.println("PASSWORD IS NOT VALID.");
                System.out.println("make sure to have:");

                System.out.println("1. at least one lower case letter");
                System.out.println("2. at least one upper case letter");
                System.out.println("3. at least one number");
                System.out.println("4. at least one symbol. e.x: \"^\", \"@\"");
                System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

                for (int i = 0; i < 3; i++) {
                    System.out.println(); // create spaces
                }
            }
        }

        userLoginCredits[0] = login;
        userLoginCredits[1] = password;

        // file variables //
        FileWriter fw = null;

        try {
            fw = new FileWriter("userData.txt", true);
        } catch (IOException e) {
            System.out.println("Error happened when creating the file.");
        }

        PrintWriter pw = new PrintWriter(fw);

        pw.print(login + ", " + password);
        pw.println();
        pw.close();

        return password;
    }

    public static String doLogin() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        System.out.println(
                "\u001b[38;2;168;85;247m                                .                                                                    \n" +
                        "\u001b[38;2;192;38;211m  ....  ... ..    ....    ....   .||.     ....     ... ...    ....     ....   ... ..      \n" +
                        "\u001b[38;2;147;51;234m.|   ''  ||' '' .|...|| '' .||    ||   .|...||     ||  ||  ||. '  .|...||   ||' ''      \n" +
                        "\u001b[38;2;59;130;246m ||       ||     ||     .|' ||    ||   ||           ||  ||  . '|..    ||     ||           \n" +
                        "\u001b[38;2;6;182;212m '|...' .||.     '|...' '|..'|'  '|.'   '|...'     '|..'|. |'..|'  '|...' .||.          \n" +
                        "\u001b[38;2;14;165;233m                                                                                                     \n" +
                        "\u001b[38;2;6;182;212m                                                                                                     \u001b[0m"
        );



        Scanner s = new Scanner(System.in);

        // Strings variables //
        String firstName = "";
        String middleName = "";
        String lastName = "";

        String email = "";

        String[] names = new String[3];

        String birthDate = ""; // will be using (MMDDYYYY)

        boolean isValidBirth = false;
        boolean isValidNames = false;

        // creating the login variables //
        String lastTwo = "";
        String firstThree = "";

        String days = "";
        String reverseOrder = "";

        String tempReverse = "";
        String login = "";

        // file writing variable //
        FileWriter fw = null;
        try {
            fw = new FileWriter("userInfo.txt", true);
        } catch (IOException e) {
            System.out.println("Error happened when creating the file.");
        }

        // try until we get a valid name //
        while (!isValidNames) {
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
            System.out.println("==> if your name has a space, make sure to have a hyphen! <==");
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

            System.out.println("What is your first name?");
            firstName = s.nextLine();

            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

            names[0] = firstName;

            System.out.println("What is your middle name?");
            middleName = s.nextLine();

            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

            names[1] = middleName;

            System.out.println("What is your last name?");
            lastName = s.nextLine();
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

            names[2] = lastName;

            for (int i = 0; i < names.length; i++) {
                isValidNames = validateName(names[i]);

                if (!isValidNames) {i = names.length;}
            }

            if (!isValidNames) {
                System.out.println("[SYSTEM] one of your names is invalid, please try again.");
            }
        }


        // try until we get a valid birthday //
        while (!isValidBirth) {
            System.out.println("What is your birth date? (use MMDDYYYY)");
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

            // read it as a string because on default, java removes the 0
            // e.x 01321 -> 1321

            birthDate = s.nextLine();
            isValidBirth = validateBirth(birthDate);
        }

        System.out.println("═══════════════════════════════════════════════════════════════════════════════════");
        System.out.println("What is your email?");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

        email = s.nextLine();

        // emails are usually lower case
        email.toLowerCase();

        // NOW, write it to the new userInfo.txt
        PrintWriter pw = new PrintWriter(fw);

        pw.print(firstName + " " + middleName + " " + lastName + ", ");
        pw.print(birthDate.substring(0, 2) + "-" + birthDate.substring(2, 4) + "-" + birthDate.substring(4, 8) + ", ");
        pw.print(email);

        pw.println(); // create a space for the next lines.

        pw.close();

        lastTwo = lastName.substring(lastName.length() - 2);
        firstThree = middleName.substring(0, 3);
        days = birthDate.substring(2, 4);

        reverseOrder = firstName.substring(0, 4);

        for (int i = reverseOrder.length() - 1; i > reverseOrder.length() - 4; i--) {
            tempReverse += reverseOrder.charAt(i);
        }

        reverseOrder = tempReverse;

        login = (lastTwo + firstThree + days + reverseOrder).toLowerCase();

        System.out.println("Your login is, " + login + ".");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

        return login;
    }


    // VALIDATORS //

    public static boolean validateName(String name) {
        // NOTE: min name length is 4 //
        if (name.length() < 4) {
            System.out.println("not valid");
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                System.out.println("has space");
                return false;
            }
        }

        return true;
    }

    public static boolean validateBirth(String birthDate) {
        // see if it's a valid int //
        try {
            Integer.parseInt(birthDate); // tries to parse it to an integer, (basically seeing if it's a valid num)
        } catch (NumberFormatException e) {
            System.out.println("[SYSTEM] INVALID BIRTH DATE");
            return false;
        }

        // first check: if it is an int with a length of 8 //
        // NOTE: the date must be MMDDYYYY -> hence the string length of 8
        if (birthDate.length() != 8) {
            return false;
        }

        // second check: see if the first two nums are in the range of 1 - 12 //
        String monthStr = birthDate.substring(0, 2);
        String daysStr = birthDate.substring(2, 4);
        String yearStr = birthDate.substring(4, 8);

        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(daysStr);
        int year = Integer.parseInt(yearStr);

        boolean isLeapYear = false;

        // as of making this the max year is 2026 //
        final int maxYear = 2026;

        if (month < 1 || month > 12) {
            return false;
        }

        // leap year check //

        // NOTE: the leap year rule is confusing me, I just had to follow how the calculators did it.
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            isLeapYear = true;
        }

        // max year check //
        if (maxYear < year) {
            return false;
        }

        // third check: see if the dates actually make sense. //
        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day >= 1 && day <= 30)) {
            return true;
        } else if ((month == 2 && day == 29) && isLeapYear) {
            return true;
        } else if ((day >= 1 && day < 28) && (month == 2)) {
            return true;
        } else if ((day >= 1 && day <= 31) && (month != 2 && month != 4 && month != 6 && month != 9 && month != 11)) {
            return true;
        } else {
            System.out.println("[SYSTEM] INVALID BIRTH DATE");
            return false;
        }

    }

    public static void main(String[] args) throws InterruptedException{

        // important variables //
        String login;

        boolean isDone = false;
        int option = 0;

        ArrayList<String[][]> data = new ArrayList<>();

        Scanner s = new Scanner(System.in);


        /*
            On startup, wipe the old userInfo.txt and userData.txt
        */

        try {
            new FileWriter("userInfo.txt", false);
            new FileWriter("userData.txt", false);
        } catch (IOException e) {
            System.out.println("Failed to wipe, are you sure these file exist?");
        }


        while (!isDone) {
            try {
                System.out.println("\u001B[38;2;0;255;255m▄▄▄█████▓▓█████  ▄████▄   ██░ ██     ██▓    ██▓     ▒█████   ██▒   █▓▓█████ \n" + "\u001B[38;2;0;225;255m▓  ██▒ ▓▒▓█   ▀ ▒██▀ ▀█  ▓██░ ██▒   ▓██▒   ▓██▒    ▒██▒  ██▒▓██░   █▒▓█   ▀ \n" + "\u001B[38;2;0;195;255m▒ ▓██░ ▒░▒███   ▒▓█    ▄ ▒██▀▀██░   ▒██▒   ▒██░    ▒██░  ██▒ ▓██  █▒░▒███   \n" + "\u001B[38;2;0;165;255m░ ▓██▓ ░ ▒▓█  ▄ ▒▓▓▄ ▄██▒░▓█ ░██    ░██░   ▒██░    ▒██   ██░  ▒██ █░░▒▓█  ▄ \n" + "\u001B[38;2;0;135;255m  ▒██▒ ░ ░▒████▒▒ ▓███▀ ░░▓█▒░██▓   ░██░   ░██████▒░ ████▓▒░   ▒▀█░  ░▒████▒\n" + "\u001B[38;2;0;120;235m  ▒ ░░   ░░ ▒░ ░░ ░▒ ▒  ░ ▒ ░░▒░▒   ░▓     ░ ▒░▓  ░░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░\n" + "\u001B[38;2;0;105;215m    ░     ░ ░  ░  ░  ▒    ▒ ░▒░ ░    ▒ ░   ░ ░ ▒  ░  ░ ▒ ▒░    ░ ░░   ░ ░  ░\n" + "\u001B[38;2;0;90;195m  ░         ░   ░         ░  ░░ ░    ▒ ░     ░ ░   ░ ░ ░ ▒       ░░     ░   \n" + "\u001B[38;2;0;75;175m            ░  ░░ ░       ░  ░  ░    ░         ░  ░    ░ ░        ░     ░  ░\n" + "\u001B[38;2;0;60;155m                ░                                                ░          \u001B[0m");
                System.out.println("═══════════════════════════════════════════════════════════════════════════════════");

                System.out.println("[WELCOME TO THE USER INFO SYSTEM.]");

                System.out.println("==> 1. Create a new user.");
                System.out.println("==> 2. View current users.");
                System.out.println("==> 3. Edit a users email.");
                System.out.println("==> 4. Exit the program.");

                option = s.nextInt();

                switch (option) {
                    case 1:
                        login = doLogin();
                        createPassword(login);
                        data = addEmail();

                        break;
                    case 2:
                        displayUsers();

                        break;
                    case 3:
                        editEmails(data);

                        break;

                    case 4:

                        for (int i = 0; i < 10; i++) {
                            System.out.println();
                        }

                        System.out.println("This Program was made by: ");

                        sleep(400);

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

                        isDone = true;
                        break;
                    default:
                        System.out.println("invalid option");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("INVALID OPTION");
                s.nextLine();
            }

        }
    }
}