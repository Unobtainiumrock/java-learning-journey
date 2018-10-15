import java.util.Scanner;

/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
    9/17/2018
    
    What it does
    ------------
    This is a short program for a simple calculator. It takes two numbers and an operand provided by a user
    and computes the result of that expression.
    
    What it utilizes
    ----------------
    This utilizes java.util.Scanner class to gather the user's inputs via CLI. It also uses a switch statement.
    I'm not sure where I needed to use .equals on this exercise? I believe the CASE part of the
    switch statement does the .equals check for me underneath the hood.
    
*/

public class Calculator {

  static double numOne;
  static double numTwo;
  static String operand;
  static double result;
  static boolean badInput;
  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    getExpression();
    calculateExpression();
    if (!badInput) {
      printAnswer();
    }
  }

  public static void getExpression() {
    System.out.print("Provide a number: ");
    numOne = input.nextDouble();
    System.out.print("Please provide an operator [+, - , / , x]: ");
    operand = input.next();
    System.out.print("Please provide another number: ");
    numTwo = input.nextDouble();
  }

  public static void calculateExpression() {
    switch (operand) {
    case "+":
      result = numOne + numTwo;
      break;
    case "-":
      result = numOne - numTwo;
      break;
    case "x":
      result = numOne * numTwo;
      break;
    case "/":
      result = numOne / numTwo;
      break;
    default:
      System.out.println("Invalid expression");
      badInput = true;
    }
  }

  public static void printAnswer() {
    System.out.println(numOne + " " + operand + " " + numTwo + " equals: " + result);
  }

}

// Sample screen output
/*
  Provide a number: 10
  Please provide an operator [+, - , / , x]: /
  Please provide another number: 2
  10.0 / 2.0 equals: 5.0
 */
