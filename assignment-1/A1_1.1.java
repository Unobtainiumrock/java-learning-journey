// package statements;

/* Create a public class for printing statements.
 */
public class GenerateStatement {
//	This is the main method. It is automatically invoked.
	public static void main(String[] args) {
/*		a) Produce the following screen output using one statement.
 *	    Tran says this is her first computer program.
 */
		System.out.println("Tran says this is her first computer program.");// This is the single statement.
		// These are added to provide some visual space between this answer and subsequent answers.
		System.out.println("");
		
/*     b) Produce the following screen output using two statements.
 *        Tran says this is her 
 *        first computer program.
 */		
		System.out.println("Tran says this is her ");// Statement one
		System.out.println("first computer program.");// Statement two
		System.out.println("");
		
//	   c) Produce the screen output from part b), but use only one statement.	
		System.out.println("Tran says this is her\nfirst computer program.");// This is the single statement.
		System.out.println("");
		
/*     d) Produce the screen output from part a), but use two statements
 *		(use each statement to produce about half of the output).
 */
		String firstHalf = "Tran says this is her"; // Statement one.
		System.out.println(firstHalf + " first computer program.");// Statement two.
	}	
}

/* Outputs for the code above is the following:
 * 
 * Tran says this is her first computer program.
 *
 * Tran says this is her 
 * first computer program.
 *
 * Tran says this is her
 * first computer program.
 *
 * Tran says this is her first computer program.
 * 
 * */
