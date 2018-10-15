/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
  	9/05/2018
  	
  	This program utilizes the System.out.print() and System.out.println()
  	to print a line asking for an integer of degrees in celsius.
  	java.util.Scanner detects the user's input and captures that information
    for use in our celsius to farenheit conversion algorithm. Afterwards, it prints a
    single line representing an the degrees celsius converted to degrees farenheit.

    note: "You should submit two files, whose names will be determined by the names of the two classes."
    question: Should I name the class below as A2_2, or should I rename this file to CelsiusToFarenheit.java?
*/

import java.util.Scanner;

public class CelsiusToFarenheit {

    public static void main(String[] args) {
      double celsius = 0;
    	double nine = 9;
    	double five = 5;
    	double fraction = nine/five;
      double constant = 32;
      
      Scanner input = new Scanner(System.in);
      System.out.print("Provide degrees in celsius: ");

    	double farenheit = (fraction * celsius) + constant;
      System.out.println(celsius + " degrees celsius is " + farenheit + " degrees farenheit.");
    }

}

/*
   Provide degrees in celsius: 30
   30.0 degrees celsius is 86.0 degrees farenheit. 
 */
