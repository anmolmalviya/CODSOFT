import java.util.Scanner;

// Class representing the bank account
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }

    // Method to check the account balance
    public double getBalance() {
        return balance;
    }
}

// Class representing the ATM
class ATM {
    private BankAccount account;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle user's choice
    public void processTransaction(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1: // Withdraw money
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;

            case 2: // Deposit money
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;

            case 3: // Check balance
                System.out.println("Current balance: $" + account.getBalance());
                break;

            case 4: // Exit
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

public class task3 {
    public static void main(String[] args) {
        // Initializing a user's bank account with a starting balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Creating an ATM instance connected to the user's bank account
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        int choice;

        // ATM menu loop
        do {
            atm.displayMenu(); // Display the ATM menu
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Get the user's choice
            atm.processTransaction(choice); // Process the user's transaction
        } while (choice != 4); // Exit the loop when the user chooses to exit
    }
}
