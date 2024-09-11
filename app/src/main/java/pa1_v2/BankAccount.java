package pa1_v2;

/** 
 *  BankAccount class represents a bank account with basic operations.
 */
public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private float interestRate;

    /**
     * Constructor to initialize the BankAccount with account holder, account number, and interest rate.
     * The balance is initially set to 0.
     * @param accountHolder The name of the account holder.
     * @param accountNumber A unique identifier for the account.
     * @param interestRate The annual interest rate for the account.
     */
    public BankAccount(String accountHolder, int accountNumber, float interestRate) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.interestRate = interestRate;
    }

    /**
     * Get the current balance of the account.
     * @return The balance rounded to the nearest integer.
     */
    public double getBalance() {
        return Math.round(this.balance);
    }

    /**
     * Get the account holder's name.
     * @return The account holder's name.
     */
    public String getAccountHolder() {
        return this.accountHolder;
    }

    /**
     * Get the account number.
     * @return The account number.
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Deposit the specified amount to the account balance.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
    	if (amount > 0){
        this.balance += amount;
    	}
    }

    /**
     * Apply interest to the account balance based on the interest rate.
     */
    public void applyInterest() {
    	this.balance *= 1 + this.interestRate;
    }

    /**
     * Withdraw the specified amount from the account balance.
     * @param amount The amount to withdraw.
     */
    public void withdraw(double amount) {
    	if (this.balance >= amount && amount > 0){
    		this.balance -= amount;
    	}
    }
}
