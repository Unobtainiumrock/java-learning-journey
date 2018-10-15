
/*
  Nicholas Fleischhauer
  CIS 254
  Assignment 6.1
  September, 30 2018
  Instructor: Dave Harden
  
  This program asks the user how many numbers will be entered and then has the user enter those
  numbers. When this is done, it will report to the user the positions of the first and last 7's
  entered.

   Note: Handle for edge case of no 7's being entered and a user saying 0 or less numbers will
   be entered.

*/

import java.util.Scanner;

public class A6_1 {
  public static void main(String[] args) {

    int amountOfNumbers;
    int firstSevenPosition = 0;
    int lastSevenPosition = 0;
    int numberEntered;

    java.util.Scanner input = new Scanner(System.in);

    System.out.print("How many numbers will be entered? ");
    amountOfNumbers = input.nextInt();

    if (amountOfNumbers > 0) {
      for (int i = 1; i < amountOfNumbers + 1; i++) {

        System.out.print("Enter num: ");
        numberEntered = input.nextInt();

        if (numberEntered == 7) {
          if (firstSevenPosition == 0) {
            firstSevenPosition = i;
          }
          lastSevenPosition = i;
        }
      }
    } 

    input.close();

    if (firstSevenPosition == 0) {
      System.out.println("Sorry, no 7's were entered.");
    } else {
      System.out.println("The first 7 was in position " + firstSevenPosition);
      System.out.println("The last 7 was in position " + lastSevenPosition);
    }

  }
}

/* 
  Sample screen output 1:

    How many numbers will be entered? 8    
    Enter num: 5
    Enter num: 7
    Enter num: 6
    Enter num: 7
    Enter num: 7
    Enter num: 3
    Enter num: 8
    Enter num: 6
    The first 7 was in position 2    
    The last 7 was in position 5
Sample screen output 2:

    How many numbers will be entered? 8    
    Enter num: 5
    Enter num: 2
    Enter num: 6
    Enter num: 7
    Enter num: 1
    Enter num: 3
    Enter num: 8
    Enter num: 6
    The first 7 was in position 4    
    The last 7 was in position 4
Sample screen output 3:

    How many numbers will be entered? 8    
    Enter num: 5
    Enter num: 1
    Enter num: 6
    Enter num: 5
    Enter num: 9
    Enter num: 3
    Enter num: 8
    Enter num: 6
    Sorry, no 7's were entered.
*/
