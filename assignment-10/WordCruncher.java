package com.unobtainumrock.wordcruncher;
/*
  Nicholas Fleischhauer
  CIS 254
  Assignment 7.2
  November, 24 2018
  Instructor: Dave Harden

  #Prompt
  Write the Java code for the class WordCruncher. Include the following members:

  **Default Constructor**
    Sets the instance variable 'word' to the string "default".

  **Parameterized constructor**
    Accepts one String object as a parameter and stores it
    in the instance variable. The String must consist only of letters: no whitespace,
    digits, or punctuation. If the String parameter does not consist only of letters, set the
    instance variable to "default" instead. (This restriction will make your work on some of the following 
    methods much easier.)

  **String toString()**
    Returns the instance variable.

  **int numLetters()**
   Returns the number of letters in the instance variable.

  **int numVowels()**
    Returns the number of vowels in the instance variable.

  **boolean beginsWithVowel()**
   Returns true if the first letter of the instance variable is a vowel, and false otherwise.

  **String toPigLatin()**
    Returns a String containing the 'pig latin' version of the instance variable.

  ```
  The rules for translating a word to pig latin are:
   1. If the word begins with a consonant, take the first letter of the word and move it to the end of the word,
      followed by 'ay'. 
   2. If the word begins with a vowel, add 'way' to the word. Hint: the method
      beginsWithVowel() makes this easier.
   3. For example, PIG LATIN IS FUN becomes IGPAY ATINLAY ISWAY UNFAY
      in pig latin. Note that despite the last example, our toPigLatin() method operates on words,
      not on complete sentences.
  ```

  **String toGibberish()**
    Returns a String containing the 'gibberish' version of the instance variable.

  ```
  The rules for translating a word into gibberish are:
    1. If the word begins with a consonant, follow the first letter with 'ithag'. So the word 'big' would
       translate to 'bithagig'.
    2. If the word begins with a vowel, place 'ithag' at the front. So the word 'is'
       becomes 'ithagis'.
  ```    
  **String reverse()**
  Returns a String that contains the characters of the instance variable, but in reverse.
  
  **int numCharOccurrences(char ch)**
    Returns a count of the number of times the parameter char ch occurs in the instance variable.
    A character that is a match except for the case (uppercase instead of lowercase or vice versa)
    should be counted as an occurrence.

  ###Sources
  https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#compile(java.lang.String)
  https://www.regular-expressions.info/unicode.html#prop
*/

import java.util.regex.*;

// Sources
// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#compile(java.lang.String)
// https://www.regular-expressions.info/unicode.html#prop

public class WordCruncher {
	String word;

	/*
	 * A parameterized constructor that accepts one String object as a parameter and
	 * stores it in the instance variable. The String must consist only of letters:
	 * no whitespace, digits, or punctuation. If the String parameter does not
	 * consist only of letters, set the instance variable to "default" instead.
	 */
	public WordCruncher(String word) {
		if (!this.invalidWord(word)) {
			this.word = word;
		} else {
			System.out.println("Non-letter characters aren't allowed. The string will be set to 'default' instead.");
			this.word = "default";
		}

	}

	// Constructor overloading for default values.
	public WordCruncher() {
		this("default");
	}






	// A method int numLetters() that returns the number of letters in the instance
	// variable.
	public int numLetters() {
		return this.word.length();
	}






	/*
	 * Returns the number of vowels in a string using a custom regex for vowels
	 * occurring one or more times. I just do a toLowerCase() within the body of the
	 * ltrAtIndex method.
	 */
	public int numVowels() {
		int occurrences = 0;

		Matcher m;
		Pattern p = Pattern.compile("(?:(a)|(e)|(i)|(o)|(u))+");

		for (int i = 0; i < this.word.length(); i++) {
			m = p.matcher(ltrAtIndex(i));

			if (m.matches()) {
				occurrences++;
			}
		}

		return occurrences;
  }
  





	/*
	 * This method checks if this class' instance variable begins with a vowel and
	 * returns a boolean to reflect that. note: We don't handle case sensitivity
	 * here in the regex. I just do a toLowerCase() within the body of the
	 * ltrAtIndex function.
	 */
	public boolean beginsWithVowel() {
		Pattern p = Pattern.compile("(?:(a)|(e)|(i)|(o)|(u))+");
		Matcher m = p.matcher(ltrAtIndex(0));

		return m.matches();
	}






	/*
	 * This method either slices off the first letter from this class' instance
	 * variable and concatenates it to a subString of the remaining characters (plus
	 * "ay").
	 * 
	 * Or it will concatenate this class' instance variable with "way". The former
	 * happens when it begins with a consonant and the latter happens when it begins
	 * with a vowel.
	 */
	public String toPigLatin() {
		String firstLtr, pigLatin;

		if (!(this.beginsWithVowel())) {
			firstLtr = ltrAtIndex(0);
			pigLatin = this.word.substring(1, this.word.length());
			return pigLatin + firstLtr + "ay";
		} else {
			return this.word + "way";
		}

	}






	/*
	 * This method returns a gibberish version of this class' instance variable. It
	 * follows the gibberish rules outlined in the prompt above.
	 */
	public String toGibberish() {
		String firstLtr, gibberish;

		if (this.beginsWithVowel()) {
			return "ithag" + this.word;
		} else {
			firstLtr = this.word.substring(0, 1);
			gibberish = this.word.substring(1, this.word.length());
			return firstLtr + "ithag" + gibberish;
		}
  }
  





	/*
	 * This method simply returns a reversed version of this class' instance
	 * variable. It does this by building a String while iterating backwards through
	 * the original String. I've alternated between using charAt and subString, but
	 * I think I prefer charAt.
	 */
	public String reverse() {
		String reversed = "";
		for (int i = this.word.length() - 1; i >= 0; i--) {
			reversed += this.word.charAt(i);
		}
		return reversed;
  }
  





	/*
	 * Returns a count of the number of times the parameter char ch occurs in the
	 * instance variable. A character that is a match except for the case (uppercase
	 * instead of lowercase or vice versa) should be counted as an occurrence.
	 */
	public int numCharOccurrences(char ch) {
		int occurrences = 0;
		for (int i = 0; i < this.word.length(); i++) {
			if (Character.toLowerCase(this.word.charAt(i)) == Character.toLowerCase(ch)) {
				occurrences++;
			}
		}
		return occurrences;
	}






	/*
	 * Uses a regex to match a single character belonging to the "letter" category.
	 * When combined with the .find() method, we can return true whenever a
	 * non-special character exists within the provided String, or false when it's
	 * all letters.
	 */
	public boolean invalidWord(String word) {
		Pattern p = Pattern.compile("\\p{L} ");
		Matcher m = p.matcher(word);
		boolean b = m.find();
		return b;
	}






	/*
	 * This method returns a lower-case version of a letter found at a specific
	 * index within a string.
	 */
	public String ltrAtIndex(int index) {
		// return Character.toString(this.word.charAt(index)).toLowerCase();
		return this.word.toLowerCase().substring(index, index + 1);
  }
  



  

	// A method String toString() that returns the instance variable.
	@Override
	public String toString() {
		return this.word;
	}
}

class Driver {
	public static void main(String... args) {
		WordCruncher cruncherInstance = new WordCruncher("IsdddddfdD");
		System.out.println(cruncherInstance.toString());
		System.out.println("Number of letters: " + " " + cruncherInstance.numLetters());
		System.out.println("Number of Vowels: " + " " + cruncherInstance.numVowels());
		System.out.println("Begins with a vowel: " + " " + cruncherInstance.beginsWithVowel());
		System.out.println("Pig Latin version: " + cruncherInstance.toPigLatin());
		System.out.println("Gibberish version: " + cruncherInstance.toGibberish());
		System.out.println("Reversed version: " + cruncherInstance.reverse());
		System.out.println("Number of character occurrences: " + cruncherInstance.numCharOccurrences('d'));
	}
}
