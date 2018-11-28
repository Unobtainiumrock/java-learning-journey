package com.unobtainumrock.wordcruncher;
/*
  Nicholas Fleischhauer
  CIS 254
  Assignment 7.2
  November, 25 2018
  Instructor: Dave Harden

  #Prompt
  Write a class named WordCruncherTest that has only a main method that:
  
    * asks the user for a word with the option to enter the word "quit" to quit

    * creates a WordCruncher object that contains this word (unless the word is "quit") and then:
      * outputs the number of letters in this object
      * outputs the number of vowels in this object
      * output the object string in reverse
      * outputs the pig latin translation of the string stored in the object
      * outputs the gibberish translation of the string stored in the object
      * asks the user to enter one letter, and returns a message indicating how many occurrences of
        that letter are in the word.
  
  The program should continue to do this until the user enters the word "quit"

  ##Getting Started
  This file provides a way to interact with the code residing within `WordCruncher.java`. The files are linked via
  a package named `com.unobtainumrock.wordcruncher`. Make sure when you interact with this code that you have `package com.unobtainumrock.wordcruncher;` at the top 
  of this file & the WordCruncher.java file, as well as a package named `com.unobtainumrock.wordcruncher;` housing both the `MyMath.java` and `MyMathTest.java` files.

  ### Sources
  https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#compile(java.lang.String)
  https://www.regular-expressions.info/unicode.html#prop
*/

import java.util.Scanner;

public class WordCruncherTest {

	private static Scanner input = new Scanner(System.in);

  /* This main method kicks off the application. Either the user chooses to quit,
   * or the user chooses to enter a word. The main method calls two other methods if
   * they choose to enter a word.
   *
   * note: this main method is recursively called so that we can test entering multiple words.
   */
	public static void main(String[] args) {
		String userChoice;
		WordCruncher cruncherInstance;

		System.out.print("Please enter a word [Enter 'quit' to quit]: ");
		userChoice = input.next();

		if (userChoice.toLowerCase().equals("quit")) {
			System.out.println("Goodbye!");
		} else {
			cruncherInstance = new com.unobtainumrock.wordcruncher.WordCruncher(userChoice);
			printAllInstanceMethods(cruncherInstance);
			numberOfOccurrences(cruncherInstance);
		}
  }
  



  
  // This method simply prints all of the outputs from each instance method being called.
	public static void printAllInstanceMethods(WordCruncher cruncherInstance) {
		System.out.println(cruncherInstance.toString());
		System.out.println("Number of letters: " + " " + cruncherInstance.numLetters());
		System.out.println("Number of Vowels: " + " " + cruncherInstance.numVowels());
		System.out.println("Begins with a vowel: " + " " + cruncherInstance.beginsWithVowel());
		System.out.println("Pig Latin version: " + cruncherInstance.toPigLatin());
		System.out.println("Gibberish version: " + cruncherInstance.toGibberish());
		System.out.println("Reversed version: " + cruncherInstance.reverse());
	}





  /* This method is used as a way for a user to check how many times a character occurs
   * in an instance's "String word" variable. We convert it to char before passing it into the 
   * word cruncher instance's numberOfOccurrences method. This also handles for when a user
   * inputs more than a single character.
   */
	public static void numberOfOccurrences(WordCruncher cruncherInstance) {
		String userChoice;
		char ch;

		System.out.print("Please enter a single character to find out out many times it occurs: ");
    userChoice = input.next();
    
    if (userChoice.toLowerCase().equals("quit")) {
			System.out.println("Goodbye!");
		}

		if (userChoice.length() > 1) {
			System.out.println("You entered more than a single character. Please try again with a single character");
			numberOfOccurrences(cruncherInstance);
		} else {
			ch = userChoice.charAt(0);
			System.out.println("Number of character occurrences: " + cruncherInstance.numCharOccurrences(ch));
			System.out.print("Would you like to check another character's number of occurrences? [Y/N]: ");
			userChoice = input.next();

			if (userChoice.toUpperCase().equals("Y")) {
				numberOfOccurrences(cruncherInstance);
			} else {
				main(null); // Recursive call
			}
    }
	}
}
