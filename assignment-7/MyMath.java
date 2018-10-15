package math;

/*
  Nicholas Fleischhauer
  CIS 254
  Assignment 7.2
  October, 15 2018
  Instructor: Dave Harden

  I've started to add markdown style stuff, so I can easily copy and paste this into README.md's for when
  I push solutions to GitHub.

  # What it is
  This file contains the MyMath class with methods to determine if a given number is prime or perfect.
  I've tried to make them as time complexity efficient as I could. I was too lazy to determine their exact 
  speeds, but I think one might run O(log(n)).

  ## Getting Started
  This file's code is used by the code inside `MyMathTest.java`. The files are linked via
  a package named `math`. Refer to the `Getting started` section inside of `MyMath.Test.java`.

  **note: the behavior of this program is detailed in depth on each method. Refer below for code behavior.**
*/

public class MyMath {
		
	/*
	 * This method will iterate n times, where n =  half of the range of numbers from 1 to the currentNumber.
	 * (currentNumber is equal to the number in the series of 1 to 1,000).
	 * It checks two values at a time and if either of those values are factors of the 
	 * currentNumber, they get added to a sum tracker. The integer 1 is already included
	 * and the currentNumber itself is excluded. If the sum of all factors for a current
	 * number are equal to the current number, we have a perfect number.
	 */
    public static boolean isPefect(int currentNumber) {
	    int sum = 1;
	    int evenHalfWayPoint = currentNumber / 2;
	    int oddHalfWayPoint = (int) Math.floor(evenHalfWayPoint);
	    int oddExactMiddle = oddHalfWayPoint + 1; // exact middle in a series of odd numbers.
	    int countDownFrom = currentNumber - 1; // We exclude the number itself.
	    int countUpFrom = 2; // 1 is included automatically.
	    int iterateUpTo;
	    
	    // We iterate up to and INCLUDING currentNumber / 2 if even and
	    // currentNumber / 2 floored if odd.	    
	    if (currentNumber % 2 == 0) {
	    	iterateUpTo = evenHalfWayPoint;
	    } else {
	    	iterateUpTo = oddHalfWayPoint;
	    		
	    	// Check if the currentNumber has oddExactMiddle as a factor and
	    	// add it to the sum if it is.
	    	if (currentNumber % oddExactMiddle == 0) {
	    		sum += oddExactMiddle;
	    	}
	    }
	   
	    while (countUpFrom <= iterateUpTo) {
	    	// Check if the currentNumber has countUpFrom as a factor.
	    	if (currentNumber % countUpFrom == 0) {
	    		sum += countUpFrom;
	    	}
	    	
	    	// Check if the currentNumber has countDownFrom as a factor.
	    	if (currentNumber % countDownFrom == 0) {
	    		sum += countDownFrom;
	    	}
	    	
	    	countUpFrom++;
	    	countDownFrom--;
	    }
	    return sum == currentNumber;
    }

 
	
	
	
/*
 * This method iterates n times where n = 2 - the floored square root our currentNumber.
 * (currentNumber is equal to the number in the series of 1 to 10,000). The reason we do this is
 * because if a prime number is defined as P = 1 * P, then a non-prime number is defined
 * as a number with any two factors that aren't 1 and P or.. NP = a * b.
 * If both a and b were greater than the square root of a given number, then their
 * product would be larger than the current number. So a or be can either be less than
 * or equal to the floored square root of a given number. Each iteration of the loop
 * checks if the currentNumber has i as a factor. If the modulus of 
 * anything other than 1 or currentNumber is 0, then that means there's factors, so 
 * it isn't prime.
 */
    public static boolean isPrime(int currentNumber) {
	   double limit = Math.floor(Math.sqrt(currentNumber));
	
	   for (int i = 2; i <= limit; i++) {
		   if (currentNumber % i == 0) {
			   return false;
		   }
	   }
	   return true;
    }
 
}

/*
  REFER TO MyMathTest.java for copy & pasted outputs. 
*/

