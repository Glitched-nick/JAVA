import java.util.Scanner;

class BankAccount {
    double balance;

    BankAccount(double startingBalance) {
        balance = startingBalance;
    }

    void checkBalance() {
        System.out.println("Your current balance is ₹" + balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " has been deposited.");
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " has been withdrawn.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(10000.0);

        System.out.println("==================================");
        System.out.println("        ATM INTERFACE SYSTEM      ");
        System.out.println("==================================");

        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("----------------------------------");
                    account.checkBalance();
                    System.out.println("----------------------------------");
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    System.out.println("----------------------------------");
                    account.deposit(depositAmount);
                    System.out.println("----------------------------------");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println("----------------------------------");
                    account.withdraw(withdrawAmount);
                    System.out.println("----------------------------------");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM Interface.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}
