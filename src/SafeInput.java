import java.util.Scanner;

public class SafeInput {
    public static String getNonEmptyString(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }
    public static int getInt(Scanner pipe, String prompt) {
        int result;
        while (true) {
            System.out.print(prompt + ": ");
            String input = pipe.nextLine();
            try {
                result = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return result;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result;
        while (true) {
            result = getInt(pipe, prompt + " (" + low + "-" + high + ")");
            if (result >= low && result <= high) {
                break;
            }
            System.out.println("Input must be between " + low + " and " + high + ".");
        }
        return result;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double result;
        while (true) {
            System.out.print(prompt + ": ");
            String input = pipe.nextLine();
            try {
                result = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return result;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double result;
        while (true) {
            result = getDouble(pipe, prompt + " (" + low + "-" + high + ")");
            if (result >= low && result <= high) {
                break;
            }
            System.out.println("Input must be between " + low + " and " + high + ".");
        }
        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (yes/no): ");
            input = pipe.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Invalid input. Please enter yes or no.");
        }
    }
}
