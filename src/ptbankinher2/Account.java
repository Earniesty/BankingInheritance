/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ptbankinher2;

/**
 *
 * @author Dell
 */
public interface Account {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();
    public String getAccountType();
    public int getAccountNumber();
    public String getAccountName();
}