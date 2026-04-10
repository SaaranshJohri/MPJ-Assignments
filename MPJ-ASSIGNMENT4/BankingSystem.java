import java.io.*;
import java.util.Scanner;

class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCIDException extends Exception {
    public InvalidCIDException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file = "bank.txt";
        int choice;

        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. Display Records");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Customer ID (1-20): ");
                        int cid = sc.nextInt();
                        sc.nextLine();

                        if (cid < 1 || cid > 20)
                            throw new InvalidCIDException("CID must be between 1 and 20");

                        System.out.print("Enter Name: ");
                        String cname = sc.nextLine();

                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble();

                        if (amount <= 0)
                            throw new ArithmeticException("Amount must be positive");

                        if (amount < 1000)
                            throw new MinimumBalanceException("Minimum balance must be Rs.1000");

                        FileWriter fw = new FileWriter(file, true);
                        fw.write(cid + "," + cname + "," + amount + "\n");
                        fw.close();

                        System.out.println("Account created successfully");

                    } catch (InvalidCIDException | MinimumBalanceException | ArithmeticException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        System.out.println("File error");
                    }
                    break;

                case 2:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;

                        System.out.println("\nCustomer Records:");
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (IOException e) {
                        System.out.println("Error reading file");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter withdrawal amount: ");
                        double wth_amt = sc.nextDouble();

                        if (wth_amt <= 0)
                            throw new ArithmeticException("Amount must be positive");

                        System.out.print("Enter current balance: ");
                        double balance = sc.nextDouble();

                        if (wth_amt > balance)
                            throw new InsufficientBalanceException("Insufficient balance");

                        balance -= wth_amt;
                        System.out.println("Remaining balance: " + balance);

                    } catch (InsufficientBalanceException | ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}