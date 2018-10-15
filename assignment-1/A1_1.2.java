// package statements;
// We import the Scanner class here so that we can use it for user inputs.
// Here's a link to the docs for the Scanner class.
// https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
import java.util.Scanner;
// We also import the InputMismatchException for handling bad inputs
// https://docs.oracle.com/javase/7/docs/api/java/util/InputMismatchException.html
import java.util.InputMismatchException;

/* Create a public class for prompting users to input statements 
 * which are subsequently printed. Find out if it is best practice to put all of the used class methods
 * below the main method, and if below, do we make mention of the main method using other methods.
 */
public class WeighConverter {
/*	This is the main method. Inside of it, we will call a series of other methods
 *	to tell a story of what is occurring.
 */ 
	public static void main(String[] args) {
		int input = gatherUserInput();
		int output = poundsToOunces(input);
		printAnswer(input,output);
	}	

/*
 * This method gathers user inputs. It has error handling in place to account for a user providing
 * improper inputs. Originally I had this just gather inputs & I had a separate method for 
 * validating the inputs. The validator was invoked in the main method and took the gathered input
 * as an argument. This was changed because I ran into issues that I don't know how to fix
 * with my current understanding of the Java language.
 *
 */
	public static int gatherUserInput() {
		// This will be assigned to the captured user input
		int userInput;
		/*
		 * Create an instance of the Scanner class, passing it an input of System.in
		 * and then store the resulting Object from that instantiation as the variable --input--.
		 */
		Scanner input = new Scanner(System.in);
		try {
			// Prompt the user to input a weight and then capture their input.
			System.out.println("Please enter the number of pounds you want converted to ounces.");
			// Scans the next token of the input as an integer.
			userInput = input.nextInt();
			
			if (userInput > 0 ) {
				return userInput;
			} else {
				throw new InputMismatchException();
			}
			
		} catch (InputMismatchException error) {
			// Format the error logging to look nicer, since stack trace was printing crammed again
            // the previous print above.		
			System.err.println("");
			error.printStackTrace();
			System.err.println("Please provide a number greater than 0.");
			// Recursively call if there was an invalid input
			userInput = gatherUserInput();
		} finally {
			// We have to close our Scanner due to a memory leak warning I was receiving.
			input.close();
		}
		// return the user input
		return userInput;
	}

	/*
	 *	Create a method responsible for handling the logic of converting 
	 *  pounds to ounces. This method receives an amount of pounds and returns
	 *  the numerical equivalent in ounces. This is a good pattern to have, so I can
	 *  extend the functionality of this converter class to have other methods which do
	 *  other types of weight conversions besides pounds to ounces.
	 */
	public static int poundsToOunces(int pounds) {
		return pounds * 16;
	}
	
	// Prints our output
	public static void printAnswer(int input, int output) {
		/* Print the desired statement.			
		 * e.g. Pounds entered: 4
		 * 		4 pounds is 64 ounces.
		 * NOTE: FIND OUT IF TEACHER PREFERS LONG STRINGS BROKEN INTO MULTI-LINE STATEMENTS
		 */
		System.out.println("Pounds entered: " + input + "");
		System.out.println(input + " pounds is " + output + " ounces.");
	}	
	
}
