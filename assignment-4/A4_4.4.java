import java.util.Scanner;
import java.text.NumberFormat; // Source: https://docs.oracle.com/javase/7/docs/api/java/text/NumberFormat.html

/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
    9/17/2018
    
    What it does
    ------------
    This is a short program for calculating the gross and net cost of a given phone bill. Originally I had
    misread the prompt as the 50% discount happening if the call hours began on or after 1800 AND ENDED
    before 0800. I was proud of my use of the do while loop in the time conversion function,
    so I commented it out and left it here to share.

    note: I had a really ugly way of formatting the currency before, and opted to dive into Java's docs
    for a cleaner approach. I was originally using the line below to handle for net cost, but the ugly 
    way I was hanlding adding a zero to numbers like $26.80 was not ideal.
    
    System.out.println("Net cost: $" + Math.round(netCost * 100.0) / 100.0) 

    What it utilizes
    ----------------
    This utilizes java.util.Scanner class to gather the user's inputs via CLI.
    It also utilizes java.text.NumberFormat; a number formatter to format the currency in a much cleaner way to read. 
*/

public class CallRates {
	
	static int startTime;
//	static int endTime;
	static int callByMinutes;
	static double grossCost;
	static double netCost;
	public static final double SAN_FRANCISCO_TO_MIAMI_RATE = 0.4; 
	public static final double FEDERAL_TAXES = 1.04;
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		getCallInfo();
		calculateGross();
		applyDiscounts();
		applyTaxes();
		getPhoneBill();
	}
	
	public static void getCallInfo() {
		System.out.print("Enter start time in 24-HR clock format (use 24:00 instead of 00:00 for midnight): ");
		startTime = input.nextInt();
		System.out.print("Enter length of call in minutes: ");
		callByMinutes = input.nextInt();
//		endTime = handleCallTimes();
	}
	
//	public static int handleCallTimes() {
//		int convertedTime = minutesToMilitaryTime(callByMinutes);
//		if (startTime + convertedTime > 2400) {
//			return (startTime + convertedTime) - 2400;
//		} else {
//			return startTime + convertedTime;
//		}
//	}
//	
//	public static int minutesToMilitaryTime(int minutes) {
//		int minutesRemaining = minutes;
//		int converted = 0;
//		
//		do {
//			converted += 100;
//			minutesRemaining -= 60;
//		} while (minutesRemaining - 60 > 0);
//		
//		converted += minutesRemaining;
//		return converted;
//	}
	
	public static void setCosts() {
		grossCost = SAN_FRANCISCO_TO_MIAMI_RATE * callByMinutes;
		netCost = grossCost;
	}
	
	public static void applyDiscounts() {
		if (startTime >= 1800 || startTime < 800 ) {
			netCost = netCost - (netCost * 0.5);
		}
			
		if (callByMinutes > 60) {
			netCost = netCost - (netCost * 0.15);
		}
		
	}
	
	public static void applyTaxes() {
		netCost *= FEDERAL_TAXES;
	}
	
	public static void getPhoneBill() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String grossAsString = formatter.format(grossCost);
		String netAsString = formatter.format(netCost);
		System.out.println("Gross cost: " + grossAsString);
		System.out.println("Net cost: " + netAsString);
	}
	
}

/*
  Sample output 1:

    Enter start time: 2322
    Enter length of call in minutes: 67    
    gross cost: $26.80
    net cost: $11.85
Sample output 2:

    Enter start time: 759
    Enter length of call in minutes: 10    
    gross cost: $4.00
    net cost: $2.08
Sample output 3:

    Enter start time: 1300
    Enter length of call in minutes: 100    
    gross cost: $40.00
    net cost: $35.36
Sample output 4:

    Enter start time: 1300
    Enter length of call in minutes: 10    
    gross cost: $4.00
    net cost: $4.16
*/
