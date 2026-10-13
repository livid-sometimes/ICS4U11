package Unit2;

import java.util.Scanner;

public class Glen_James_UserInfoSystem {

    public static void createPassword(Scanner s) {
        String password = "";

        boolean hasCapital = false;
        boolean hasLowerCase = false;
        boolean hasNumbers = false;
        boolean hasSymbols = false;

        boolean isValidPassword = false;

        while(!isValidPassword) {
            System.out.println("CREATE A PASSWORD: ");
            password = s.nextLine();

            if (password.length() < 12) { return; }

            for (int i = 0; i < password.length(); i++) {

                if (Character.isLowerCase(password.charAt(i))) {
                    System.out.println("lower");
                    hasLowerCase = true;
                } else if (Character.isUpperCase(password.charAt(i))) {
                    System.out.println("cap");
                    hasCapital = true;
                } else if (Character.isDigit(password.charAt(i))) {
                    System.out.println("num");
                    hasNumbers = true;
                } else if (!(Character.isDigit(password.charAt(i)) && !(Character.isLetter(password.charAt(i))))) {
                    System.out.println("sumbol");
                    hasSymbols = true;
                }

                password = "";
            }

        }

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

        // try until we get a valid name //
        while (!isValidNames) {
            System.out.println("==> if your name has a space, make sure to have a hyphen! <==");

            System.out.println("What is your first name?");
            firstName = s.nextLine();

            names[0] = firstName;

            System.out.println("What is your middle name?");
            middleName = s.nextLine();

            names[1] = middleName;

            System.out.println("What is your last name?");
            lastName = s.nextLine();

            names[2] = lastName;

            for (int i = 0; i < names.length; i++) {
                isValidNames = validateName(names[i]);
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

        lastTwo = lastName.substring(lastName.length() - 2);
        firstThree = middleName.substring(0, 3);
        days = birthDate.substring(2, 4);

        reverseOrder = firstName.substring(0, 4);

        for (int i = reverseOrder.length(); i > reverseOrder.length() - 4; i--) {
            tempReverse += reverseOrder.charAt(i - 1);
        }

        reverseOrder = tempReverse;

        login = (lastTwo + firstThree + days + reverseOrder).toLowerCase();

        System.out.println("Your login is, " + login + ".");

        return login;
    }


    // VALIDATORS //

    public static boolean validateName(String name) {
        // NOTE: Mrs. Schembri said min name length is 3, so i'll do 3 for the min //
        if (name.length() < 3) { return false; }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
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
        if (birthDate.length() != 8) {return false;}

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

        if (month < 1 || month > 12) {return false;}

        // leap year check //

        // NOTE: the leap year rule is confusing me, I just had to follow how the calculators did it.
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            isLeapYear = true;
        }

        // max year check //
        if (maxYear < year) {return false;}

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

        Scanner s = new Scanner(System.in);

        System.out.println(
                "\u001B[38;2;0;255;255m▄▄▄█████▓▓█████  ▄████▄   ██░ ██     ██▓    ██▓     ▒█████   ██▒   █▓▓█████ \n" +
                        "\u001B[38;2;0;225;255m▓  ██▒ ▓▒▓█   ▀ ▒██▀ ▀█  ▓██░ ██▒   ▓██▒   ▓██▒    ▒██▒  ██▒▓██░   █▒▓█   ▀ \n" +
                        "\u001B[38;2;0;195;255m▒ ▓██░ ▒░▒███   ▒▓█    ▄ ▒██▀▀██░   ▒██▒   ▒██░    ▒██░  ██▒ ▓██  █▒░▒███   \n" +
                        "\u001B[38;2;0;165;255m░ ▓██▓ ░ ▒▓█  ▄ ▒▓▓▄ ▄██▒░▓█ ░██    ░██░   ▒██░    ▒██   ██░  ▒██ █░░▒▓█  ▄ \n" +
                        "\u001B[38;2;0;135;255m  ▒██▒ ░ ░▒████▒▒ ▓███▀ ░░▓█▒░██▓   ░██░   ░██████▒░ ████▓▒░   ▒▀█░  ░▒████▒\n" +
                        "\u001B[38;2;0;120;235m  ▒ ░░   ░░ ▒░ ░░ ░▒ ▒  ░ ▒ ░░▒░▒   ░▓     ░ ▒░▓  ░░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░\n" +
                        "\u001B[38;2;0;105;215m    ░     ░ ░  ░  ░  ▒    ▒ ░▒░ ░    ▒ ░   ░ ░ ▒  ░  ░ ▒ ▒░    ░ ░░   ░ ░  ░\n" +
                        "\u001B[38;2;0;90;195m  ░         ░   ░         ░  ░░ ░    ▒ ░     ░ ░   ░ ░ ░ ▒       ░░     ░   \n" +
                        "\u001B[38;2;0;75;175m            ░  ░░ ░       ░  ░  ░    ░         ░  ░    ░ ░        ░     ░  ░\n" +
                        "\u001B[38;2;0;60;155m                ░                                                ░          \u001B[0m"
        );


//        login = doLogin(s);
            createPassword(s);
    }
}
