package Unit2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Glen_James_UserInfoSystem {

    public static int findChar(String s, char c) {
        int toReturn = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                toReturn = i;
                i = s.length();
            }
        }

        return toReturn;
    }

    public static void addEmail(Scanner s) {
        int lineCount = 0;

        FileReader frInfo = null;
        FileReader frData = null;

        boolean isDoneAdding = false;

        try {
            frInfo = new FileReader("userInfo.txt");
            frData = new FileReader("userData.txt");
        } catch (IOException e) {
            System.out.println("READING FILE ERROR, are you sure this file has been written?");
            return;
        }

        // create new scanners just for the files
        Scanner sInfo = new Scanner(frInfo);
        Scanner sData = new Scanner(frData);

        while (sInfo.hasNextLine()) { // checks how many usernames are there.
            sInfo.nextLine();
            lineCount++;
        }

        try {
            frInfo.close();
            frInfo = new FileReader("userInfo.txt"); // create a new one because the reader was at the last line
        } catch (IOException e) {
            System.out.println("READING FILE ERROR, are you sure this file has been written?");
            return;
        }

        sInfo.close();

        String[][] userInfo = new String[lineCount][3];
        String[][] userData = new String[lineCount][3];

        sInfo = new Scanner(frInfo);

        // write the data into the 2d array
        for (int i = 0; i < userInfo.length; i++) {
            String infoLine = sInfo.nextLine();
            String dataLine = sData.nextLine();

            // [0] -> Name
            // [1] -> B-Date
            // [2] -> Email (will be null for now)

            // find where the comma takes place
            int commaInfo = findChar(infoLine, ','); // returns an index based on the String
            int commaData = findChar(dataLine, ','); // returns an index based on the String

            userInfo[i][0] = infoLine.substring(0, commaInfo);
            userInfo[i][1] = infoLine.substring(commaInfo + 2); // removes the space from the formatting
            userInfo[i][2] = null;

            userData[i][0] = dataLine.substring(0, commaData);
            userData[i][1] = dataLine.substring(commaData + 2); // removes the space from the formatting

            System.out.println(userInfo[i][0]);
            System.out.println(userInfo[i][1]);

            System.out.println(userData[i][0]);
            System.out.println(userData[i][1]);

            System.out.println("===================================================================================>");
        }

        // email time //
        while (!isDoneAdding) {

            int option = 0;
            int count = 0;

            String username = "";
            String password = "";
            String email = "";

            System.out.println("===================================================================================>");

            for (int i = 0; i < userInfo.length; i++) {
                String personName = userInfo[i][0];

                if (userInfo[i][2] == null) {
                    System.out.println(i + 1 + ". " + personName);
                    count++;
                }
            }

            System.out.println("===================================================================================>");
            System.out.println("Select the following person to add an email to.");

            try {
                option = s.nextInt();

                if (option > count || option <= 0) {
                    System.out.println("invalid option");
                    continue;
                }

                System.out.println("SELECTED -> " + userInfo[option - 1][0]);

                System.out.println("ENTER LOGIN: ");
                username = s.nextLine();

                System.out.println("ENTER PASSWORD: ");
                password = s.nextLine();

                if (username.equals(userData[option - 1][0]) && password.equals(userData[option - 1][1])) {
                    System.out.println("Enter a new email: ");
                    email = s.nextLine();
                } else {
                    System.out.println("INCORRECT LOGIN AND PASSWORD");
                }


            } catch(InputMismatchException e) {
                System.out.println("INVALID NUM");
            }
        }




    }

    public static String createPassword(Scanner s, String login) {
        String password = "";
        String[] userLoginCredits = new String[2];

        boolean hasCapital = false;
        boolean hasLowerCase = false;
        boolean hasNumbers = false;
        boolean hasSymbols = false;

        boolean isValidPassword = false;

        while (!isValidPassword) {
            System.out.println("===================================================================================>");
            System.out.println("CREATE A PASSWORD: ");
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
                System.out.println("PASSWORD IS NOT VALID.");
                System.out.println("make sure to have:");

                System.out.println("1. at least one lower case letter");
                System.out.println("2. at least one upper case letter");
                System.out.println("3. at least one number");
                System.out.println("4. at least one symbol. e.x: \"^\", \"@\"");

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

    public static String doLogin(Scanner s) {
        // Strings variables //
        String firstName = "";
        String middleName = "";
        String lastName = "";

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
            System.out.println("==> if your name has a space, make sure to have a hyphen! <==");
            System.out.println("===================================================================================>");
            System.out.println("What is your first name?");
            firstName = s.nextLine();
            System.out.println("===================================================================================>");

            names[0] = firstName;

            System.out.println("What is your middle name?");
            middleName = s.nextLine();
            System.out.println("===================================================================================>");

            names[1] = middleName;

            System.out.println("What is your last name?");
            lastName = s.nextLine();
            System.out.println("===================================================================================>");

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

            // read it as a string because on default, java removes the 0
            // e.x 01321 -> 1321

            birthDate = s.nextLine();
            isValidBirth = validateBirth(birthDate);
        }

        // NOW, write it to the new userInfo.txt
        PrintWriter pw = new PrintWriter(fw);

        pw.print(firstName + " " + middleName + " " + lastName + ", ");
        pw.print(birthDate.substring(0, 2) + "-" + birthDate.substring(2, 4) + "-" + birthDate.substring(4, 8));
        pw.println(); // create a space for the next lines.


        pw.close();

        lastTwo = lastName.substring(lastName.length() - 2);
        firstThree = middleName.substring(0, 3);
        days = birthDate.substring(2, 4);

        reverseOrder = firstName.substring(0, 4);

        for (int i = reverseOrder.length() - 1; i > reverseOrder.length() - 4; i--) {
            tempReverse += reverseOrder.charAt(i - 1);
        }

        reverseOrder = tempReverse;

        login = (lastTwo + firstThree + days + reverseOrder).toLowerCase();
        System.out.println("===================================================================================>");

        System.out.println("Your login is, " + login + ".");

        return login;
    }


    // VALIDATORS //

    public static boolean validateName(String name) {
        // NOTE: Mrs. Schembri said min name length is 3, so i'll do 3 for the min //
        if (name.length() < 3) {
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

    public static void main(String[] args) {

        // important variables //
        String login;
        String password;

        boolean isDone = false;
        String option = "";

        Scanner s = new Scanner(System.in);

        System.out.println("\u001B[38;2;0;255;255m▄▄▄█████▓▓█████  ▄████▄   ██░ ██     ██▓    ██▓     ▒█████   ██▒   █▓▓█████ \n" + "\u001B[38;2;0;225;255m▓  ██▒ ▓▒▓█   ▀ ▒██▀ ▀█  ▓██░ ██▒   ▓██▒   ▓██▒    ▒██▒  ██▒▓██░   █▒▓█   ▀ \n" + "\u001B[38;2;0;195;255m▒ ▓██░ ▒░▒███   ▒▓█    ▄ ▒██▀▀██░   ▒██▒   ▒██░    ▒██░  ██▒ ▓██  █▒░▒███   \n" + "\u001B[38;2;0;165;255m░ ▓██▓ ░ ▒▓█  ▄ ▒▓▓▄ ▄██▒░▓█ ░██    ░██░   ▒██░    ▒██   ██░  ▒██ █░░▒▓█  ▄ \n" + "\u001B[38;2;0;135;255m  ▒██▒ ░ ░▒████▒▒ ▓███▀ ░░▓█▒░██▓   ░██░   ░██████▒░ ████▓▒░   ▒▀█░  ░▒████▒\n" + "\u001B[38;2;0;120;235m  ▒ ░░   ░░ ▒░ ░░ ░▒ ▒  ░ ▒ ░░▒░▒   ░▓     ░ ▒░▓  ░░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░\n" + "\u001B[38;2;0;105;215m    ░     ░ ░  ░  ░  ▒    ▒ ░▒░ ░    ▒ ░   ░ ░ ▒  ░  ░ ▒ ▒░    ░ ░░   ░ ░  ░\n" + "\u001B[38;2;0;90;195m  ░         ░   ░         ░  ░░ ░    ▒ ░     ░ ░   ░ ░ ░ ▒       ░░     ░   \n" + "\u001B[38;2;0;75;175m            ░  ░░ ░       ░  ░  ░    ░         ░  ░    ░ ░        ░     ░  ░\n" + "\u001B[38;2;0;60;155m                ░                                                ░          \u001B[0m");

        /*
            On startup, wipe the old userInfo.txt and userData.txt
        */

        try {
            FileWriter fw = new FileWriter("userInfo.txt", false);
            FileWriter fw2 = new FileWriter("userData.txt", false);
        } catch (IOException e) {
            System.out.println("Failed to wipe, are you sure these file exist?");
        }


        while (!isDone) {
            System.out.println("===================================================================================>");
            System.out.println("Would you like to create a user? ");
            System.out.println("Any other answer than Y or Yes will be considered as no.");

            option = s.nextLine();

            if (option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("Yes")) {
                login = doLogin(s);
                password = createPassword(s, login);
                addEmail(s);
            } else {
                isDone = true;
            }


        }
    }
}
