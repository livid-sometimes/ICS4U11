package Unit2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Glen_James_UserInfoSystem {


    public static boolean validateBirth(int birthDate) {

        // first check: if it is an int with a length of 8 //

        String strBirthDate = String.valueOf(birthDate);

        if (strBirthDate.length() != 8) {return false;}

        // second check: see if the first two nums are in the range of 1 - 12 //
        String monthStr = strBirthDate.substring(0, 2);
        String daysStr = strBirthDate.substring(2, 4);
        String yearStr = strBirthDate.substring(4, 8);

        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(daysStr);
        int year = Integer.parseInt(yearStr);

        boolean isLeapYear = false;

        // as of making this the max year is 2026
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

        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
            System.out.println("failed 1");// thirty day months
            return false;
        } else if ((month == 2 && day == 29) && !isLeapYear) {
            System.out.println("failed 2");// leap years
            return false;
        } else if ((day < 1 || day > 28) && (month == 2)) {
            System.out.println("failed 3"); // feb check
            return false;
        } else if ((day < 1 || day > 31)) {
            System.out.println("failed 4");
            return false;
        }


        return true;
    }

    public static void main(String[] args) {

        // important variables //
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


        // Strings variables //
        String firstName = "";
        String middleName = "";
        String lastName = "";

        int birthDate = 0; // will be using (MMDDYYYY)
        boolean isValidBirth = false;

//        System.out.println("What is your first name?");
//        firstName = s.nextLine();
//
//        System.out.println("What is your middle name?");
//        middleName = s.nextLine();
//
//        System.out.println("What is your last name?");
//        lastName = s.nextLine();

        // try until we get a valid birthday //
        while (!isValidBirth) {

            try {
                System.out.println("What is your birth date? (use MMDDYYYY)");
                System.out.println("months less than October will be shown with a zero at the start, e.x. \"01\"");
                birthDate = s.nextInt();
                System.out.println(birthDate);

                isValidBirth = validateBirth(birthDate);
            } catch (InputMismatchException e) {
                System.out.println("Birth date given was not an integer, try again.");
                s.nextLine();
            }
        }





    }
}
