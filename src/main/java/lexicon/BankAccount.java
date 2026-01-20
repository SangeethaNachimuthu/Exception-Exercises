package lexicon;

public class BankAccount {

    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        deposit(initialBalance);
    }

    public void deposit(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposit is successful. New balance is " + balance);
    }

    public void withdrawal(double amount) throws InsufficientBalanceException {

        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient fund for withdrawal. " +
                    "Available balance is " + balance);
        }

        balance -= amount;
        System.out.println("Withdrawal is successful. New balance is " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
