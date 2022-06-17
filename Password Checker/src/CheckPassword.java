import java.util.Scanner;

/**
 * The program checks whether or not the user entered password satisfies the
 * following conditions: 1. At least 8 characters long and 2. Must use at least
 * 3 of the following 4 types of characters - upper case letters (e.g., A, B,
 * C,...) - lower case letter (e.g., a, b, c, ...) - digits (e.g., 1, 2, 3, ...)
 * - special characters (e.g., !, @, $, %, ...)
 *
 * @author Victor Ruan
 *
 */
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * @EIGHT final value for 8
     */

    private static final int EIGHT = 8;

    /**
     * Checks if the length condition is met
     *
     * @param s
     *            parameter for the string
     *
     */
    private static boolean checkPassword(String s) {

        boolean status = false;

        int lengthOfString = s.length();
        if (lengthOfString >= EIGHT) {
            System.out.println("Password has fullfilled length requirement.");
            status = true;

        } else {
            System.out.println("Password is not long enough!");
        }

        return status;
    }

    /**
     *
     *
     * @param s
     * @return isUPPER
     */

    private static boolean containsUpperCaseLetter(String s) {

        boolean isUPPER = false;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                isUPPER = true;

            }

        }
        if (isUPPER) {
            System.out.print(
                    "Password has fullfilled capitilization requirement.");

        } else {
            System.out.print("Password needs at least one capitlization!");

        }

        return isUPPER;

    }

    /**
     *
     * @param s
     * @return isLower
     */

    private static boolean containsLowerCaseLetter(String s) {

        boolean isLower = false;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                isLower = true;
            }
        }
        if (isLower) {
            System.out.println(
                    "\n" + "Password has fullfilled lower case requirement.");

        } else {
            System.out
                    .println("\n" + "Password needs at least one lower case!");

        }

        return isLower;

    }

    /**
     *
     *
     *
     * @param s
     *            password
     * @return containsDigit
     */

    private static boolean isDigit(String s) {

        boolean containsDigit = false;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                containsDigit = true;
            }
        }
        if (containsDigit) {
            System.out.println("Password has fulfilled digit requirement.");

        } else {
            System.out.println("Password needs at least one digit!");

        }

        return containsDigit;

    }

    private static boolean containsSpecialChar(String s) {

        String specialChar = "!@#$%^&*_-+={}()[]:;,.?";

        boolean check = s.contains(specialChar);

        if (check == true) {
            System.out.println(
                    "Password has fullfilled special character requirement.");
        } else {
            System.out.println("Password needs at least 1 special character!");
        }

        return check;

    }

    /*
     *
     * Main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        System.out.print("Enter a password: ");
        String userPassword = in.nextLine();
        if (!checkPassword(userPassword)) {
            System.out.println("Invalid Password");
        } else {

            if (!containsUpperCaseLetter(userPassword)) {
                counter += 1;
            }
            if (!containsLowerCaseLetter(userPassword)) {
                counter += 1;
            }
            if (!isDigit(userPassword)) {
                counter += 1;
            }

            if (!containsSpecialChar(userPassword)) {
                counter += 1;
            }

            if (counter > 1) {
                System.out.println("Invalid Password!");
            } else {
                System.out.println("Valid Password.");
            }

        }

        in.close();

    }

}
