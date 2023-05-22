/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptbankinher2;

/**
 *
 * @author Dell
 */
public class CurrentAccount implements Account{
    private int accountNumber;
    private String accountName;
    private int minimum;
    private double balance;
    private String accountType = "Current Account";

    public CurrentAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.minimum = 1000;
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
    
    public double getMinimum() {
        return this.minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
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
