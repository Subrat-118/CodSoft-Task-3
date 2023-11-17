import java.util.*;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount for withdrawal.");
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("-------------------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner sc = new Scanner(System.in);
        double amount;

        switch (option) {
            case 1:
                System.out.println("Your balance is: $" + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter the deposit amount: $");
                amount = sc.nextDouble();
                userAccount.deposit(amount);
                break;
            case 3:
                System.out.print("Enter the withdrawal amount: $");
                amount = sc.nextDouble();
                userAccount.withdraw(amount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize the user's account with a balance of $1000
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Please select an option: ");
            int option = sc.nextInt();
            atm.processOption(option);
        }
    }
}