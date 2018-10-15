
/*
  Nicholas Fleischhauer
  CIS 254
  Assignment 6.2
  September, 30 2018
  Instructor: Dave Harden
  
  This program takes an integer greater than 0 and calculates the sum of the squares of the number
  from 1 to that integer. This program should repeat this process until the user wants to quit.
  An input value less than or equal to 0 signals the end of the data.

*/

import java.util.Scanner;

class A6_2 {
  public static void main(String[] args) {

    int total = 0;
    int numberEntered;

    Scanner input = new Scanner(System.in);

    do {
      System.out.print("Enter a whole number greater than 0 (less than 1 to quit): ");
      numberEntered = input.nextInt();
      for (int i = 1; i < numberEntered + 1; i++) {
        total += (i * i);
      }

      if (total > 0) {
        System.out.println("The sum of the squares from 1 " + "to " + numberEntered + " is " + total);
      }

      total = 0;

    } while (numberEntered > 0);
    input.close();
  }
}

/*
  Sample screen output:
 
   Enter a number greater than 0 (less than 1 to quit): 4 The sum of the squares
   from 1 to 4 is 30 Enter a number greater than 0 (less than 1 to quit): 1 The
   sum of the squares from 1 to 1 is 1 Enter a number greater than 0 (less than
   1 to quit): 0
 */