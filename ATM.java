import java.util.*;
public class ATM {

    private static final int MAX_WITHDRAWAL = 5000;
    private static final ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userId, pin;

        // User Login
        do{
            System.out.println("Enter User ID: ");
            userId = scanner.nextInt();
            System.out.println("Enter PIN: ");
            pin = scanner.nextInt();
             // ATM functionalities
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayTransactions();
                    break;
                case 2:
                    withdrawCash(scanner);
                    break;
                case 3:
                    depositCash(scanner);
                    break;
                case 4:
                    // Transfer functionality not implemented yet
                    System.out.println("Transfer functionality not available yet.");
                    break;
                case 5:
                    System.out.println("Exiting ATM...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    } while (!validateLogin(userId, pin));

        scanner.close();
    }

    private static boolean validateLogin(int userId, int pin) {
        // Replace with logic to validate against user data (e.g., database)
        return userId == 1234 && pin == 5678;
    }

    private static void displayMenu() {
        System.out.println("\nATM Menu");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Transfer Money (Not Implemented)");
        System.out.println("5. Quit");
        System.out.println("Enter your choice: ");
    }

    private static void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\nTransactions:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdrawCash(Scanner scanner) {
        int amount;
        System.out.println("Enter amount to withdraw (maximum " + MAX_WITHDRAWAL + "): ");
        amount = scanner.nextInt();

        if (amount > MAX_WITHDRAWAL) {
            System.out.println("Withdrawal amount exceeds limit.");
        } else {
            // Simulate withdrawal logic (replace with actual account management)
            System.out.println("Dispensing " + amount);
            transactions.add(new Transaction("Withdraw", amount));
        }
    }

    private static void depositCash(Scanner scanner) {
        int amount;
        System.out.println("Enter amount to deposit: ");
        amount = scanner.nextInt();

        // Simulate deposit logic (replace with actual account management)
        System.out.println("Deposited " + amount);
        transactions.add(new Transaction("Deposit", amount));
    }
}

class Transaction {
    private String type;
    private int amount;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": " + amount;
    }
}
