import java.util.Scanner;

/*
 	A2_1.java
 	Nicholas Fleischhauer
    CIS 254
    Theater Exercise
    9/19/2018
    
    What it does
    ------------
    This program takes in the age and snack preference of multiple people entered by the program user.
    After the program user decides there is no more information to input,
    they enter an integer less than 0 to quit entering user information. It then prints out
    details about the amounts of people, average age/youngest/oldest, and snack preferences.

    What it utilizes
    ----------------
    - java.util.scanner
    - while loop
    - if/else statements
    - switch/case statements
*/

public class TheaterAttendees {

  private static Scanner input = new Scanner(System.in);
  private static String mainMenuChoice;

  private static int age;
  private static String snackPreference;

  // For tracking ages within a range.
  public static int zeroToEighteen = 0; // 0 - 18
  public static int nineteenToThirty = 0; // 19 - 30
  public static int thirtyOneToForty = 0; // 31 - 40
  public static int fortyOneToSixty = 0; // 41 - 60
  public static int overSixty = 0; // age > 60

  // For tracking concessions.
  public static int popcorn = 0;
  public static int soda = 0;
  public static int both = 0;

  // For averaging
  static int totalAge = 0;
  static int totalPeople = 0;

  // For tracking youngest and oldest
  public static int youngest = 0;
  public static int oldest = 0;

  public static void main(String[] args) {
    startProgram();
  }

  public static void startProgram() {

    System.out.print("Enter age of attendee (negative number to quit): ");
    age = input.nextInt();
    youngest = age;
    oldest = age;
    
    while (age > 0) {
      System.out.print("Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): ");
      snackPreference = input.next().toLowerCase();

      addCustomer(age, snackPreference);

      System.out.print("Enter age of attendee (negative number to quit): ");
      age = input.nextInt();
    }

    if (totalPeople == 0) {
      System.out.println("Goodbye!");
    } else {
      printAttendeeInfo();
    }
    input.close(); // Is this necessary? I don't get resouce leak warnings when I place a Scanner instance
                  //  outside of a method. If so, why?
  }

  public static void addCustomer(int age, String preference) {

    // For averaging
    totalAge += age;
    totalPeople++;

    switch (preference) {
    case "s":
      soda++;
      break;
    case "p":
      popcorn++;
      break;
    case "b":
      both++;
      break;
    default:
      popcorn++; // I <3 popcorn!
    }

    if (age > oldest) {
      oldest = age;
    }

    if (age < youngest) {
      youngest = age;
    }

    if (age >= 0 && age <= 18) {
      zeroToEighteen++;
    }

    if (age >= 19 && age <= 30) {
      nineteenToThirty++;
    }

    if (age >= 31 && age <= 40) {
      thirtyOneToForty++;
    }

    if (age >= 41 && age <= 60) {
      fortyOneToSixty++;
    }

    if (age > 60) {
      overSixty++;
    }
  }

  public static void printAttendeeInfo() {
    System.out.println("");
    System.out.println("age 0  to 18: " + zeroToEighteen);
    System.out.println("age 19 to 30: " + nineteenToThirty);
    System.out.println("age 31 to 40: " + thirtyOneToForty);
    System.out.println("age 41 to 60: " + fortyOneToSixty);
    System.out.println("over 60: " + overSixty);
    System.out.println("");
    System.out.println("food preference popcorn: " + popcorn);
    System.out.println("food preference soda: " + soda);
    System.out.println("food preference both: " + both);
 // Should also wrap the totalAge/totalPeople in a Math.floor()
 //	I removed it because the exact output was 36.0 and not 36 which wouldn't match the desired output. 
    System.out.println("The average age was " + (totalAge / totalPeople));
    System.out.println("The youngest person in attendance was " + youngest);
    System.out.println("The oldest person in attendance was " + oldest);
  }
}

/*
  Enter age of attendee (negative number to quit): 34
  Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): s
  Enter age of attendee (negative number to quit): 16
  Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): b
  Enter age of attendee (negative number to quit): 68
  Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): b
  Enter age of attendee (negative number to quit): 53
  Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): s
  Enter age of attendee (negative number to quit): 39
  Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): p
  Enter age of attendee (negative number to quit): 23
  Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): s
  Enter age of attendee (negative number to quit): 21
  Enter food preference ('p' for popcorn, 's' for soda, 'b' for both): s
  Enter age of attendee (negative number to quit): -1

  age 0  to 18: 1
  age 19 to 30: 2
  age 31 to 40: 2
  age 41 to 60: 1
  over 60: 1
  
  food preference popcorn: 1
  food preference soda: 4
  food preference both: 2
  The average age was 36
  The youngest person in attendance was 16
  The oldest person in attendance was 68
*/
