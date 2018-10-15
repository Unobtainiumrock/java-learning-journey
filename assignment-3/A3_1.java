/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
    9/10/2018
    
    What it does
    ------------
    The user can either log in to a preexisting bank account to make withdrawls, deposits, or print
    their information. If they don't already have an account, they can create one. This is accomplished
    by creating an account instance and storing it on the AccountsList class' private ArrayList. You can
    create multiple random accounts and verify that each one contains unique data by logging into them.
    Or you can just log in to the two I've hard-coded and modify their values and log into another.
    
    What it utilizes
    ----------------
    This program utilizes a Bank class, an AccountsList class with ArrayList datastructure,
    and an Account class. This program's Account class makes use of private variables for 
    user's account information such as account balance, first/last name, username, and password.
    The ArrayList data structure is used for storing a collection of Account objects. It has a search
    method. It's worth noting that this isn't efficient search, since we could use something like a
    hash for key lookups and keys based on the user's username. I've provided some mock accounts
    for seeing how the program behaves if you were to try and access a preexisting account.  
    This has a silly way of persisting data by keeping the program running until the user fully exits.
    Normally we'd have their info store in a databse for querying though.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	
  // private here, and private on the AccountList class' ArrayList
  private static AccountsList bankAccounts = new AccountsList();

  public static void main(String[] args) {
    String userResponse;
    String username;
    String password;
    int choice = 0;

    

    // Mock data hard coded, since no DB.
    // Test data. note: (No persistence of data without database)
    // ==========================================================================
     Account acctOne = new Account();
     acctOne.setName("nicholas", "fleischhauer");
     acctOne.setLoginInfo("unobtainiumrock", "123");

     Account acctTwo = new Account();
     acctTwo.setName("Rick", "James");
     acctTwo.setLoginInfo("aether", "fortitude");

     bankAccounts.addAccount(acctOne);
     bankAccounts.addAccount(acctTwo);
    // =====================================================================================
    Scanner input = new Scanner(System.in);

    // note: (No persistence of data without database)
    System.out.println("==========================================");
    System.out.println("Welcome to the Bank of steal your money!||");
    System.out.println("==========================================");
    System.out.print("Do you have an account (Y/N)? [Quit with Q]: ");
    userResponse = input.next().toUpperCase();
    if (userResponse.equals("Y")) {
      System.out.print("Please provide your username: ");
      username = input.next();

      System.out.print("Please provide your password: ");
      password = input.next();

      Account match = bankAccounts.findAccount(username);
      if (match != null) {
        match.login(password);
        if (match.loggedIn) {
          while (match.loggedIn) {
            choice = presentOptions(input);
            match.executeChoice(choice, input);
          }
        } else {
          System.out.println("The password you provided is incorrect.");
        }
      }
      main(args);
    } else if (userResponse.equals("N")) {
      System.out.print("Would you like to create an account? (Y/N): ");
      userResponse = input.next().toUpperCase();

      if (userResponse.equals("Y")) {
        Account account = createAccount(input);
        bankAccounts.addAccount(account);
        System.out.println("You've succesfully created an account and are now logged in.");

        while (account.loggedIn) {
          choice = presentOptions(input);
          account.executeChoice(choice, input);
        }

      }
    } else {
    	System.out.println("Please visit us again.");
    	input.close();
    	return;
    }
    main(args);
  }

  public static Account createAccount(Scanner input) {
    String firstName;
    String lastName;
    String username;
    String password;

    Account account = new Account();

    System.out.print("Please provide your first name: ");
    firstName = input.next();
    System.out.print("Please provide your last name: ");
    lastName = input.next();
    System.out.print("Please provide a username: ");
    username = input.next();
    System.out.print("Please provide a password: ");
    password = input.next();

    account.setName(firstName, lastName);
    account.setLoginInfo(username, password);
    account.login(password);

    return account;
  }

  public static int presentOptions(Scanner input) {
    int choice;
    System.out.println("Please enter a number for your choice: ");
    System.out.println("[1] Make a depost.");
    System.out.println("[2] Make a withdrawal.");
    System.out.println("[3] Account overview.");
    System.out.println("[4] Logout.");
    choice = input.nextInt();
    return choice;
  }

}

class AccountsList {
  private List<Account> accounts = new ArrayList<>();

  public void addAccount(Account newAccount) {
    this.accounts.add(newAccount);
  }

  public Account findAccount(String username) {
    for (Account account : accounts) {
      if (account.getUserName().equals(username)) {
        return account;
      }
    }
    System.out.println("That username does not exist");
    return null;
  }
}

class Account {
  private double balance = 0;
  private String firstName;
  private String lastName;

  private String username;
  private String password;
  public boolean loggedIn;

  public void login(String password) {
    this.loggedIn = this.password.equals(password);
  }

  public void logout() {
    this.loggedIn = false;
    System.out.println("Goodbye!");
    System.out.println(" ");
  }

  public void setName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setLoginInfo(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUserName() {
    return this.username;
  }

  public void makeDeposit(Scanner input) {
    double amount;
    System.out.print("Provide an amount as $xx.xx to deposit: ");
    amount = Math.abs(input.nextDouble());
    this.balance += amount;
    this.printAllInfo();
  }

  public void makeWithdrawal(Scanner input) {
    double amount;
    System.out.print("Provide an amount as $xx.xx to withdraw: ");
    amount = Math.abs(input.nextDouble());
    if (this.balance - amount >= 0) {
      this.balance -= amount;
    } else {
      System.out.println("Your balance is too low");
    }
    this.printAllInfo();
  }

  public void printAllInfo() {
    System.out.println("-----------------------------------");
    System.out.println(this.firstName + " " + this.lastName);
    System.out.println("Current Balance: " + this.balance);
    System.out.println("-----------------------------------");
  }

  public void executeChoice(int choice, Scanner input) {
    switch (choice) {
    case 1:
      this.makeDeposit(input);
      break;
    case 2:
      this.makeWithdrawal(input);
      break;
    case 3:
      this.printAllInfo();
      break;
    case 4:
      this.logout();
      break;
    default:
      this.logout();
    }
  }
}

/*
==========================================
Welcome to the Bank of steal your money!||
==========================================
Do you have an account (Y/N)? [Quit with Q]: n <------------- User says they don't have an account.
Would you like to create an account? (Y/N): y  <------------- User creates an account.
Please provide your first name: John
Please provide your last name: Smith
Please provide a username: clancyghost
Please provide a password: 1234
You've succesfully created an account and are now logged in.
Please enter a number for your choice: 
[1] Make a depost.
[2] Make a withdrawal.
[3] Account overview.
[4] Logout.
                                          <------------- User chooses 1 (deposit)
Provide an amount as $xx.xx to deposit: 10
-----------------------------------
John Smith
Current Balance: 10.0
-----------------------------------
Please enter a number for your choice: 
[1] Make a depost.
[2] Make a withdrawal.
[3] Account overview.
[4] Logout.
1                                          <------------- User chooses 1 (deposit)
Provide an amount as $xx.xx to deposit: 14
-----------------------------------
John Smith
Current Balance: 24.0
-----------------------------------
Please enter a number for your choice: 
[1] Make a depost.
[2] Make a withdrawal.
[3] Account overview.
[4] Logout.
4                                          <------------- User chooses 4 (logout)
Goodbye!
==========================================
Welcome to the Bank of steal your money!||
==========================================
Do you have an account (Y/N)? [Quit with Q]: y  <--------- User says that they have an account.
Please provide your username: clancyghost
Please provide your password: 1234

Please enter a number for your choice: 
[1] Make a depost.
[2] Make a withdrawal.
[3] Account overview.
[4] Logout.
3                                          <------------- User chooses 3 (account overview)
-----------------------------------
John Smith
Current Balance: 24.0
-----------------------------------
Please enter a number for your choice: 
[1] Make a depost.
[2] Make a withdrawal.
[3] Account overview.
[4] Logout.
2                                          <------------- User chooses 2 (withdrawal)
Provide an amount as $xx.xx to withdraw: 20
-----------------------------------
John Smith
Current Balance: 4.0
-----------------------------------
Please enter a number for your choice: 
[1] Make a depost.
[2] Make a withdrawal.
[3] Account overview.
[4] Logout.
2                                          <------------- User chooses 2 (withdrawal)
Provide an amount as $xx.xx to withdraw: 100
Your balance is too low                    <------------- Balance is too low, so no withdrawal.        
-----------------------------------
John Smith
Current Balance: 4.0
-----------------------------------
Please enter a number for your choice: 
[1] Make a depost.
[2] Make a withdrawal.
[3] Account overview.
[4] Logout.
4
Goodbye!
*/
