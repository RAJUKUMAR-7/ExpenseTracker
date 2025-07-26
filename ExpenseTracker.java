// File: ExpenseTracker.java

import java.util.*;

class Transaction {
    String type;
    double amount;
    String description;

    Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return type + " | Rs." + amount + " | " + description;
    }
}

public class ExpenseTracker {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Transaction> transactions = new ArrayList<>();
    private static double balance = 0;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addIncome();
                case 2 -> addExpense();
                case 3 -> viewTransactions();
                case 4 -> System.out.println("\nCurrent Balance: Rs." + balance);
                case 5 -> System.out.println("Thank you for using Expense Tracker!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private static void addIncome() {
        System.out.print("Enter income amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        balance += amount;
        transactions.add(new Transaction("Income", amount, desc));
        System.out.println("Income added successfully!");
    }

    private static void addExpense() {
        System.out.print("Enter expense amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        balance -= amount;
        transactions.add(new Transaction("Expense", amount, desc));
        System.out.println("Expense added successfully!");
    }

    private static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("\nNo transactions available.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
