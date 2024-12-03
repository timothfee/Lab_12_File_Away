import javax.swing.*;
import java.io.*;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser("./src");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("Processing file: " + file.getName());
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }

            System.out.println("\nSummary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } else {
            System.out.println("No file selected.");
        }
    }
}

