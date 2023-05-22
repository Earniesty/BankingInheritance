/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptbankinher2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }
    
    public void listAccount() {
        Connection connection = BankingConnection.connect();
        String sql = "SELECT * FROM account";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            
            while (results.next()) {
                System.out.println(results.getString(1)+" "+results.getString(2)+" "+results.getString(3)+" "+results.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void openAccount(Account account) {
        Connection connection = BankingConnection.connect();
        String sql = "INSERT INTO account(accNumber,accName,accBalance,accType)"+" VALUES(?,?,?,?)";
        
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, account.getAccountNumber());
            prepareStatement.setString(2, account.getAccountName());
            prepareStatement.setDouble(3, account.getBalance());
            prepareStatement.setString(4, account.getAccountType());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeAccount(Account account) {
        Connection connection = BankingConnection.connect();
        String sql = "DELETE FROM account WHERE accNumber=?";
        
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, account.getAccountNumber());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void depositMoney (Account account, double amount) {
        account.deposit(amount);
        Connection connection = BankingConnection.connect();
        String sql = "UPDATE account SET accBalance=? WHERE accNumber=?";
        
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setDouble(1, account.getBalance());
            prepareStatement.setInt(2, account.getAccountNumber());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void withdrawMoney (Account account, double amount) {
        account.withdraw(amount);
        Connection connection = BankingConnection.connect();
        String sql = "UPDATE account SET accBalance=? WHERE accNumber=?";
        
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setDouble(1, account.getBalance());
            prepareStatement.setInt(2, account.getAccountNumber());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public Account getAccount(int accountNumber, String accountType) {
        Account account = null;
        Connection connection = BankingConnection.connect();
        String sql = "SELECT * FROM account WHERE accNumber=? AND accType=?";
        
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, accountNumber);
            prepareStatement.setString(2, accountType);
            ResultSet results = prepareStatement.executeQuery();
            results.next();
            String accountName = results.getString(2);
            Double balance = results.getDouble(3);
            
            if(accountType.equals("Saving Account")) {
                account = new SavingAccount(accountNumber, accountName,balance);
            }else if(accountType.equals("Current Account")) {
                account = new CurrentAccount(accountNumber, accountName, balance);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
}
