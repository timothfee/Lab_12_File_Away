import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        String choice;

        do {
            String firstName = SafeInput.getNonEmptyString(in, "Enter First Name");
            String lastName = SafeInput.getNonEmptyString(in, "Enter Last Name");
            String id = String.format("%06d", SafeInput.getRangedInt(in, "Enter ID Number (6 digits)", 0, 999999));
            String email = SafeInput.getNonEmptyString(in, "Enter Email");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2024);

            records.add(String.join(", ", firstName, lastName, id, email, String.valueOf(yearOfBirth)));

        } while (SafeInput.getYNConfirm(in, "Add another record?"));

        String fileName = SafeInput.getNonEmptyString(in, "Enter filename to save (with .csv extension)");

        try (PrintWriter writer = new PrintWriter(new File("./src/" + fileName))) {
            for (String record : records) {
                writer.println(record);
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving the file: " + e.getMessage());
        }
    }
}
