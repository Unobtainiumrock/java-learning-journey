import java.util.scanner;

/*
 	A2_1.java
 	Nicholas Fleischhauer
    CIS 254
    Special Value Loop
    9/18/2018
    
    What it does (2 ways to exit the application -- N || -1)
    ------------
    This is a program which converts pounds into ounces. I used doubles to account
    for a person providing non-whole number pounds. I use recursion to keep a user in the
    application flow until they provide a proper Y/N. I use a while loop/special value
    loop that will keep running the application until a user decides to quit with "N"...
    OR provides a negative value for pounds.

    What it utilizes
    ----------------
    - java.util.Scanner class to gather the user's inputs.
    - while loop (for core app flow)
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

    System.out.print("Enter a number of pounds (quit with -1): ");
    pounds = input.nextDouble();

    // "special-value loop"
    while (pounds >= 0) {
      ounces = poundsToOunces(pounds);
      printAnswer();

      menuChoice = yesNoOther();

      if (menuChoice.equals("Y")) {
        System.out.println("Enter a number of pounds (quit with -1): ");
        pounds = input.nextDouble();
      } else if (menuChoice.equals("N")) {
        break; // or we can set pounds to -1
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
  Example 1
  ---------
  Would you like to convert pounds to ounces? [Y/N]: y
  Enter a number of pounds (quit with -1): 2
  2.0 lb is 32.0 oz.

  Would you like to convert pounds to ounces? [Y/N]: y
  Enter a number of pounds (quit with -1): -1
  Goodbye!

  Example 2
  ---------
  
*/
