import java.io.*;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        String file = "assignment.txt";
        do {
            System.out.println("1. Write");
            System.out.println("2. Read");
            System.out.println("3. Append");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    try {
                        FileWriter filew = new FileWriter(file);
                        System.out.print("Enter text: ");
                        String data = sc.nextLine();
                        filew.write(data);
                        filew.close();
                        System.out.println("Data written");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        System.out.println("Write completed.");
                    }
                    break;
                case 2:
                    try {
                        FileReader filer = new FileReader(file);
                        BufferedReader bufferr = new BufferedReader(filer);
                        String line;
                        System.out.println("\nFile Content:");
                        while ((line = bufferr.readLine()) != null) {
                            System.out.println(line);
                        }
                        bufferr.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Not found");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        System.out.println("Read complete.");
                    }
                    break;
                case 3:
                    try {
                        FileWriter filew = new FileWriter(file, true); 
                        System.out.print("Text: ");
                        String dataline = sc.nextLine();
                        filew.write("\n" + dataline);
                        filew.close();
                        System.out.println("Data appended.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        System.out.println("Appended.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid!");
            }
        } while (ch != 4);
        sc.close();
    }
}