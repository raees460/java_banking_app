import java.util.Scanner;

class Account {
    String accNo;
    String name;
    double balance;

    public Account(String accNo, String name) {
        this.accNo = accNo;
        this.name = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class Bank {
    static Account account = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    if (account != null) account.displayBalance();
                    else System.out.println("No account found.");
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        account.deposit(amt);
                    } else {
                        System.out.println("No account found.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        account.withdraw(amt);
                    } else {
                        System.out.println("No account found.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our banking system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }

    public static void createAccount(Scanner sc) {
        sc.nextLine(); // clear input buffer
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        account = new Account(accNo, name);
        System.out.println("Account created successfully.");
    }
}

