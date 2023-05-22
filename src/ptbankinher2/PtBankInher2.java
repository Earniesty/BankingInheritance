/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ptbankinher2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class PtBankInher2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank("New Bank");
        int option = 0, accountNumber;
        String accountName, accountType;
        Account account;
        double balance, amount;

        while (option != 6) {
            System.out.println("Main Menu");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");

            System.out.println("\n" + "Enter Your Choice: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    bank.listAccount();
                    break;
                case 2:
                    accountNumber = genNumber();
                    scan.nextLine();
                    System.out.println("Enter Type: ");
                    accountType = scan.nextLine();
                    System.out.println("Enter Your Name: ");
                    accountName = scan.nextLine();
                    System.out.println("Enter Balance: ");
                    balance = scan.nextDouble();

                    if (accountType.equals("Saving Account")) {
                        account = new SavingAccount(accountNumber, accountName, balance);
                        bank.openAccount(account);
                    } else if (accountType.equals("Current Account")) {
                        account = new CurrentAccount(accountNumber, accountName, balance);
                        bank.openAccount(account);
                        
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Type: ");
                    accountType = scan.nextLine();
                    account = bank.getAccount(accountNumber, accountType);
                    bank.closeAccount(account);
                    break;
                
                case 4:
                    System.out.println("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Type: ");
                    accountType = scan.nextLine();
                    System.out.println("Enter Amount: ");
                    amount = scan.nextDouble();
                    account = bank.getAccount(accountNumber, accountType);
                    bank.depositMoney(account, amount);
                    break;
                    
                case 5:
                    System.out.println("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Type: ");
                    accountType = scan.nextLine();
                    System.out.println("Enter Amount: ");
                    amount = scan.nextDouble();
                    account = bank.getAccount(accountNumber, accountType);
                    bank.withdrawMoney(account, amount);
                    break; 

            }
            
             System.out.println();   
        }

    }

    public static int genNumber() {
        Random rand = new Random();
        int accNumber = 100000 + rand.nextInt(900000);
        return accNumber;
    }
}
