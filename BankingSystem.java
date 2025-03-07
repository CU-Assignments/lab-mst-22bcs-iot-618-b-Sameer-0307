import java.util.Scanner;

class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current Balance: " + balance);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Error: Insufficient funds. Current Balance: " + balance);
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful! Current Balance: " + balance);
        } else {
            System.out.println("Error: Withdrawal amount must be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an account
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, accountNumber, initialBalance);

        while (true) {
            System.out.println("\nChoose an option: 1-Deposit 2-Withdraw 3-Check Balance 4-Exit");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                System.out.print("Enter Deposit Amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
            } else if (choice == 2) {
                System.out.print("Enter Withdrawal Amount: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
            } else if (choice == 3) {
                System.out.println("Current Balance: " + account.getBalance());
            } else if (choice == 4) {
                System.out.println("Exiting... Thank you for banking with us!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
