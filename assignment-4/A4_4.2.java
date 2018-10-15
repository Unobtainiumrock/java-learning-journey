import java.util.Scanner;

/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
    9/17/2018
    
    What it does
    ------------
    Asks a user to provide the years they've attended school and gives them an ouput indicating what
    their level of education is. The problem with this however, is that the years somebody has gone to
    school does not always reflect their level of education. For example, some people could repeat an
    udetermined amount of years in a specific grade.
    
    What it utilizes
    ----------------
    This utilizes java.util.Scanner class to gather the user's inputs via CLI.
    
*/

public class EducationLevel {

  static int years;
  static String educationLevel;
  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    getYears();
    determineEducationLevel();
    printResults();
  }

  public static void getYears() {
    System.out.print("Please enter the number of years you've attended school: ");
    years = input.nextInt();
  }

  public static void determineEducationLevel() {
    // Less than or equal to 0
    if (years <= 0) {
      educationLevel = "none";
    }

    if (years >= 1 && years <= 6) {
      educationLevel = "elementary school";
    }
    
    if (years >= 7 && years <= 8) {
      educationLevel = "middle school";
    }

    if (years >= 9 && years <= 12) {
      educationLevel = "high school";
    } 

    if (years > 12) {
      educationLevel = "college";
    }  

  }

  public static void printResults() {
    System.out.println("Your level of education is: " + educationLevel);
  }

}

// Sample screen output
/*
  Please enter the number of years you've attended school: 8
  Your level of education is: middle school 
 */
