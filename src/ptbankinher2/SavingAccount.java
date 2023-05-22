/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptbankinher2;

/**
 *
 * @author Dell
 */
public class SavingAccount implements Account{
    private int accountNumber;
    private String accountName;
    private double balance;
    private String accountType = "Saving Account";

    public SavingAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    
    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }
    
    public int getNumber() {
        return this.accountNumber;
    }
    
    public String getName() {
        return this.accountName;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }
    
    @Override
    public String getAccountType() {
        return this.accountType;
    }
    
    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getAccountName() {
        return this.accountName;
    }
    
}
