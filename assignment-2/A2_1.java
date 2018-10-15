/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
  	9/05/2018
  	
  	This program utilizes the System.out.print() and System.out.println()
  	to print a line asking for an integer in cents.
  	java.util.Scanner detects the user's input and captures that information
    for use in our denomination conversion algorithm. Afterwards, it prints four
    lines. Each line represents an amount of a denominations maximum amount that
    can exist within the provided cents. It is calculated in a top down fashion,
    so we start with the largest denominations first.

    note: "You should submit two files, whose names will be determined by the names of the two classes."
    question: Should I name the class below as A2_1, or should I rename this file to ChangeConverter.java?
 */

import java.util.Scanner;

public class ChangeConverter {
	
	public static final int CENTS_PER_QUARTER = 25;
	public static final int CENTS_PER_DIME = 10;
	public static final int CENTS_PER_NICKEL = 5;
	public static final int CENTS_PER_PENNY = 1;
	
	public static void main(String[] args) {
		
		int currentCents = 0;
		int numQuarters = 0;
		int numDimes = 0;
		int numNickels = 0;
		int numPennies = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("cents entered: ");
		currentCents = input.nextInt();
		numQuarters = (currentCents  - (currentCents % CENTS_PER_QUARTER))/CENTS_PER_QUARTER;
		currentCents = currentCents % CENTS_PER_QUARTER;
		numDimes = (currentCents  - (currentCents % CENTS_PER_DIME))/CENTS_PER_DIME;
		currentCents = currentCents % CENTS_PER_DIME;
		numNickels = (currentCents  - (currentCents % CENTS_PER_NICKEL))/CENTS_PER_NICKEL;
		currentCents = currentCents % CENTS_PER_NICKEL;
		numPennies = currentCents;
		
		System.out.println("pennies: " + numPennies);
		System.out.println("nickels: " + numNickels);
		System.out.println("dimes: " + numDimes);
		System.out.println("quarters: " + numQuarters);
		
		input.close();
	}
	
}

/* 
  Enter an amount of cents to convert: 119
  pennies: 4
 	nickels: 1
 	dimes: 1
 	quarters: 4
 */
