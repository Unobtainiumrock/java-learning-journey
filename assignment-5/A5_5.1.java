import java.util.Scanner;

/*
 	A2_1.java
 	Nicholas Fleischhauer
    CIS 254
    Question Loop
    9/18/2018
    
    What it does (One way to exit application -- N)
    ------------
    This is a program which converts pounds into ounces. I used doubles to account
    for a person providing non-whole number pounds. I use recursion to keep a user in the
    application flow until they provide a proper Y/N. I use a while loop/quesition loop that
    will keep running the application until a user decides to quit with "N". Additionally,
    the loop will only perform a conversion if a positive value is provided, otherwise it will
    keep looping.

    What it utilizes
    ----------------
    - java.util.Scanner class to gather the user's inputs.
    - while loop (for core app flow / assuring positive values are provided)
    - recurison (for getting a valid Y/N from user)
*/

public class WeighConverter {

  public static String menuChoice;
  public static double pounds;
  public static double ounces;

  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    menuChoice = yesNoOther();

    switch (menuChoice) {
    case "Y":
      runProgram();
      break;
    case "N":
      System.out.println("Goodbye");
      break;
    default:
      System.out.println("Please provide Y or N");
      main(args);
    }
  }

  public static void runProgram() {
    // Here's the "question loop". It stops by using a break statement, because I <3 break statements.
    // I opted for this over:
    // - Using a variable outside the loop
    // - reassigning a variable withing the loop upon a user choosing no
    // - having the conditional check based upon the variable within the while statement.
    // - using switch/case instead of if/else.
    while (true) {
      System.out.print("Enter a number of pounds: ");
      pounds = input.nextDouble();

      if (pounds > 0) {
        ounces = poundsToOunces(pounds);
        printAnswer();

        menuChoice = yesNoOther();

        if (menuChoice.equals("Y")) {
          continue;
        } else if (menuChoice.equals("N")) {
          break;
        }
      } else {
        System.out.println("Please provide a number in pounds greater than 0");
      }
    }
    System.out.println("Goodbye!");
  }

  // This is used as a way to have a stopping point where the program will keep
  // prompting the user until a valid input is provided.
  public static String yesNoOther() {
    System.out.print("Would you like to convert pounds to ounces? [Y/N]: ");
    menuChoice = input.next().toUpperCase();
    switch (menuChoice) {
    case "Y":
      break;
    case "N":
      break;
    default:
      System.out.println("Please provide Y or N.");
      yesNoOther();
    }
    return menuChoice;
  }

  public static double poundsToOunces(double pounds) {
    return pounds * 16;
  }

  public static void printAnswer() {
    System.out.println(pounds + " lb is " + ounces + " oz.");
  }

}

/*
  EXAMPLE 1
  ---------
  Would you like to convert pounds to ounces? [Y/N]: 1
  Please provide Y or N.

  Would you like to convert pounds to ounces? [Y/N]: y
  Enter a number of pounds: 2
  2.0 lb is 32.0 oz.

  Would you like to convert pounds to ounces? [Y/N]: 1
  Please provide Y or N.

  Would you like to convert pounds to ounces? [Y/N]: y
  Enter a number of pounds: 3
  3.0 lb is 48.0 oz.

  Would you like to convert pounds to ounces? [Y/N]: n
  Goodbye!
*/

/* 
  EXAMPLE 2 (Doesn't want to engage application at all)
  -----------------------------------------------------
  Would you like to convert pounds to ounces? [Y/N]: n
  Goodbye
*/
