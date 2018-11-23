package classes;

/*
Nicholas Fleischhauer
CIS 254
Assignment 8.1
November, 12 2018
Instructor: Dave Harden

TODO: • clean up later
	    • change "about" to markdown
	    • add handling for mixed fractions
	    • add better comments
	    • Change divideBy to just call an inverse function of an add.
	    • Change subtract to just call a negation function of an add


# Prompt
  Write a Fraction class whose objects will represent fractions. You should provide the following class methods:
  Two constructors, a parameter-less constructor that assigns the value 0 to the Fraction, and a constructor that takes two parameters.
  The first parameter will represent the initial numerator of the Fraction, and the second parameter will represent the initial denominator
  of the Fraction. Arithmetic operations that add, subtract, multiply, and divide Fractions. These should be implemented as value returning
  methods that return a Fraction object. They should be named addedTo, subtract, multipliedBy, and dividedBy.
  A boolean operation named isEqualTo that compares two Fraction objects for equality. An output operation named print that displays the
  value of a Fraction object on the screen in the form numerator/denominator.
  Your class should have exactly two private data members, one to represent the numerator of the fraction being represented, and one to represent
  the denominator of the fraction being represented.

## About 
  This application does arithmetic on fractions. It doesn't handle negative numbers,
  or bother to convert into mixed numbers.
  
*/

public class Fraction {
	private int numerator;
	private int denominator;
	
	// Constructor overloading
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	

	
	
	
	// Constructor overloading
	public Fraction() {
		this(0,1);
	}
	
	
	
	
	
	
	// Adds two fractions. Uses the commonDenominator method, a simplication check method,
	// and a simplify method.
	public Fraction addedTo(Fraction b) {
		int lcd = commonDenominator(this.denominator,b);

		Fraction c = new Fraction();
		c.numerator = (this.numerator * b.denominator) + (b.numerator * this.denominator);
		c.denominator = lcd;
		
		c = simplify(c);
		
		return c;
	}
	
	
	
	
	
	
	// Subtracts two fractions. Uses the commonDenominator method, a simplication check method,
	// and a simplify method.
	public Fraction subtract(Fraction b) {
		int lcd = commonDenominator(this.denominator,b);
		
		Fraction c = new Fraction();
		c.numerator = (this.numerator * b.denominator) - (this.denominator * b.numerator);
		c.denominator = lcd;
		
		c = simplify(c);

		return c;
	}
	
	
	
	
	
	
	// Multiplies fractions and uses a simplification check method and a simplify method.
	public Fraction multipliedBy(Fraction b) {	
		Fraction c = new Fraction();
		c.numerator = this.numerator * b.numerator;
		c.denominator = this.denominator * b.denominator;
		
		c = simplify(c);
		
		return c;
	}
	
	
	
	
	
	
	// CROSS MULTIPLYING HERE
	//Divides fractions and uses a simplification check method and a simplify method.
	public Fraction dividedBy(Fraction b) {
		Fraction c = new Fraction();
		c.numerator = this.numerator * b.denominator;
		c.denominator = this.denominator * b.numerator;
		
		c = simplify(c);
		
		return c;
	}
	
	
	
	
	
	
	// My newer simplification method. This one will find the smaller of the numerator and denominator and 
	// use that as the value for the modulus operator. I use it to check if both the numerator and denominator 
	// are divisible by that current value. If not, we decrement one at a time until we find the greatest common
	// divisor. One that is found, we divide them both by that GCD and set the values for numerator and denominator
	// appropriately.
	public Fraction simplify(Fraction fraction) {
		// For enhanced readability.
		int numerator = fraction.numerator;
		int denominator = fraction.denominator;
		int mod = numerator > denominator ? denominator : numerator;
				
		// Edge case
		if (numerator / denominator == 1) {
			fraction.numerator = 1;
			fraction.denominator = 1;
		}
		
		while (true) {
			if (numerator % mod == 0 && denominator % mod == 0) {
				fraction.numerator = numerator / mod;
				fraction.denominator = denominator / mod;
				break;
			}
			mod--;
		}
		return fraction;
	}
	
	
	
	
	
	
	// Checks if two fractions are equal to each other. I think this should be changed to
	// this.equals(b) instead?
	public boolean isEqualTo(Fraction b) {
		// or return this.equals(b)?
		return this.numerator / this.denominator == b.numerator / b.denominator;
	}
	
	
	
	
	
		
	// Prints the fraction contained in each fraction instance
	public void print() {
		System.out.println(this.numerator + "/" + this.denominator);
	}
	
	
	
	
	
	
	// 
	public int commonDenominator(int a,Fraction b) {
			int lcd = a * b.denominator;
			return lcd;
	}
	
	
	
	
	
			
	// This was for me when I was doing my own testing.
	@Override
	public String toString() {
		return "Numerator: " + this.numerator + " Denominator: " + this.denominator;
	}
}

//class Test {
//	public static void main(String args[]) {
//	        Fraction f1 = new Fraction(9,8);
//	        Fraction f2 = new Fraction(2,3);
//	        Fraction result = new Fraction();
//
//	        System.out.print("The result starts off at ");
//	        result.print();
//	        System.out.println();
//
//	        System.out.print("The product of ");
//	        f1.print();
//	        System.out.print(" and ");
//	        f2.print();
//	        System.out.print(" is ");
//	        result = f1.multipliedBy(f2);
//	        result.print();
//	        System.out.println();
//
//	        System.out.print("The quotient of ");
//	        f1.print();
//	        System.out.print(" and ");
//	        f2.print();
//	        System.out.print(" is ");
//	        result = f1.dividedBy(f2);
//	        result.print();
//	        System.out.println();
//
//	        System.out.print("The sum of ");
//	        f1.print();
//	        System.out.print(" and ");
//	        f2.print();
//	        System.out.print(" is ");
//	        result = f1.addedTo(f2);
//	        result.print();
//	        System.out.println();
//
//	        System.out.print("The difference of ");
//	        f1.print();
//	        System.out.print(" and ");
//	        f2.print();
//	        System.out.print(" is ");
//	        result = f1.subtract(f2);
//	        result.print();
//	        System.out.println();
//
//	        if (f1.isEqualTo(f2)){
//	            System.out.println("The two Fractions are equal.");
//	        } else {
//	            System.out.println("The two Fractions are not equal.");
//	        }
//	        
//	        Fraction f3 = new Fraction(12, 8);
//	        Fraction f4 = new Fraction(202, 303);
//	        result = f3.multipliedBy(f4);
//	        System.out.print("The product of ");
//	        f3.print();
//	        System.out.print(" and ");
//	        f4.print();
//	        System.out.print(" is ");
//	        result.print();
//	        System.out.println();
//	}
//}


/*

The result starts off at 0/1

The product of 9/8
 and 2/3
 is 3/4

The quotient of 9/8
 and 2/3
 is 27/16

The sum of 9/8
 and 2/3
 is 43/24

The difference of 9/8
 and 2/3
 is 11/24

The two Fractions are not equal.
The product of 12/8
 and 202/303
 is 1/1
 
 * */

