/*
Nicholas Fleischhauer
CIS 254
Assignment 7.1
October, 7 2018
Instructor: Dave Harden

This program draws a rocket based on dimensions provided by a user. Sometimes I will interchangeably 
refer to stages as segments or vice versa.

The user can provide the following for dimensions:
  1. Height of each rocket stage
  2. Width of each rocket stage
  3. Number of rocket stages
*/

import java.util.Scanner;


public class A7_1 {

public static int rocketStageWidth;
public static int rocketStageHeight;
public static int numberOfRocketStages;


private static Scanner input = new Scanner(System.in);

/*
 * This main method gathers the inputs from the user and initiates the building
 * of the rocket.
 */
public static void main(String[] args) {
  gatherDimensions();
  drawRocket();
}






/*
 * This method is used to gather the dimensions for each rocket stage and the
 * number of rocket stages. I also broke this out into a separate method to keep the main method
 * as clean and clear as possible with strictly method calls.
 */
public static void gatherDimensions() {
  System.out.print("Please provide the width of the rocket's stages (integer greater than 1): ");
  rocketStageWidth = input.nextInt();
  System.out.print("Please provide the height of the rocket's stages (ingeger greater than 1): ");
  rocketStageHeight = input.nextInt();
  System.out.print("Pleasue provide the number of rocket stages: ");
  numberOfRocketStages = input.nextInt();
}






/*
 * This method calls all the necessary methods to build our rocket. I made this
 * method because its a much clearer name for indicating what is actually being
 * drawn, plus it keeps the main method less cluttered.
 */
public static void drawRocket() {

  if (rocketStageWidth == 1) {
    System.out.println("You can't have a rocket with a width or height of 1 or less.");
    System.out.println("Please provide different dimensions");
    main(args);
  }

  drawCone();
  drawBoxes();
  drawCone();
}






/*
 * This method prints a cone for our rocket drawing. The printed cone will have
 * a format that visually matches the ones outlined below when I was determining the pattern.
 */
public static void drawCone() {
  boolean even = rocketStageWidth % 2 == 0; // true when even, false when odd
  int coneRowCount = (int) (even ? rocketStageWidth / 2 : Math.floor(rocketStageWidth / 2) + 1); // Algorithm mentioned by teacher, verified by my psuedocoding and white boarding the problem below.
  int startingCount = even ? 2 : 1; // 2 when true, 1 when false. This is used to determine spacing between cone edges.

  shiftToTheRight(coneRowCount);// This is because the coneRowCount is equal to initial rightward spacing and then each subsequent rightward spacing is one less than the previous. (Also verified by my notes at the bottom of this file).
  drawCapStone(even);

  for (int i = 1; i < coneRowCount; i++) {
    shiftToTheRight(coneRowCount - i); // This is because the coneRowCount is equal to initial rightward spacing and then each subsequent rightward spacing is one less than the previous. (Also verified by my notes at the bottom of this file).
    drawOneRow(startingCount); // Depending on if its even or odd, it goes 1,3,5,7 or 2,4,6,8
    startingCount += 2; // Increment by 2 because [1,2,3] for each +2 is [3,5,7] and [2,4,6] for each + 2 is [4,6,8]. This is how we get accurate spacing for each cone row.
  }

}






/*
  This method places the top portion of the rocket cone based on whether the rocket width is even
  or odd.
*/
public static void drawCapStone(boolean even) {
  if (even) {
    System.out.println("**");
  } else {
    System.out.println("*");
  }
}






/*
  This method is used to determine the number of spaces to the right that each row
  of the cone should shift over.
*/
public static void shiftToTheRight(int coneRowCount) {
  int numberOfSpaces = coneRowCount;
  for (int i = 0; i < numberOfSpaces - 1; i++) {
    System.out.print(" ");
  }
}






/*
  This method draws a series of rocket segments by calling a series of other methods N number of times,
  where N = numberOfRocketStages.
  The first method call creates a horizontal line,
  the second call creates two vertical lines,
  and the final call creates another horizontal line.
*/
public static void drawBoxes() {
  for (int boxCount = 0; boxCount < numberOfRocketStages; boxCount++) {
    drawHorizontalLine();
    draw2VerticalLines();
    drawHorizontalLine();
  }
}






/*
  This method will draw horizontal lines in size equal to the user's provided rocket stage width. It 
  accomplishes this by using a print statement within a loop that runs N number of times,
  where N = rocketStageWidth.
*/
public static void drawHorizontalLine() {
  for (int count = 0; count < rocketStageWidth; count++) {
    System.out.print("*");
  }
  System.out.println();
}






/*
  This method draws two vertical lines by building one row at a time equal to the user's provided
  rocket stage height. It accomplishes this by calling the drawOneRow method within a loop that runs
  N number of times, where N = rocketStageHeight - 2. We subtract two, since the two horizontal lines
  (top and bottom) account for at least two increments in the total height of a rocket's individual
  stages. 
*/
public static void draw2VerticalLines() {
  for (int rowCount = 0; rowCount < rocketStageHeight - 2; rowCount++ ) {
    drawOneRow(rocketStageWidth - 2); // To account for the automatically provided edges.
  }
}





/*
  This method draws a single row equal in length to the user's provided gapNumber.
  It accomplishes this by using a loop which runs N number of time, where 
  N = gapNumber.
*/
public static void drawOneRow(int gapNumber) {

  System.out.print("*");
  for (int spaceCount = 0; spaceCount < gapNumber; spaceCount++) {
    System.out.print(" ");
  }
  System.out.println("*");
}

}


// Two example outputs (one for even and one for odd). Feel free to try our own dimensions and see other possible outputs.
/*

Please provide the width of the rocket's stages: 7
Please provide the height of the rocket's stages: 5
Pleasue provide the number of rocket stages: 2
   *
  * *
 *   *
*     *
*******
*     *
*     *
*     *
*******
*******
*     *
*     *
*     *
*******
   *
  * *
 *   *
*     *




Please provide the width of the rocket's stages: 6
Please provide the height of the rocket's stages: 5
Pleasue provide the number of rocket stages: 2
  **
 *  *
*    *
******
*    *
*    *
*    *
******
******
*    *
*    *
*    *
******
  **
 *  *
*    *


*/






// PSEUDOCODE/WHITE BOARD SESSION DATA/NOTES

/*

 ** 0 inner gaps, 1 rightward shifts  <- cone (since its hard to tell here)
 ** 1 inner gap, 1 rightward shift
 **
 **
 **
 ** <- cone (since its hard to tell here)

*/

//Width = 3, segment height = 4 , cone rows = 2, segements 1
/*

  *  0 inner gaps, 2 rightward shifts
 * * 1 inner gap, 1 rightward shift
 *** 
 * *
 * *
 ***
  *
 * *

*/

//W = 4, segment height = 4, cone rows = 2, segments 1

/* 

  ** 0 inner gaps, 2 rightward shifts
 *  * 2 inner gaps, 1 rightward shift
 ****
 *  *
 *  *
 ****
  **
 *  *

*/

//W = 5, segment height = 4, cone rows = 3, segments 1

/* 

   * 0 inner gaps, 3 rightward shifts
  * * 1 inner gap, 2 rightward shifts
 *   * 3 inner gaps, 1 rightward shift
 *****
 *   *
 *   *
 *****
   *
  * *
 *   *

*/

//W = 6, segment height = 4, cone rows = 3, segments 1

/* 

   ** 0 inner gaps, 3 rightward shifts
  *  * 2 inner gap, 2 rightward shifts
 *    * 4 inner gaps, 1 rightward shift
 ******
 *    *
 *    *
 ******
   **
  *  *
 *    *

*/

//The pattern appears to be that the first rows shift is N times to the right, where 
//N = number of cone rows. This N decrements on each subsequent row in terms of rightward shifts.
//The other pattern is that for odd widths, the number of gaps follows a 1,3,5,7 pattern, and even widths
//for gaps follow a 2,4,6,8 pattern.
