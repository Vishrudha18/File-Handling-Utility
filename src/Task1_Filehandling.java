import java.io.*;
import java.util.Scanner;

public class Task1_Filehandling {

    static String fileName = "sample.txt";
    static Scanner sc = new Scanner(System.in);

    // Write to file (User Input)
    static void writeFile() {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter text to write into file: ");
            sc.nextLine(); // clear buffer
            String content = sc.nextLine();

            bw.write(content);
            bw.close();

            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error while writing file.");
        }
    }

    // Read from file
    static void readFile() {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n📄 File Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("❌ Error while reading file.");
        }
    }

    // Modify file (Append user input)
    static void modifyFile() {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter text to append to file: ");
            sc.nextLine(); // clear buffer
            String content = sc.nextLine();

            bw.newLine();
            bw.write(content);
            bw.close();

            System.out.println("✅ File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error while modifying file.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n----- FILE HANDLING UTILITY -----");
            System.out.println("1. Write File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    writeFile();
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile();
                    break;
                case 4:
                    System.out.println("🚪 Exiting Program");
                    break;
                default:
                    System.out.println("❌ Invalid choice");
            }
        } while (choice != 4);

        sc.close();
    }
}
