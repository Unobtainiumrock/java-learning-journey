import java.util.Scanner;

/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
    9/17/2018
    
    What it does
    ------------
    Asks the user to provide a letter for the shape type that they want to compute an area for.
    Once a user provides a shape type, it will ask for specific dimensions to compute the desired
    shape's area. I didn't bother handling for bad inputs as it was not outlined as a requirement.
    This was set up in manner in which you can easily add additional methods for more shapes.
    Aside from creating a new method for additional shapes, you have to add an additional if statement
    to the computeArea method. 
    
    What it utilizes
    ----------------
    - java.util.Scanner class for hanlding user input via CLI.
    - A single ComputeShapeArea class with methods for handling logic specific to their name.

    Learning point
    --------------
    I just realized that I should make the Scanner a static variable to avoid passing it into various methods
    like I had done in previous assignments. I like how much cleaner it is to do this
    than my previous approach.
    
*/

public class ComputeShapeArea {
	
	static String shapeType;
	static double area;
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		getShapeType();
		computeArea();
		printResults();
		input.close();
	}

	public static void getShapeType() {
		System.out.print("Enter the type of figure (s or t): ");
		shapeType = input.next().toLowerCase();	
	}
	
	public static void computeArea() {
		if (shapeType.equals("t")) {
			area = computeTriangleArea();
		}
		
		if (shapeType.equals("s")) {
			area = computeSquareArea();
		}
	}
	
	
	public static double computeTriangleArea() {
		double base = 3;
		double height;
		System.out.print("Enter the base: ");
		base = input.nextDouble();
		System.out.print("Enter the height: ");
		height = input.nextDouble();
		return .5 * base * height;
	}
	
	public static double computeSquareArea() {
		double sideLength;
		System.out.print("Enter the length of a side: ");
		sideLength = input.nextDouble();
		return Math.pow(sideLength, 2);	
	}
	
	public static void printResults() {
		System.out.println("The area is " + area);
	}
	
}

/* Sample screen output 1:

       Enter the type of figure (s or t): t    
       Enter the base: 4
       Enter the height: 3
       The area is 6
   Sample screen output 2:

       Enter the type of figure (s or t): s    
       Enter the length of a side: 9
       The area is 81
*/
